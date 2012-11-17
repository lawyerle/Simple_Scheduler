package com.sicc.thread;

import java.util.LinkedList;

//import com.sicc.schedule.JobInterface;

public class WorkQueue {

	private LinkedList<Runnable> workList = new LinkedList<Runnable>();
	
	public synchronized void enqueue(Runnable job) {
		workList.addLast(job);
		notify();
	}
	
	public synchronized Runnable dequeue() throws InterruptedException {
		
		while (workList.size() <= 0) {
			wait();
		}
		
		return workList.removeFirst();
	}

}
