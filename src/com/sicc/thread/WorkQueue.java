package com.sicc.thread;

import java.util.LinkedList;

public class WorkQueue {

	private LinkedList<Runnable> workList = new LinkedList<Runnable>();
	
	private boolean close = false;
	
	public synchronized void enqueue(Runnable job) {
		workList.addLast(job);
		notify();
	}
	
	public synchronized Runnable dequeue() throws InterruptedException, AleadyClosedException {
		
		while (workList.size() <= 0) {
			wait();
			if(close)
				throw new AleadyClosedException();
		}
		
		return workList.removeFirst();
	}
	
	public synchronized void close() {
		this.close = true;
		notifyAll();
	}

}
