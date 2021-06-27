package com.alds.ctci.linkedlist;

import java.util.regex.Pattern;

public class SumListsProblem {
	
	public class Node {		
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
		}		
	}

	public Node create() {
		Node n = new Node(7);
		
		Node n1 = new Node(1);
		n.next = n1;
		
		Node n2 = new Node(6);
		n1.next = n2;
		
		return n;
	}
	
	public Node create2() {
		Node n = new Node(5);
		
		Node n1 = new Node(9);
		n.next = n1;
		
		Node n2 = new Node(2);
		n1.next = n2;
		
		return n;
	}
	
	public void sumList(Node n1, Node n2) {
		Node temp1 = n1;
		Node temp2 = n2;
		
		int sum = 0;
		int carryOver =0;
		String result = calc(temp1, temp2, sum, carryOver);
		sum = Integer.valueOf(result.split(Pattern.quote(":"))[0]);
		carryOver = Integer.valueOf(result.split(Pattern.quote(":"))[1]);
			
		Node smL = new Node(sum);
		
		while(temp1.next != null & temp2.next != null) {	
			
			System.out.print(smL.val +"-> ");
			
			result = calc(temp1.next, temp2.next, sum, carryOver);
			
			sum = Integer.valueOf(result.split(Pattern.quote(":"))[0]);
			carryOver = Integer.valueOf(result.split(Pattern.quote(":"))[1]);
			
			smL.next = new Node(sum);
			
			temp1 = temp1.next;
			temp2 = temp2.next;	
			
			smL = smL.next;
		}
		
		System.out.print(smL.val +"-> ");
		
		if(carryOver > 0) {
			smL.next = new Node(carryOver);
			System.out.print(carryOver +"-> ");
		}
	}
	
	private String calc(Node temp1, Node temp2, int sum, int carryOver) {
		int first = temp1.val + temp2.val + carryOver;
		if(first < 10) {
			sum = first;
			carryOver = 0;
		} else {
			carryOver = first / 10;
			sum = first % 10;
		}
		return String.valueOf(sum) + ":" + String.valueOf(carryOver);
	}
	
	public Node addListRecursively(Node n1, Node n2, int carry) {
		if(n1 == null || n2 == null) {
			return null;
		}
		
		int sum = carry;
		if(n1!=null) {
			sum+=n1.val;
		}
		if(n2!=null) {
			sum+=n2.val;
		}
		
		Node result = new Node(sum % 10); 
		
		if(n1.next!=null && n2.next!=null) {
			carry = sum >=10 ? 1 : 0;
			Node more = addListRecursively(n1.next, n2.next, carry);
			result.next  = more;
		}
		return result;
	}
	
	public static void main(String[] args) {
		SumListsProblem problem = new SumListsProblem();
		Node n1 = problem.create();
		Node n2 = problem.create2();
		//problem.sumList(n1, n2);
		problem.addListRecursively(n1, n2, 0);
	}
 }
