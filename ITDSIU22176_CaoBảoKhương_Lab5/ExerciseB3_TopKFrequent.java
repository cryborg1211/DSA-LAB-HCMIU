// Student: Cao Bao Khuong - ITDSIU22176
// Lab 5 - Exercise B3: Top K Frequent Elements
// Data structure: HashMap + PriorityQueue (min-heap)

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ExerciseB3_TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: count how many times each number appears
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: use a min-heap of size k
        // we keep only the k most frequent elements
        // the heap orders by frequency - smallest freq at top
        // when size > k, we remove the least frequent one
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        for (int num : freq.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // drop the element with lowest freq
            }
        }

        // Step 3: collect the result
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        // test 1: basic case from the lab
        int[] res1 = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("Test 1: " + Arrays.toString(res1)); // [1, 2]

        // test 2: k = 1, only the most frequent
        int[] res2 = topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 1);
        System.out.println("Test 2: " + Arrays.toString(res2)); // [3]

        // test 3: all same frequency
        int[] res3 = topKFrequent(new int[]{1, 2, 3}, 2);
        System.out.println("Test 3: " + Arrays.toString(res3)); // any 2

        // test 4: single element
        int[] res4 = topKFrequent(new int[]{5}, 1);
        System.out.println("Test 4: " + Arrays.toString(res4)); // [5]
    }
}
