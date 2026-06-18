package Exercises;

import LinkedList.SinglyLinkedList;

public class Exercise6 {
    public static SinglyLinkedList.Node partition(SinglyLinkedList.Node head, int x) {
        SinglyLinkedList.Node lessHead = new SinglyLinkedList.Node(0);
        SinglyLinkedList.Node lessTail = lessHead;
        SinglyLinkedList.Node greaterHead = new SinglyLinkedList.Node(0);
        SinglyLinkedList.Node greaterTail = greaterHead;
        
        SinglyLinkedList.Node current = head;
        while (current != null) {
            if (current.data < x) {
                lessTail.next = current;
                lessTail = lessTail.next;
            } else {
                greaterTail.next = current;
                greaterTail = greaterTail.next;
            }
            current = current.next;
        }
        
        greaterTail.next = null; // Important: terminate list to avoid loops
        lessTail.next = greaterHead.next;
        
        return lessHead.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] vals = {3, 5, 8, 5, 10, 2, 1};
        for(int v : vals) list.insertAtTail(v);
        
        int x = 5;
        System.out.println("Original:");
        list.traverse();
        System.out.println("Threshold x = " + x);
        
        SinglyLinkedList.Node newHead = partition(list.head, x);
        list.head = newHead;
        
        System.out.println("Partitioned:");
        list.traverse();
    }
}
