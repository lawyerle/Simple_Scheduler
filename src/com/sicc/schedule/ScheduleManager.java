package com.sicc.schedule;

import com.sicc.schedule.test.Job;
import com.sicc.thread.ThreadPoolConfig;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 오후 3:49:22
 */
public class ScheduleManager {

	public Scheduler m_Scheduler;
	public JobConfigLoader m_JobConfigLoader;
	public ThreadPoolConfig m_ThreadPoolConfig;

	public ScheduleManager(){

	}

	public void initSchedJobs(){
		//1. ThreadPoolConfig를 읽어서 Pool 정보를 로딩
		
		ThreadPoolConfig tpc = new ThreadPoolConfig();
		
		tpc.loadConfig("aaa");
		
		//3. JobConfig 로딩
		
		
		//4. Scheduler 생성
		Scheduler sched = new Scheduler();
		
		//5. Job 생성
		Job job1 = new Job(1);	
		Job job2 = new Job(2);	

		//6. JobExtender 생성
		
		JobExtender jex1 = new JobExtender(5000);
		JobExtender jex2 = new JobExtender(10000);
		
		jex1.addJob(job1);
		jex2.addJob(job2);
		
		//7. Scheduler에 등록
		sched.addSchedJob(jex1);
		sched.addSchedJob(jex2);
		
		//8. Scheduler Start!!
		
		Thread thread = new Thread(sched);

		thread.start();
		
	}
	
	public static void main(String[] argv) {
		
		// 1. ScheduleManager 생성
		ScheduleManager schedMng = new ScheduleManager();
		
		// 2. ScheduleManager의 스케쥴 작업 초기화
		schedMng.initSchedJobs();
		
		
	}

}