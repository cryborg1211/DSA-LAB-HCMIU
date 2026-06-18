package Exercises;

import LinkedList.SinglyLinkedList;

public class Exercise5 {
    public static SinglyLinkedList[] splitPlaylist(SinglyLinkedList.Node head) {
        if (head == null) return new SinglyLinkedList[]{new SinglyLinkedList(), new SinglyLinkedList()};
        
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;
        
        // Fast runner technique
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        SinglyLinkedList.Node secondHalfHead = slow.next;
        slow.next = null; // Split the connection
        
        SinglyLinkedList firstList = new SinglyLinkedList();
        firstList.head = head;
        SinglyLinkedList secondList = new SinglyLinkedList();
        secondList.head = secondHalfHead;
        
        return new SinglyLinkedList[]{firstList, secondList};
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] vals = {1, 2, 3, 4, 5};
        for(int v : vals) list.insertAtTail(v);
        
        System.out.println("Original Playlist:");
        list.traverse();
        
        SinglyLinkedList[] halves = splitPlaylist(list.head);
        
        System.out.println("First Half:");
        halves[0].traverse();
        System.out.println("Second Half:");
        halves[1].traverse();
    }
}
