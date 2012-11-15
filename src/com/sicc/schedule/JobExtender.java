package com.sicc.schedule;

/**
 * ���� ����� Job Class�� ���δ� Ȯ�� Ŭ������ ����Ǿ�� �� �ð������� ������ ����.
 * 
 * @author lawyerle01
 * @version 1.0
 * @created 07-11-2012 ���� 3:49:22
 */

public class JobExtender {

	private long timeToAwake;
	private JobInterface m_JobInterface;
	private long interval;

	public JobExtender(){

	}

	/**
	 * ���� ����Ǿ�� �� �۾��� ��� 
	 * @author lawyerle01
	 * @param job
	 */
	public boolean addJob(JobInterface job){
		
		if (job != null) {
			this.m_JobInterface = job;
			return true;			
		} else {
			return false;
		}
	}

	/**
	 * Scheduler�� ���� �ð��� ���޹޾� ����ð��� �������� ��� ���� �����ؾ��ϴ� �۾��� ȣ�� 
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
		this.m_JobInterface.execute();
	}

	/**
	 * ������ ����� �ð��� ���� 
	 * @author lawyerle01
	 */
	private void setNextAwakeTime(){
		this.timeToAwake = this.timeToAwake + this.interval;
	}

}