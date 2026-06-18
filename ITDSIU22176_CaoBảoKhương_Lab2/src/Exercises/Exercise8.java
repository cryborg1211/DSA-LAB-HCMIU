package Exercises;

import LinkedList.SinglyLinkedList;
import LinkedList.CycleTools;

public class Exercise8 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] vals = {1, 2, 3, 4, 5, 6};
        for(int v : vals) list.insertAtTail(v);
        
        // Create an artificial cycle: 6 points to 3 (index 2)
        SinglyLinkedList.Node current = list.head;
        SinglyLinkedList.Node cycleTarget = null;
        int i = 0;
        while(current.next != null) {
            if (i == 2) cycleTarget = current;
            current = current.next;
            i++;
        }
        current.next = cycleTarget; // corrupting the list
        
        System.out.println("Cycle exists? (Floyd) " + CycleTools.hasCycle(list.head));
        System.out.println("Cycle exists? (Memory Hash) " + CycleTools.hasCycleWithMemory(list.head));
        
        SinglyLinkedList.Node start = CycleTools.getCycleEntry(list.head);
        if (start != null) {
            System.out.println("Cycle entry node value: " + start.data);
            CycleTools.breakCycle(list.head);
            System.out.println("Cycle broken.");
            System.out.println("Fixed list:");
            list.traverse();
        } else {
            System.out.println("No cycle found.");
        }
    }
}
