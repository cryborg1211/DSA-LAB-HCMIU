package PartB;

/**
 * Exercise B1: Range Sum Query
 * Given an integer array and multiple queries (L,R), return the sum of elements 
 * from index L to index R for each query.
 */
public class B1_RangeSumQuery {
    private long[] prefixSum;

    public B1_RangeSumQuery(int[] nums) {
        int n = nums.length;
        prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public long query(int L, int R) {
        if (L < 0 || R >= prefixSum.length - 1 || L > R) {
            throw new IllegalArgumentException("Invalid range");
        }
        return prefixSum[R + 1] - prefixSum[L];
    }
}
