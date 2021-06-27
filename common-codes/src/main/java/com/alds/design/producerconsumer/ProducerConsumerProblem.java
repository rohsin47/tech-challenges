/**
 * 
 */
package com.alds.design.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author rohsingh
 *
 */
public class ProducerConsumerProblem {

	private MyBlockingQueue<Integer> queue;

	public ProducerConsumerProblem() {
		this.queue = new MyBlockingQueue<>();
	}

	public void produce(Integer val) throws InterruptedException {
		this.queue.put(val);
	}

	public Integer consume() throws InterruptedException {
		return this.queue.take();
	}

	public static void main(String[] args) {
		int cap = 10;
		ProducerConsumerProblem p = new ProducerConsumerProblem();

		new Thread(() -> {
			while (true) {
				try {
					for(int i=0; i< cap; i++) {
						int val = ThreadLocalRandom.current().nextInt();
						System.out.println("Producing : " + val);
						p.produce(val);
					}
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				try {
					System.out.println("Consuming : " + p.consume());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
