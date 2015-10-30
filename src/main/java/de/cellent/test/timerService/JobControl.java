package de.cellent.test.timerService;

import java.util.Collection;

import javax.ejb.Timer;

public interface JobControl {
	
	public void execute(Timer timer);
	public void start(long interval); 
	public void stop();
	public boolean isRunning();
	
	public String getTimerInfo();
}
