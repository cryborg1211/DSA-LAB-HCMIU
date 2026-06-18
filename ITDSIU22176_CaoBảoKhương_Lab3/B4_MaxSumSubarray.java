public class B4_MaxSumSubarray {
    public static int solve(int[] nums, int k) {
        int maxSum = 0, currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[i - (k - 1)];
            }
        }
        return maxSum;
    }
}
