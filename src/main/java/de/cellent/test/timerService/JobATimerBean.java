package de.cellent.test.timerService;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;

@LocalBean
@Singleton
public class JobATimerBean extends AbstractJobTimer {
	
	// here it happens
	@Timeout
	public void execute(Timer timer) {
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Timer Service : " + timer.getInfo());
		System.out.println("Execution Time : " + new Date());
		System.out.println("____________________________________________");
	}
}
