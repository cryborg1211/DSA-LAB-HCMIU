package PartC;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise C1: Longest Subarray with equal number of 0s and 1s
 */
public class C1_LongestSubarrayEqual01 {
    public static int longestSubarray(int[] nums) {
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int currentSum = 0;
        int maxLen = 0;
        
        firstOccurrence.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += (nums[i] == 0 ? -1 : 1);
            if (firstOccurrence.containsKey(currentSum)) {
                maxLen = Math.max(maxLen, i - firstOccurrence.get(currentSum));
            } else {
                firstOccurrence.put(currentSum, i);
            }
        }
        
        return maxLen;
    }
}
