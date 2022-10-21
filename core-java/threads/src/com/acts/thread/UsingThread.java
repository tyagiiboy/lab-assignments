package com.acts.thread;

public class UsingThread extends Thread{

	private String name;

	public UsingThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Using Thread class");
		System.out.println("Printer 1 state in run method: " +Thread.currentThread().getState().toString());

		for(int i = 0; i <= 10; i++) {
			System.out.println("Name: " + Thread.currentThread().getName()+ ": , Value: " +i);
		}

		System.out.println(this.toString());
		System.out.println("Thread class complete");
	}

}
