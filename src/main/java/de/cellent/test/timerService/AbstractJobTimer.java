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

	private Timer timer; 
	
	private boolean running;
	
	//implement this
	@Timeout
	public abstract void execute(Timer timer);
	
	public void start(long interval) {
		timerConfig.setInfo(this.getClass().getSimpleName());
		timerConfig.setPersistent(false);
		timer = timerService.createIntervalTimer(new Date(System.currentTimeMillis()), interval, timerConfig);
		this.running = true;
	}

	public final Collection<Timer> getAllTimers() {
		return this.timerService.getAllTimers();
	}

	public void stop() {
		this.timer.cancel();
		this.running = false;
	}
	
	public String getTimerInfo() {
		return timer.getInfo().toString();
	}

	public boolean isRunning() {
		return running;
	}	
}
