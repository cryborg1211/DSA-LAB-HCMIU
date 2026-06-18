package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class CycleTools {
    // Detect cycle using extra memory O(N) space
    public static boolean hasCycleWithMemory(SinglyLinkedList.Node head) {
        Set<SinglyLinkedList.Node> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }
        return false;
    }

    // Detect cycle using Floyd's Tortoise and Hare (O(1) space)
    public static boolean hasCycle(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    
    // Find cycle start node Extra Memory
    public static SinglyLinkedList.Node getCycleEntryWithMemory(SinglyLinkedList.Node head) {
        Set<SinglyLinkedList.Node> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) return head;
            seen.add(head);
            head = head.next;
        }
        return null;
    }

    // Find cycle start node O(1) space
    public static SinglyLinkedList.Node getCycleEntry(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;
        boolean hasCycle = false;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        if (!hasCycle) return null;
        
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // Cycle start
    }
    
    // Break cycle (Exercise 8)
    public static void breakCycle(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node startNode = getCycleEntry(head);
        if (startNode == null) return;
        
        SinglyLinkedList.Node current = startNode;
        while (current.next != startNode) {
            current = current.next;
        }
        current.next = null; // Break it
    }
}
