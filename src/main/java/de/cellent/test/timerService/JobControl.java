package de.cellent.test.timerService;

import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Timer;

/**
 * Just the common interface
 * @author mbohnen
 *
 */
public interface JobControl {
	
	public void start(String timerName, long interval);
	public Collection<Timer> getAllTimers();
	void stop(String timer);
}
