package com.sicc.schedule;

import com.sicc.schedule.test.Job;
import com.sicc.thread.ThreadPoolConfig;

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
		
		//3. JobConfig �ε�
		
		
		//4. Scheduler ����
		Scheduler sched = new Scheduler();
		
		//5. Job ����
		Job job1 = new Job(1);	
		Job job2 = new Job(2);	

		//6. JobExtender ����
		
		JobExtender jex1 = new JobExtender(5000);
		JobExtender jex2 = new JobExtender(10000);
		
		jex1.addJob(job1);
		jex2.addJob(job2);
		
		//7. Scheduler�� ���
		sched.addSchedJob(jex1);
		sched.addSchedJob(jex2);
		
		//8. Scheduler Start!!
		
		Thread thread = new Thread(sched);

		thread.start();
		
	}
	
	public static void main(String[] argv) {
		
		// 1. ScheduleManager ����
		ScheduleManager schedMng = new ScheduleManager();
		
		// 2. ScheduleManager�� ������ �۾� �ʱ�ȭ
		schedMng.initSchedJobs();
		
		
	}

}