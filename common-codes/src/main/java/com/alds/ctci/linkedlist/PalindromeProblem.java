package com.alds.ctci.linkedlist;
/**
 * 
 * @author rohsi
 *
 */

public class PalindromeProblem {
	
	public class Node {
		int data;
		Node next;
		
		public Node() {
		}
		
		public Node(int data) {
			this.data = data;
		}
	}

	public Node create() {
		Node n = new Node(0);
		
		Node n1 = new Node(1);
		n.next = n1;
		
		Node n2 = new Node(2);
		n1.next = n2;
		
		Node n3 = new Node(1);
		n2.next = n3;
		
		Node n4 = new Node(0);
		n3.next = n4;
		
		return n;
	}
	
	// three pointer strategy
	public Node reverseAndClone(Node node) {
		Node head = null;
		while(node != null) {
			Node n = new Node(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}
	
	public boolean isPalindrome(Node head) {
		Node reverse = reverseAndClone(head);
		while(head != null && reverse != null) {
			if(head.data != reverse.data) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromeProblem problem = new PalindromeProblem();
		Node test = problem.create();
		Boolean isP = problem.isPalindrome(test);
		System.out.println("is Palindrome : "+isP);
		
	}
}
