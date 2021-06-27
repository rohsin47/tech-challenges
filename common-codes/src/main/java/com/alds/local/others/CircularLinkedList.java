package com.alds.local.others;

/**
 * @author rohsingh
 *
 */
public class CircularLinkedList {

    Node head = null;

    Node tail = null;

    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            super();
            this.val = val;
            this.next = next;
        }
    }

    public Node copy(Node n) {
        Node h = new Node(n.val);
        Node t = h;
        t.next = h;

        do {
            t.next = new Node(n.next.val);
            t = t.next;
            t.next = h;

            n = n.next;
        } while (t.next.val != n.val);

        return h;
    }

    public void add(int data) {
        // Create new node
        Node newNode = new Node(data);
        // Checks if the list is empty.
        if (head == null) {
            // If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // tail will point to new node.
            tail.next = newNode;
            // New node will become new tail.
            tail = newNode;
            // Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
    }

    public void display(Node node) {
        Node current = node;
        if (node == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes of the circular linked list: ");
            do {
                // Prints each node by incrementing pointer.
                System.out.print("->" + current.val);
                current = current.next;
            } while (current.val != node.val);
            System.out.println();
        }
    }

    public Node delete(int del) {
        if (head != null) {

            int n = 1;
            Node current = copy(head);
            while (head.next != head) {
                head.next = head.next.next;
                n++;
            }

            // two pointer to maintain direction
            Node n1, n2;
            int i = 0;
            while (i < n) {
                n1 = current;
                n2 = current.next;
                if (n2.val == del) {
                    n1.next = n2.next;
                    n2.next = null;
                }
                current = current.next;
                i++;
            }
            return current;
        }
        return null;
    }

    public static void main(String[] args) {
        CircularLinkedList r = new CircularLinkedList();
        r.add(1);
        r.add(2);
        r.add(3);
        r.add(4);

        r.display(r.head);

        r.display(r.delete(3));
    }
}
