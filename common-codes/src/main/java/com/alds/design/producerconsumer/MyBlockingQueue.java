/**
 * 
 */
package com.alds.design.producerconsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rohsingh
 *
 */
public class MyBlockingQueue<T> {
	
	private static final int DEFAULT_CAPACITY = 100;
	
	private final ReentrantLock lock = new ReentrantLock();	
	private final Condition notfull = lock.newCondition();
	private final Condition notempty = lock.newCondition();
	
	private final List<T> elements;
	
	private final int capacity;
	
	private int takeIndex = 0;

	public MyBlockingQueue() {
		this(new ArrayList<T>(), DEFAULT_CAPACITY);
	}
	
	public MyBlockingQueue(int maxSize) {
		this(new LinkedList<T>(), maxSize);
	}

	public MyBlockingQueue(List<T> elements, int capacity) {
		this.elements = elements;
		this.capacity = capacity;
	}
	
	public void put(T t) throws InterruptedException {
		lock.lockInterruptibly();
		try {
			while(this.elements.size() == capacity) {
				// its full now, wait for not full
				notfull.await();
			}
			this.elements.add(t);
			notempty.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public T take() throws InterruptedException {
		T t = null;
		lock.lock();
		try {
			while(this.elements.isEmpty()) {
				// its empty now, wait for not empty
				notempty.await();
			}
			t = this.elements.remove(takeIndex);
			//if(++takeIndex == this.elements.size()) {
			//	takeIndex = 0;
			//}
			notfull.signal();
		} finally {
			lock.unlock();
		}
		return t;
	}

	public List<T> getElements() {
		return Collections.unmodifiableList(new ArrayList<>(elements));
	}

	public int getCapacity() {
		return this.capacity;
	}
} 
