package com.alds.local.others;

/**
 * @author rohsingh
 *
 */
public class JosephusCircleProblem {

	class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public int findLastMan(int m, int k) {

		// create the circular linked list
		Node head = new Node(1);
		Node tail = head;
		for (int i = 2; i < m; i++) {
			tail.next = new Node(i);
			tail = tail.next;
		}
		tail.next = head;

		// two pointers to traverse
		Node n1, n2;
		n1 = head;
		n2 = head;

		// n1, n2 start a head
		// move n2, then n1 till n2.next == n1
		while (n2.next != n1) {
			int count = 1;
			while (count < m) {
				if(count%k == 0) {
					n1.next = n2.next;	
					n2 = n1.next;
				} 
				n1 = n2;
				n2 = n2.next;
				count++;
			}
		}
		return n1.val;
	}

	public int josephus(int n, int k) {
		if (n == 1)
			return 1;
		else
			/*
			 * The position returned by josephus(n - 1, k) is adjusted because the recursive
			 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
			 */
			return (josephus(n - 1, k) + k - 1) % n + 1;
	}

	public static void main(String[] args) {
		JosephusCircleProblem j = new JosephusCircleProblem();
		System.out.println(j.findLastMan(14, 2));
		System.out.println(j.josephus(14, 2));
	}

}
