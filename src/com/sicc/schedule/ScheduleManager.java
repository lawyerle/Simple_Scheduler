package com.sicc.schedule;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 ���� 3:49:22
 */
public class ScheduleManager {

	public Scheduler m_Scheduler;
	public JobConfigLoader m_JobConfigLoader;
	public ThreadPoolConfig m_ThreadPoolConfig;

	public ScheduleManager(){

	}

	public void initSchedJobs(){
		//1. ThreadPoolConfig�� �о Pool ������ �ε�
		
		ThreadPoolConfig tpc = new ThreadPoolConfig();
		
		tpc.loadConfig("aaa");
		
		//2. ThreadPoolManager ����
		ThreadPoolManager tpm = new ThreadPoolManager();
		
		//3. JobConfig �ε�
		
		
		//4. Scheduler ����

		//5. Job ����

		//6. JobExtender ����
		
		//7. Scheduler�� ���
		
	}
	
	public static void main(String[] argv) {
		
		// 1. ScheduleManager ����
		ScheduleManager schedMng = new ScheduleManager();
		
		// 2. ScheduleManager�� ������ �۾� �ʱ�ȭ
		schedMng.initSchedJobs();
		
		
	}

}