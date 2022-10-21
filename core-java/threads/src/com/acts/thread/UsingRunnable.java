package com.acts.thread;

public class UsingRunnable implements Runnable{
	private String name;

	public UsingRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Run method of Runnable");
		System.out.println("Printer 0 state in run method: " +Thread.currentThread().getState().toString());

		for(int i = 0; i <= 10; i++) {

			try {
				Thread.sleep(250);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Name: " + Thread.currentThread().getName()+ ": , Value: " +i);
		}

		System.out.println("Runnable complete");

	}

}
