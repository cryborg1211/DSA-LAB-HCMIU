package LinkedList;

public class DoublyLinkedList {
    public static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void deleteByValue(int data) {
        if (head == null) return;
        
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        
        if (current == null) return; // not found
        
        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
            else tail = null; // List became empty
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " <-> " : " <-> null"));
            current = current.next;
        }
        if (head == null) System.out.print("null");
        System.out.println();
    }

    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + (current.prev != null ? " <-> " : " <-> null"));
            current = current.prev;
        }
        if (tail == null) System.out.print("null");
        System.out.println();
    }
}
