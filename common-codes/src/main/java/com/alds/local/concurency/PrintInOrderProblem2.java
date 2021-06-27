package com.alds.local.concurency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrderProblem2 {
	
	Semaphore s1;
	Semaphore s2;
	
	public PrintInOrderProblem2() {
		s1 = new Semaphore(0);
		s2 = new Semaphore(1);
	}
	
	public void print(String out) {
		System.out.println(out);
	}
	
	public void first() throws InterruptedException {
		print("first");
		s1.release();
	}
	
	public void second() throws InterruptedException {
		s1.acquire();
		print("second");
		s2.release();
	}
	
	public void third() throws InterruptedException {
		s2.acquire();
		print("third");
	}
	
	public static void main(String[] args) {
		PrintInOrderProblem foo = new PrintInOrderProblem();
		
		Thread t1 = new Thread(() -> {
			try {
				foo.first();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				foo.second();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(() -> {
			try {
				foo.third();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	

}
