// Student: Cao Bao Khuong - ITDSIU22176
// Lab 5 - Exercise B2: Circular Queue using Array
// Manual implementation - no Java built-in Queue allowed

public class ExerciseB2_CircularQueue {

    static class CircularQueue {
        private int[] arr;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = 0;
            size = 0;
        }

        // add element to rear
        // use modulo so rear wraps around when it hits the end
        public boolean enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue is full! Cannot enqueue " + value);
                return false;
            }
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }

        // remove element from front
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty! Cannot dequeue");
                return -1;
            }
            int val = arr[front];
            front = (front + 1) % capacity;
            size--;
            return val;
        }

        public int front() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {
        // --- required behavior from lab ---
        System.out.println("=== Required behavior (capacity = 3) ===");
        CircularQueue cq = new CircularQueue(3);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        System.out.println("isFull() -> " + cq.isFull());    // true
        System.out.println("dequeue() -> " + cq.dequeue());  // 10
        cq.enqueue(40);
        System.out.println("front() -> " + cq.front());      // 20

        System.out.println();

        // --- edge case: dequeue on empty ---
        System.out.println("=== Edge: dequeue from empty ===");
        CircularQueue q2 = new CircularQueue(2);
        q2.dequeue();  // should print error message

        System.out.println();

        // --- edge case: enqueue on full ---
        System.out.println("=== Edge: enqueue into full ===");
        CircularQueue q3 = new CircularQueue(1);
        q3.enqueue(5);
        q3.enqueue(6); // should print error

        System.out.println();

        // --- wrap-around test ---
        System.out.println("=== Wrap-around test ===");
        CircularQueue q4 = new CircularQueue(3);
        q4.enqueue(1);
        q4.enqueue(2);
        q4.enqueue(3);
        q4.dequeue();     // removes 1, front moves to index 1
        q4.enqueue(4);    // rear wraps to index 0
        System.out.println("front() -> " + q4.front());      // 2
        System.out.println("dequeue() -> " + q4.dequeue());  // 2
        System.out.println("dequeue() -> " + q4.dequeue());  // 3
        System.out.println("dequeue() -> " + q4.dequeue());  // 4
        System.out.println("isEmpty() -> " + q4.isEmpty());  // true
    }
}
