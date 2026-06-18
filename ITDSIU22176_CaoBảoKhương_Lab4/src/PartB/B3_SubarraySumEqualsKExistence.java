package PartB;

import java.util.HashSet;
import java.util.Set;

/**
 * Exercise B3: Subarray Sum Equals k (Existence)
 * Given an integer array and an integer k, determine whether there exists 
 * a contiguous subarray whose sum equals k.
 */
public class B3_SubarraySumEqualsKExistence {
    public static boolean hasSubarraySumK(int[] nums, int k) {
        Set<Long> seenSums = new HashSet<>();
        long currentSum = 0;
        
        seenSums.add(0L);
        
        for (int num : nums) {
            currentSum += num;
            // Check if (currentSum - earlierSum) == k  => earlierSum = currentSum - k
            if (seenSums.contains(currentSum - k)) {
                return true;
            }
            seenSums.add(currentSum);
        }
        
        return false;
    }
}
