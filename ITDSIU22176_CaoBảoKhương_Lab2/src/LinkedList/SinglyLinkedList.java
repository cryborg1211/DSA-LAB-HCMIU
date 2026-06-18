package LinkedList;

public class SinglyLinkedList {
    public static class Node {
        public int data;
        public Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void deleteByValue(int data) {
        if (head == null) return;
        
        if (head.data == data) {
            head = head.next;
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean searchByValue(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> null"));
            current = current.next;
        }
        if (head == null) System.out.print("null");
        System.out.println();
    }

    // Iterative approach for reversing (O(1) space)
    public void reverseIterative() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Recursive approach for reversing (O(N) space due to call stack)
    public void reverseRecursive() {
        head = reverseRecursiveHelper(head);
    }

    private Node reverseRecursiveHelper(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node rest = reverseRecursiveHelper(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }
}
