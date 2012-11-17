package com.sicc.thread;

//import java.util.ArrayList;
//import java.util.List;

//import com.sicc.schedule.JobInterface;



/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 오후 3:49:23
 */
public class ThreadPool {

//	private List<JobThread> m_JobThreadList = new ArrayList<JobThread>();
	private static ThreadPool m_ThreadPoolManager = null;
	public static int threadId = 0;
	private WorkQueue pool = new WorkQueue();
	private int threadMin = 0;
	private int threadMax = 0;
	private int currentThreadCount = 0;
	private int idleThreadCount = 0;
	private final int THREADGROWUNIT = 10;
	private boolean quit = false;

	private ThreadPool(int min, int max){
		this.threadMin = min;
		this.threadMax = max;
		
		threadPoolSetup();
	}
	
	public static ThreadPool getInstance() {
		if(m_ThreadPoolManager == null) {
			
			m_ThreadPoolManager = new ThreadPool(10, 20);
			
		}
		
		return m_ThreadPoolManager;
	}
	
	private void threadPoolSetup() {
		if (currentThreadCount < threadMin) {
			for (int i = 0; i < threadMin; i++) {
				JobThread tmp = new JobThread();
				tmp.start();
//				m_JobThreadList.add(tmp);
				currentThreadCount++;
				idleThreadCount++;				
			}
		} else if (idleThreadCount <= 0) {
			for (int i = 0; i < THREADGROWUNIT; i++) {
				if (currentThreadCount >= threadMax) {
					break;
				}
				JobThread tmp = new JobThread();
				tmp.start();
//				m_JobThreadList.add(tmp);
				currentThreadCount++;
				idleThreadCount++;
			}
		} 
	}

	private synchronized boolean isTerminate() {
		
		if (currentThreadCount > threadMax) {
			currentThreadCount--;
			return true;
		} else {
			idleThreadCount++;
			return false;
		}
		
	}

	public synchronized void execute(Runnable job) {
		idleThreadCount--;
		threadPoolSetup();
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
				while(!quit) {
					Runnable work = null;
					
					synchronized (pool) {
						work = (Runnable)pool.dequeue();
					}
					
					System.out.println(this.getName());
					if(work != null)
						work.run();
					
					if(isTerminate())
						break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

