package Exercises;

import java.util.HashMap;

public class Exercise9 {
    static class Node {
        int key, value;
        Node prev, next;
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    
    static class LRUCache {
        int capacity;
        HashMap<Integer, Node> map;
        Node head, tail;
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insertFront(node);
                return node.value;
            }
            return -1;
        }
        
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            if (map.size() == capacity) {
                remove(tail.prev);
            }
            insertFront(new Node(key, value));
        }
        
        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        private void insertFront(Node node) {
            map.put(node.key, node);
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }
        
        public void printCache() {
            Node curr = head.next;
            System.out.print("Cache (MRU -> LRU): ");
            while (curr != tail) {
                System.out.print(curr.key + (curr.next != tail ? ", " : ""));
                curr = curr.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        System.out.println("PUT(1), PUT(2), PUT(3)");
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.printCache();
        
        System.out.println("GET(1)");
        cache.get(1);
        cache.printCache();
        
        System.out.println("PUT(4)");
        cache.put(4, 40);
        cache.printCache();
    }
}
