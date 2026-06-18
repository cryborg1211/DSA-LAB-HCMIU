package Exercises;

import LinkedList.SinglyLinkedList;
import java.util.HashSet;

public class Exercise4 {
    // Approach 1: Using HashSet (O(N) Time, O(N) Space)
    public static void deduplicateWithSet(SinglyLinkedList.Node head) {
        if (head == null) return;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(head.data);
        
        SinglyLinkedList.Node current = head;
        while (current.next != null) {
            if (seen.contains(current.next.data)) {
                current.next = current.next.next; // Remove duplicate
            } else {
                seen.add(current.next.data);
                current = current.next;
            }
        }
    }

    // Approach 2: Using nested loops (O(N^2) Time, O(1) Space)
    public static void deduplicateInPlace(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node current = head;
        while (current != null) {
            SinglyLinkedList.Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] vals = {5, 1, 5, 2, 1};
        for(int v : vals) list.insertAtTail(v);
        
        System.out.println("Original:");
        list.traverse();
        
        deduplicateWithSet(list.head);
        
        System.out.println("Deduplicated:");
        list.traverse();
    }
}
