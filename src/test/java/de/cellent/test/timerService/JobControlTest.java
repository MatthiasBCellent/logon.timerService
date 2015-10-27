package de.cellent.test.timerService;

import java.util.Collection;

import javax.ejb.Timer;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JobControlTest {

	private static InitialContext ctx;
	private static JobControl jc;

	public static void main(String[] args) {
		JobControlTest.setUp();
		
		JobControlTest test = new JobControlTest();
//		test.testStart();
//		test.testGetTimerInfo();
		test.testStop();
	}
	
	@BeforeClass
	public static void setUp() {
		try {
			ctx = new InitialContext();
			jc = (JobControl) ctx.lookup("ejb:/timerService-0.0.1-SNAPSHOT/JobMasterControlBean!de.cellent.test.timerService.JobMasterControl");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testStart() {
		jc.start(1000);
	}
	
	@Test
	@Ignore
	public void testStop() {
		jc.stop();
	}
	
	@Test
	@Ignore
	public void testGetTimerInfo() {
		System.out.println(jc.getTimerInfo());
	}
}
