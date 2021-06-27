/**
 * 
 */
package com.alds.local.others;

/**
 * @author rohsi
 *
 */
public class LinkedListReversal {

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public ListNode inPlaceReversal(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;

			current = next;
		}
		return prev;
	} 
	
	public ListNode reverseAndClone(ListNode head) {
		ListNode prev = null;
		
		while(head != null) {
			ListNode n = new ListNode(head.val);
			n.next = prev;
			prev = n;
			
			head = head.next;
		}
		return prev;
	}
	
	ListNode create() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		return head;
	}
	void printList(ListNode node) 
    { 
        while (node != null) { 
            System.out.print(node.val + " "); 
            node = node.next; 
        } 
    } 
	
	public static void main(String[] args) {
		LinkedListReversal r = new LinkedListReversal();
		ListNode head = r.create();
  
        System.out.println("Given Linked list"); 
        r.printList(head); 
        head = r.inPlaceReversal(head); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        r.printList(head); 
        
        ListNode rev = r.reverseAndClone(head);
        System.out.println(""); 
        System.out.println("Cloned reversed linked list "); 
        r.printList(rev);
    } 

}
