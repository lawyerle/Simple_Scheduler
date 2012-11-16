package com.sicc.thread;

import java.util.LinkedList;

import com.sicc.schedule.JobInterface;

public class WorkQueue {

	private LinkedList<JobInterface> workList = new LinkedList<JobInterface>();
	
	public synchronized void enqueue(JobInterface job) {
		workList.addLast(job);
		notify();
	}
	
	public synchronized JobInterface dequeue() throws InterruptedException {
		
		while (workList.size() <= 0) {
			wait();
		}
		
		return workList.removeFirst();
	}

}
