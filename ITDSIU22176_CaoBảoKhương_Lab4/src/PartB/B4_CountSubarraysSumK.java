package PartB;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise B4: Count Subarrays with Sum k
 * Given an integer array and an integer k, return the number of 
 * contiguous subarrays whose sum equals k.
 */
public class B4_CountSubarraysSumK {
    public static int countSubarrays(int[] nums, int k) {
        Map<Long, Integer> sumFrequency = new HashMap<>();
        long currentSum = 0;
        int count = 0;
        
        sumFrequency.put(0L, 1);
        
        for (int num : nums) {
            currentSum += num;
            count += sumFrequency.getOrDefault(currentSum - k, 0);
            sumFrequency.put(currentSum, sumFrequency.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
