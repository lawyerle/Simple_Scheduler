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
		Scheduler sched = new Scheduler();
		
		//5. Job ����
		Job job = new Job();	

		//6. JobExtender ����
		
		JobExtender je = new JobExtender();
		
		je.addJob(job);
		
		//7. Scheduler�� ���
		sched.addSchedJob(je);
		
		//8. Scheduler Start!!
		sched.start();
		
	}
	
	public static void main(String[] argv) {
		
		// 1. ScheduleManager ����
		ScheduleManager schedMng = new ScheduleManager();
		
		// 2. ScheduleManager�� ������ �۾� �ʱ�ȭ
		schedMng.initSchedJobs();
		
		
	}

}