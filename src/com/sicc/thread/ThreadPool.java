package com.sicc.thread;

import java.util.ArrayList;
import java.util.List;

import com.sicc.schedule.JobInterface;



/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 오후 3:49:23
 */
public class ThreadPool {

	private List<JobThread> m_JobThreadList = new ArrayList<JobThread>();
	private static ThreadPool m_ThreadPoolManager = null;
	public static int threadId = 0;
	private WorkQueue pool = new WorkQueue();

	private ThreadPool(){
		for (int i = 0; i < 10; i++) {
			JobThread tmp = new JobThread();
			tmp.start();
			m_JobThreadList.add(tmp);
		}
	}
	
	public static ThreadPool getInstance() {
		if(m_ThreadPoolManager == null) {
			m_ThreadPoolManager = new ThreadPool();
		}
		
		return m_ThreadPoolManager;
	}


	public synchronized void execute(JobInterface job) {
		pool.enqueue(job);
	}
	
	/**
	 * @author jaeman
	 * @version 1.0
	 * @created 07-11-2012 오후 3:49:22
	 */
	private class JobThread extends Thread {
		
		public JobThread(){
			super("Pooled Thread #" + threadId++);
		}

		public void run() {
			try {
				while(true) {
					JobInterface work = null;
					
					synchronized (pool) {
						work = (JobInterface)pool.dequeue();
					}
					
					System.out.println(this.getName());
					work.execute();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

