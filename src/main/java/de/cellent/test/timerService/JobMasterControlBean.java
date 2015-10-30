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

/**
 * @see Tron
 * @author mbohnen
 *
 */
@Remote(JobMasterControl.class)
@Singleton
//@Startup // activate only if u want to make it run automatically
public class JobMasterControlBean extends AbstractJobTimer implements JobMasterControl {
	
	@Resource
	private TimerService timerService;
	
	@EJB
	private JobATimerBean jobA;
	
	@EJB
	private JobBTimerBean jobB;

	@Timeout
	public void execute(Timer timer) {
		// FIXME check system.properties for other timers to wake up
		System.out.println("I should look for system.properties now ...");	
	}
	
//	@PostConstruct // use only in case of @Startup
	private void init() {
		this.start(2000);
	}	
}
