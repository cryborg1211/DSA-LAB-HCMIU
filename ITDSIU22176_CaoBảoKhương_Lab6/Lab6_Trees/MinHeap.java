import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> heap;

    MinHeap() {
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.isEmpty();
    }

    int peekMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    int extractMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        int min = heap.get(0);
        // Move the last element to root, then heapify down
        int last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // After insert: bubble the new value up until heap property is restored
    void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, tmp);
                i = parent;
            } else {
                break;
            }
        }
    }

    // After extractMin: push root value down until heap property is restored
    void heapifyDown(int i) {
        int size = heap.size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(smallest));
                heap.set(smallest, tmp);
                i = smallest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Sample from the lab
        System.out.println("=== Test Case 1: Sample from lab ===");
        MinHeap mh1 = new MinHeap();
        mh1.insert(10);
        mh1.insert(4);
        mh1.insert(15);
        mh1.insert(2);
        System.out.println("peekMin():    " + mh1.peekMin());      // 2
        System.out.println("extractMin(): " + mh1.extractMin());   // 2
        System.out.println("peekMin():    " + mh1.peekMin());      // 4

        System.out.println();

        // Test Case 2: Repeated values
        System.out.println("=== Test Case 2: Repeated Values ===");
        MinHeap mh2 = new MinHeap();
        mh2.insert(5);
        mh2.insert(5);
        mh2.insert(5);
        System.out.println("extractMin(): " + mh2.extractMin());  // 5
        System.out.println("extractMin(): " + mh2.extractMin());  // 5
        System.out.println("isEmpty:      " + mh2.isEmpty());     // false
        System.out.println("extractMin(): " + mh2.extractMin());  // 5
        System.out.println("isEmpty:      " + mh2.isEmpty());     // true

        System.out.println();

        // Test Case 3: Extract all in sorted order (heap sort style)
        System.out.println("=== Test Case 3: Sorted Extraction Order ===");
        MinHeap mh3 = new MinHeap();
        int[] vals = {9, 3, 7, 1, 8, 2};
        for (int v : vals) mh3.insert(v);
        System.out.print("Extracted order: ");
        while (!mh3.isEmpty()) {
            System.out.print(mh3.extractMin() + " ");
        }
        System.out.println();  // expected: 1 2 3 7 8 9

        System.out.println();

        // Test Case 4: Edge case - extract from empty heap
        System.out.println("=== Test Case 4: Extract from Empty Heap ===");
        MinHeap mh4 = new MinHeap();
        System.out.println("isEmpty: " + mh4.isEmpty());
        try {
            mh4.extractMin();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
