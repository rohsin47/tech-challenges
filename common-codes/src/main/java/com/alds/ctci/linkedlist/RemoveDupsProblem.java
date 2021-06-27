package com.alds.ctci.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsProblem {
	
	public class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}

	public Node create() {
		Node n = new Node(2);
		
		Node n1 = new Node(8);
		n.next = n1;
		
		Node n2 = new Node(5);
		n1.next = n2;
		
		Node n3 = new Node(5);
		n2.next = n3;
		
		Node n4 = new Node(6);
		n3.next = n4;
		
		return n;
	}
	
	public void display(Node head) {
		Node node = head;
		
		while(node!= null) {
			System.out.print(node.data +"-> ");
			node = node.next;
		}
	}
	
	public void removeDuplicates(Node head) {
		Set<Integer> nodups = new HashSet<Integer>();
		
		Node current = head;
		Node previous = null;
		
		display(head);
		
		System.out.println("output :");
		
		while(current!= null) {
			if(nodups.contains(current.data)) {
				previous.next = current.next;
			} else {
				nodups.add(current.data);	
				previous = current;
				System.out.print(previous.data + "-> ");
			}		
			current = current.next;
		}
	}
	
	public void removeDupsWithoutBuffer(Node head) {
		Node current = head;
		
		display(current);
		
		System.out.println("Output : ");
		
		while(current != null) {
			Node runner = current;
			
			System.out.print(runner.data + "-> ");
			
			while(runner.next!= null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				}
				runner = runner.next;
			}
			
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		RemoveDupsProblem problem = new RemoveDupsProblem();
		Node data = problem.create();
		//problem.removeDuplicates(data);
		problem.removeDupsWithoutBuffer(data);
	}
	
}
