package com.sicc.schedule;

import com.sicc.thread.ThreadPool;

/**
 * 실제 수행될 Job Class를 감싸는 확장 클래스로 수행되어야 할 시간정보를 가지고 있음.
 * 
 * @author lawyerle01
 * @version 1.0
 * @created 07-11-2012 오후 3:49:22
 */

public class JobExtender {

	private long timeToAwake;
	private Runnable m_Job;
	private long interval;

	public JobExtender(){
		timeToAwake = 0;
		interval = 10;
	}

	/**
	 * 실제 수행되어야 할 작업을 등록 
	 * @author lawyerle01
	 * @param job
	 */
	public boolean addJob(Runnable job){
		
		if (job != null) {
			this.m_Job = job;
			return true;			
		} else {
			return false;
		}
	}

	/**
	 * Scheduler로 부터 시간을 전달받아 실행시간이 도래했을 경우 실제 수행해야하는 작업을 호출 
	 * @author lawyerle01
	 * @param currTime
	 */
	public void notifyTime(long currTime){
		if (currTime >= this.timeToAwake) {
			runJob();
			setNextAwakeTime();
		} 
	}

	
	private void runJob(){
		ThreadPool.getInstance().execute(this.m_Job);
	}

	/**
	 * 다음에 실행될 시간을 설정 
	 * @author lawyerle01
	 */
	private void setNextAwakeTime(){
		this.timeToAwake = this.timeToAwake + this.interval;
	}

}