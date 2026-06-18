package PartB;

import java.util.HashSet;
import java.util.Set;

/**
 * Exercise B2: Zero-Sum Subarray Exists
 * Given an integer array, determine whether there exists a non-empty 
 * contiguous subarray whose sum is 0.
 */
public class B2_ZeroSumSubarray {
    public static boolean hasZeroSumSubarray(int[] nums) {
        Set<Long> seenSums = new HashSet<>();
        long currentSum = 0;
        
        // Initial state: sum of 0 has been seen at the very beginning (empty prefix)
        seenSums.add(0L);
        
        for (int num : nums) {
            currentSum += num;
            if (seenSums.contains(currentSum)) {
                return true;
            }
            seenSums.add(currentSum);
        }
        
        return false;
    }
}
