package de.cellent.test.timerService;

import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@LocalBean
@Singleton
public class JobBTimerBean extends AbstractJobTimer {
	
	// here it happens
	@Timeout
	public void execute(Timer timer) {
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Execution Time : " + new Date());
		System.out.println("____________________________________________");
	}
}
