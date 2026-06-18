package Exercises;

import LinkedList.SinglyLinkedList;

public class Exercise3 {
    public static SinglyLinkedList.Node mergeTwoLists(SinglyLinkedList.Node l1, SinglyLinkedList.Node l2) {
        SinglyLinkedList.Node dummy = new SinglyLinkedList.Node(0);
        SinglyLinkedList.Node tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.insertAtTail(1); list1.insertAtTail(3); list1.insertAtTail(7);
        
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtTail(2); list2.insertAtTail(3); list2.insertAtTail(9);
        
        System.out.println("List 1:");
        list1.traverse();
        System.out.println("List 2:");
        list2.traverse();
        
        SinglyLinkedList.Node mergedHead = mergeTwoLists(list1.head, list2.head);
        
        System.out.println("Merged List:");
        while(mergedHead != null) {
            System.out.print(mergedHead.data + (mergedHead.next != null ? " -> " : " -> null"));
            mergedHead = mergedHead.next;
        }
        System.out.println();
    }
}
