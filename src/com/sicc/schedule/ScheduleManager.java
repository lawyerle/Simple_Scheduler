package com.sicc.schedule;

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
		
		//2. ThreadPoolManager 생성
		ThreadPoolManager tpm = new ThreadPoolManager();
		
		//3. JobConfig 로딩
		
		
		//4. Scheduler 생성

		//5. Job 생성

		//6. JobExtender 생성
		
		//7. Scheduler에 등록
		
	}
	
	public static void main(String[] argv) {
		
		// 1. ScheduleManager 생성
		ScheduleManager schedMng = new ScheduleManager();
		
		// 2. ScheduleManager의 스케쥴 작업 초기화
		schedMng.initSchedJobs();
		
		
	}

}