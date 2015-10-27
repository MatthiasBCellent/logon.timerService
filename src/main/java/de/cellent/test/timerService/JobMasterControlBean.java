package de.cellent.test.timerService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Remote(JobMasterControl.class)
@Singleton
@Startup
public class JobMasterControlBean extends AbstractJobTimer implements JobMasterControl {
	
	@Resource
	private TimerService timerService;
	
	@EJB
	private JobATimerBean jobA;
	
	@EJB
	private JobBTimerBean jobB;

	@Timeout
	public void execute(Timer timer) {
		System.out.println("going to work");	
	}
	
	@PostConstruct
	private void init() {
		this.start(this.getClass().getSimpleName(), 2000);
	}
}
