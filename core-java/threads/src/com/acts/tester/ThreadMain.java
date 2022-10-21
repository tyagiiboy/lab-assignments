package com.acts.tester;

import com.acts.thread.UsingRunnable;
import com.acts.thread.UsingThread;

public class ThreadMain {

	public static void main(String[] args) {
		System.out.println("Thread name :" +Thread.currentThread().getName());

		Thread t1 = new Thread(new UsingRunnable("Printer 0"), "Printer 0");
		System.out.println("Printer 0 state after creation: " +t1.getState().toString());
		Thread t2 = new UsingThread("Printer 1");

		t1.start();
		System.out.println("Printer 0 state after start: " +t1.getState().toString());
		t2.start();

		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(() -> {
			for(int i = 0; i < 4; i++)
				System.out.println("Thread 1");
		}) .start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 4; i++)
					System.out.println("Thread 2");
			}
		}).start();
		
		new Thread(() -> {
			System.out.println("Thread 3");
		}) .start();

		new UsingThread("Printer 2").start();
		new Thread(new UsingRunnable("Printer 3"), "Printer 3").start();

		System.out.println("Final state of t1 Thread: " +t1.getState().toString());
	}

}
