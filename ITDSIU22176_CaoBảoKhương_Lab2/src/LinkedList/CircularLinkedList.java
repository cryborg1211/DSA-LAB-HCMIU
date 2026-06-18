package LinkedList;

public class CircularLinkedList {
    public static class Node {
        public int data;
        public Node next;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    public Node head;
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }
    
    public void traverse() {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head: " + head.data + ")");
    }
    
    // Helper to purposefully create a cycle in a linear list testing
    public static void createCycle(SinglyLinkedList list, int cycleIndex) {
        if (list.head == null) return;
        SinglyLinkedList.Node current = list.head;
        SinglyLinkedList.Node cycleStart = null;
        
        int idx = 0;
        while (current.next != null) {
            if (idx == cycleIndex) cycleStart = current;
            current = current.next;
            idx++;
        }
        if (idx == cycleIndex) cycleStart = current;
        
        if (cycleStart != null) {
            current.next = cycleStart; // Create the cycle
        }
    }
}
