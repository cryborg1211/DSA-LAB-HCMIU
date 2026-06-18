package PartB;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise B5: Longest Subarray with Sum k
 * Given an integer array and an integer k, return the maximum length 
 * of a contiguous subarray whose sum equals k.
 */
public class B5_LongestSubarraySumK {
    public static int longestSubarray(int[] nums, int k) {
        Map<Long, Integer> firstOccurrence = new HashMap<>();
        long currentSum = 0;
        int maxLen = 0;
        
        firstOccurrence.put(0L, -1);
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (firstOccurrence.containsKey(currentSum - k)) {
                maxLen = Math.max(maxLen, i - firstOccurrence.get(currentSum - k));
            }
            // Only store if not seen before to keep it as "earliest position"
            if (!firstOccurrence.containsKey(currentSum)) {
                firstOccurrence.put(currentSum, i);
            }
        }
        
        return maxLen;
    }
}
