package com.alds.ctci.linkedlist;

import java.util.Stack;

public class KthToLastProblem {
	
	public class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public Node create() {
		Node n = new Node(2);
		
		Node n1 = new Node(4);
		n.next = n1;
		
		Node n2 = new Node(6);
		n1.next = n2;
		
		Node n3 = new Node(7);
		n2.next = n3;
		
		Node n4 = new Node(8);
		n3.next = n4;
		
		return n;
	}
	
	// recursively
	public int kthToLast(Node head, int k) {
		if(head == null) {
			return 0;
		}
		int index = kthToLast(head.next, k) + 1;
		if(index == k) {
			System.out.println("kth to the last : "+head.data);
		}
		return index;
	}
	
	// via stack
	public int kthToLastViaStack(Node head, int k) {
		Stack<Integer> st = new Stack<Integer>();
		
		while(head != null) {
			st.add(head.data);
			head = head.next;
		}
		
		int result = 0;
		int counter = 1;
		while(!st.empty()) {
			result = st.pop();
			if(counter == k) {
				System.out.println("kth to the last via stack : "+result);
				break;
			}
			counter++;
		}
		return result;
	}
	
	public int kthToLastViaTwoPointers(Node head, int k) {
		Node p1 = head;
		Node p2 = p1;
		
		for(int i=0; i<k; i++) {
			p1 = p1.next;
		}
		
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		System.out.println("kth to the last via two pointers : "+p2.data);
		return p2.data;
	}
	

	public static void main(String[] args) {
		KthToLastProblem problem = new KthToLastProblem();
		Node data = problem.create();
		problem.kthToLast(data, 4);
		problem.kthToLastViaStack(data, 4);
		problem.kthToLastViaTwoPointers(data, 4);
	}
}
