package com.alds.ctci.linkedlist;

public class DeleteMiddleNodeProblem {

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
	
	public void deleteMiddleNode(Node head, Node tobeRemoved) {	
		Node temp = head;
		
		System.out.println("Node to be removed : "+tobeRemoved.data);
		
		System.out.print(temp.data + "-> ");
		
		while(temp.next != null && temp.next.data != tobeRemoved.data) {
			temp = temp.next;
			System.out.print(temp.data + "-> ");
		}
		
		temp.next = temp.next.next;
		while(temp.next != null) {
			System.out.print(temp.next.data + "-> ");
			temp = temp.next;
		}
		
	}
	
	public Node nodeToBeemoved(int val) {
		return new Node(val);
	}
	
	public static void main(String[] args) {
		DeleteMiddleNodeProblem problem =  new DeleteMiddleNodeProblem();
		Node test = problem.create();
		problem.deleteMiddleNode(test, problem.nodeToBeemoved(6));
		
	}

}
