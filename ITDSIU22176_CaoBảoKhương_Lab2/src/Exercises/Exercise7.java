package Exercises;

import LinkedList.SinglyLinkedList;

public class Exercise7 {
    public static SinglyLinkedList.Node sortList(SinglyLinkedList.Node head) {
        if (head == null || head.next == null) return head;
        
        // Find middle
        SinglyLinkedList.Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        SinglyLinkedList.Node mid = slow.next;
        slow.next = null; // Detach
        
        SinglyLinkedList.Node left = sortList(head);
        SinglyLinkedList.Node right = sortList(mid);
        
        return merge(left, right);
    }
    
    private static SinglyLinkedList.Node merge(SinglyLinkedList.Node l1, SinglyLinkedList.Node l2) {
        SinglyLinkedList.Node dummy = new SinglyLinkedList.Node(0);
        SinglyLinkedList.Node curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] vals = {4, 2, 1, 3, 4, 0};
        for(int v : vals) list.insertAtTail(v);
        
        System.out.println("Original:");
        list.traverse();
        
        list.head = sortList(list.head);
        
        System.out.println("Sorted:");
        list.traverse();
    }
}
