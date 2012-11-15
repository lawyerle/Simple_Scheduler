package com.sicc.schedule;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 ¿ÀÈÄ 3:49:22
 */
public class JobExtender {

	private long timeToAwake;
	public JobInterface m_JobInterface;

	public JobExtender(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param job
	 */
	public boolean addJob(JobInterface job){
		return false;
	}

	/**
	 * 
	 * @param currTime
	 */
	public void notifyTime(long currTime){

	}

	private void runJob(){

	}

	private void setNextAwakeTime(){

	}

}