// Student: Cao Bao Khuong - ITDSIU22176
// Lab 5 - Exercise C3: Kth Largest Element in an Array
// Data structure: PriorityQueue (min-heap of size k)

import java.util.PriorityQueue;

public class ExerciseC3_KthLargest {

    // idea: keep a min-heap with exactly k elements
    // when we add the (k+1)th element, remove the smallest
    // at the end, the top of the heap is the kth largest
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest to keep only top-k
            }
        }

        return minHeap.peek(); // the kth largest
    }

    public static void main(String[] args) {
        // test 1: from the lab
        System.out.println("Test 1: " + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5

        // test 2: k = 1 should give max
        System.out.println("Test 2: " + findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 1)); // 6

        // test 3: edge - single element
        System.out.println("Test 3: " + findKthLargest(new int[]{1}, 1)); // 1

        // test 4: k = length of array -> minimum
        System.out.println("Test 4: " + findKthLargest(new int[]{5, 3, 7, 1}, 4)); // 1

        // test 5: duplicates
        System.out.println("Test 5: " + findKthLargest(new int[]{2, 2, 2, 2}, 2)); // 2
    }
}
