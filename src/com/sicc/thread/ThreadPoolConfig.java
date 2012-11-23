package com.sicc.thread;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 ¿ÀÈÄ 3:49:22
 */
public class ThreadPoolConfig {
	
	private static int MIN_THREAD_DEFAULT = 10;
	private static int MAX_THREAD_DEFAULT = 20;
	
	private int minThread = MIN_THREAD_DEFAULT;
	private int maxThread = MAX_THREAD_DEFAULT;

	public ThreadPoolConfig(){

	}

	/**
	 * 
	 * @param fileName
	 */
	public boolean loadConfig(String fileName){
		return false;
	}

	public int getMaxThread() {
		
		return maxThread;
	}

	public int getMinThread() {
		// TODO Auto-generated method stub
		return minThread;
	}

}