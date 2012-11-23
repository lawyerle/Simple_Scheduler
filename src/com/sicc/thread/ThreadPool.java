package com.sicc.thread;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 오후 3:49:23
 */
public class ThreadPool {

	private static ThreadPool m_ThreadPoolManager = null;
	public static int threadId = 0;
	private WorkQueue pool = new WorkQueue();
	private int threadMin = 0;
	private int threadMax = 0;
	private int currentThreadCount = 0;
	private int idleThreadCount = 0;
	private boolean close = false;
	private int allowedIdleCount = 3;
	private int workThreadCount = 0;
	private static int INCREASE_UNIT_DEFAULT = 6;

	public synchronized void close() {
		this.close = true;
		pool.close();
	}

	private ThreadPool(int min, int max){
		this.threadMin = min;
		this.threadMax = max;
		
	}
	
	public static ThreadPool getInstance() {
		if(m_ThreadPoolManager == null) {
			ThreadPoolConfig cfg = new ThreadPoolConfig();
			cfg.loadConfig("aaa");
			m_ThreadPoolManager = new ThreadPool(cfg.getMinThread(), cfg.getMaxThread());
			
		}
		
		return m_ThreadPoolManager;
	}
	
	private void threadPoolIncrease() {
		
		synchronized (pool) {

			if(idleThreadCount == 0 && currentThreadCount < threadMax) {

				for (int i = 0; i < INCREASE_UNIT_DEFAULT; i++) {
					
					JobThread tmp = new JobThread();
					tmp.start();
					currentThreadCount++;
					idleThreadCount++;
					
				}
				
				System.out.println("Current : " + currentThreadCount);
				System.out.println("Idle : " + idleThreadCount);
				
			}
		}
	}

	private boolean isTerminate() {

		synchronized (pool) {
			workThreadCount --;
			idleThreadCount++;			
			if (idleThreadCount > allowedIdleCount  && currentThreadCount > threadMin) {
				currentThreadCount--;
				idleThreadCount--;
				return true;
			} else {
				return false;
			}
		}
	}

	public void execute(Runnable job) {
		threadPoolIncrease();
		pool.enqueue(job);
	}
	
	private void beginWork() {
		synchronized (pool) {
			idleThreadCount--;
			workThreadCount++;
		}
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
				while(!close) {
					Runnable work = null;
					
					synchronized (pool) {
						work = (Runnable)pool.dequeue();
					}
					
					System.out.println(this.getName());
					beginWork();
					work.run();
					
					if(isTerminate())
						break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (AleadyClosedException e) {
				e.printStackTrace();
			}
		}

	}
}

