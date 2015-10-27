package de.cellent.test.timerService;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

public abstract class AbstractJobTimer implements JobControl {

	@Resource
	protected TimerService timerService;

	protected TimerConfig timerConfig = new TimerConfig();
	protected ScheduleExpression schedule; 
	
	//implement this
	@Timeout
	public abstract void execute(Timer timer);
	
	public void start(String timerName, long interval) {
		timerConfig.setInfo(timerName);
		timerConfig.setPersistent(false);
		timerService.createIntervalTimer(new Date(System.currentTimeMillis()), interval, timerConfig);
	}

	public Collection<Timer> getAllTimers() {
		return this.timerService.getAllTimers();
	}

	public void stop(String timer) {
		for (Timer t : timerService.getTimers()) {
			if (t.getInfo().equals(timer)) {
				t.cancel();
			}
		}
	}
}
