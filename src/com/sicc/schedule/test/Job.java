package com.sicc.schedule.test;

import com.sicc.schedule.JobInterface;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 ¿ÀÈÄ 3:49:22
 */
public class Job implements JobInterface {
	
	private int sequence;

	public Job(int i){
		sequence = i;
	}

	public void execute(){
		System.out.println("This is a Test Job #" + sequence);
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}