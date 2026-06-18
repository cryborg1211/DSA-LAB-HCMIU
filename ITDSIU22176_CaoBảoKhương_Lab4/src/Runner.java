import PartB.*;
import PartC.*;

public class Runner {
    public static void main(String[] args) {
        testB1();
        testB2();
        testB3();
        testB4();
        testB5();
        testB6();
        testC1();
        testC2();
    }

    private static void testB1() {
        System.out.println("--- Testing B1: Range Sum Query ---");
        int[] nums = {1, 2, 3, 4, 5};
        B1_RangeSumQuery solver = new B1_RangeSumQuery(nums);
        
        printTest("Range [0, 2]", "6", String.valueOf(solver.query(0, 2)));
        printTest("Range [1, 3]", "9", String.valueOf(solver.query(1, 3)));
        printTest("Range [0, 4]", "15", String.valueOf(solver.query(0, 4)));
        System.out.println();
    }

    private static void testB2() {
        System.out.println("--- Testing B2: Zero-Sum Subarray ---");
        printTest("{4, 2, -3, 1, 6}", "true", String.valueOf(B2_ZeroSumSubarray.hasZeroSumSubarray(new int[]{4, 2, -3, 1, 6})));
        printTest("{1, 2, 3}", "false", String.valueOf(B2_ZeroSumSubarray.hasZeroSumSubarray(new int[]{1, 2, 3})));
        printTest("{0, 1}", "true", String.valueOf(B2_ZeroSumSubarray.hasZeroSumSubarray(new int[]{0, 1})));
        System.out.println();
    }

    private static void testB3() {
        System.out.println("--- Testing B3: Subarray Sum Equals k (Existence) ---");
        printTest("{1, 2, 3}, k=3", "true", String.valueOf(B3_SubarraySumEqualsKExistence.hasSubarraySumK(new int[]{1, 2, 3}, 3)));
        printTest("{1, 2, 3}, k=7", "false", String.valueOf(B3_SubarraySumEqualsKExistence.hasSubarraySumK(new int[]{1, 2, 3}, 7)));
        printTest("{-1, 1, 0}, k=0", "true", String.valueOf(B3_SubarraySumEqualsKExistence.hasSubarraySumK(new int[]{-1, 1, 0}, 0)));
        System.out.println();
    }

    private static void testB4() {
        System.out.println("--- Testing B4: Count Subarrays Sum k ---");
        printTest("{1, 1, 1}, k=2", "2", String.valueOf(B4_CountSubarraysSumK.countSubarrays(new int[]{1, 1, 1}, 2)));
        printTest("{1, 2, 3}, k=3", "2", String.valueOf(B4_CountSubarraysSumK.countSubarrays(new int[]{1, 2, 3}, 3)));
        printTest("{1, -1, 0}, k=0", "3", String.valueOf(B4_CountSubarraysSumK.countSubarrays(new int[]{1, -1, 0}, 0)));
        System.out.println();
    }

    private static void testB5() {
        System.out.println("--- Testing B5: Longest Subarray Sum k ---");
        printTest("{1, -1, 5, -2, 3}, k=3", "4", String.valueOf(B5_LongestSubarraySumK.longestSubarray(new int[]{1, -1, 5, -2, 3}, 3)));
        printTest("{1, 2, 3}, k=6", "3", String.valueOf(B5_LongestSubarraySumK.longestSubarray(new int[]{1, 2, 3}, 6)));
        printTest("{-2, -1, 2, 1}, k=1", "2", String.valueOf(B5_LongestSubarraySumK.longestSubarray(new int[]{-2, -1, 2, 1}, 1)));
        System.out.println();
    }

    private static void testB6() {
        System.out.println("--- Testing B6: Pivot Index ---");
        printTest("{1, 7, 3, 6, 5, 6}", "3", String.valueOf(B6_PivotIndex.findPivot(new int[]{1, 7, 3, 6, 5, 6})));
        printTest("{1, 2, 3}", "-1", String.valueOf(B6_PivotIndex.findPivot(new int[]{1, 2, 3})));
        printTest("{2, 1, -1}", "0", String.valueOf(B6_PivotIndex.findPivot(new int[]{2, 1, -1})));
        System.out.println();
    }

    private static void testC1() {
        System.out.println("--- Testing C1: Longest Subarray Equal 0s and 1s ---");
        printTest("{0, 1}", "2", String.valueOf(C1_LongestSubarrayEqual01.longestSubarray(new int[]{0, 1})));
        printTest("{0, 1, 0, 1}", "4", String.valueOf(C1_LongestSubarrayEqual01.longestSubarray(new int[]{0, 1, 0, 1})));
        printTest("{0, 0, 1, 1, 0}", "4", String.valueOf(C1_LongestSubarrayEqual01.longestSubarray(new int[]{0, 0, 1, 1, 0})));
        System.out.println();
    }

    private static void testC2() {
        System.out.println("--- Testing C2: Count Subarrays Divisible by k ---");
        printTest("{4, 5, 0, -2, -3, 1}, k=5", "7", String.valueOf(C2_CountSubarraysDivisibleByK.countDivisibleByK(new int[]{4, 5, 0, -2, -3, 1}, 5)));
        printTest("{5}, k=9", "0", String.valueOf(C2_CountSubarraysDivisibleByK.countDivisibleByK(new int[]{5}, 9)));
        printTest("{-1, 2, 9}, k=2", "2", String.valueOf(C2_CountSubarraysDivisibleByK.countDivisibleByK(new int[]{-1, 2, 9}, 2)));
        System.out.println();
    }

    private static void printTest(String input, String expected, String actual) {
        System.out.printf("Input: %-25s | Expected: %-5s | Actual: %-5s | Result: %s%n", 
            input, expected, actual, expected.equals(actual) ? "PASS" : "FAIL");
    }
}
