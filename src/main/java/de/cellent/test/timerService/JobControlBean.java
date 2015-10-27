package de.cellent.test.timerService;

import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Singleton
@Remote(JobControl.class)
//if to be started automatically
// @Startup
public class JobControlBean implements JobControl {

	@Resource
	private TimerService timerService;

	private TimerConfig timerConfig;
	private ScheduleExpression schedule;

	// if to be started automatically
	@PostConstruct
	private void init() {
		timerConfig = new TimerConfig();
//		timerConfig.setInfo("TimerDemo_Info");
//		timerConfig.setPersistent(false);
//		schedule = new ScheduleExpression();
//		schedule.hour("*").minute("*").second("13,34,57");
//		timerService.createCalendarTimer(schedule, timerConfig);
	}

	@Timeout
	public void execute(Timer timer) {
		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Execution Time : " + new Date());
		System.out.println("____________________________________________");
	}

	public void stop(String timerName) {
		for (Object obj : timerService.getTimers()) {
			Timer t = (Timer) obj;
			if (t.getInfo().equals(timerName)) {
				t.cancel();
			}
		}
	}

	public void start(String timerName, long interval) {
		timerConfig.setInfo(timerName);
		timerService.createIntervalTimer(new Date(System.currentTimeMillis()), interval, timerConfig);
	}
	
	public Collection<Timer> getAllTimers() {
		return this.timerService.getAllTimers();
	}
}
