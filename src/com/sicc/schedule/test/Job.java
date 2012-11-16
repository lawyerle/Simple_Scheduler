package com.sicc.schedule.test;

import com.sicc.schedule.JobInterface;

/**
 * @author jaeman
 * @version 1.0
 * @created 07-11-2012 ¿ÀÈÄ 3:49:22
 */
public class Job implements JobInterface {

	public Job(){

	}

	public void execute(){
		System.out.println("This is a Test Job");
	}

}