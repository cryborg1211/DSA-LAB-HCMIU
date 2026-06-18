package PartB;

/**
 * Exercise B6: Pivot Index / Equilibrium Index
 * Find an index such that the sum of elements to its left equals the sum 
 * of elements to its right. Return the index if it exists; otherwise return -1.
 */
public class B6_PivotIndex {
    public static int findPivot(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        long leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // totalSum - leftSum - nums[i] is the right sum
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1;
    }
}
