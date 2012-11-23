package com.sicc.schedule;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 ¿ÀÈÄ 3:49:22
 */
public class Scheduler implements Runnable {

	private List<JobExtender> scheduledJobs = new ArrayList<JobExtender>();
	private int testInt = 0;

	public Scheduler(){
		
	}

	/**
	 * 
	 * @param JobExt
	 */
	public boolean addSchedJob(JobExtender JobExt){
		scheduledJobs.add(JobExt);
		
		return true;
	}

	private void startTask(){
		for (JobExtender job : scheduledJobs) {
			job.notifyTime(System.currentTimeMillis());
		}
		testInt++;
		System.out.println("time : " + testInt);
	}

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(1000);
				startTask();				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}