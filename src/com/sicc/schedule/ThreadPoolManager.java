package com.sicc.schedule;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 ¿ÀÈÄ 3:49:23
 */
public class ThreadPoolManager {

	public JobThread m_JobThread;

	public ThreadPoolManager(){

	}

	public void finalize() throws Throwable {

	}

	public JobThread getFreeThread(){
		return null;
	}

}