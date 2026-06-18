package PartC;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise C2: Count subarrays whose sum is divisible by k
 */
public class C2_CountSubarraysDivisibleByK {
    public static int countDivisibleByK(int[] nums, int k) {
        Map<Integer, Integer> remainderFrequency = new HashMap<>();
        int currentSum = 0;
        int count = 0;
        
        remainderFrequency.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            int remainder = currentSum % k;
            
            // Handle negative remainders in Java
            if (remainder < 0) {
                remainder += k;
            }
            
            count += remainderFrequency.getOrDefault(remainder, 0);
            remainderFrequency.put(remainder, remainderFrequency.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}
