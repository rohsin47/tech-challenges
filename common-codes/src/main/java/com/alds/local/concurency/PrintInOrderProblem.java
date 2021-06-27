package com.alds.local.concurency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrderProblem {
	
	Lock lock;
	Condition firstCond;
	Condition secondCond;
	Condition thirdCond;
	int state = 1;
	
	public PrintInOrderProblem() {
		lock = new ReentrantLock();
		firstCond = lock.newCondition();
		secondCond = lock.newCondition();
		thirdCond = lock.newCondition();	
	}
	
	public void print(String out) {
		System.out.println(out);
	}
	
	public void first() throws InterruptedException {
		lock.lock();
		while(state != 1) {
			firstCond.await();
		}
		print("first");
		state = 2;
		secondCond.signal();
		lock.unlock();
	}
	
	public void second() throws InterruptedException {
		lock.lock();
		while(state != 2) {
			secondCond.await();
		}
		print("second");
		state = 3;
		thirdCond.signal();
		lock.unlock();
	}
	
	public void third() throws InterruptedException {
		lock.lock();
		while(state != 3) {
			thirdCond.await();
		}
		print("third");
		lock.unlock();
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
