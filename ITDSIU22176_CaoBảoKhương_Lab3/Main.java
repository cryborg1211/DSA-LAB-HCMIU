import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Lab 3: Two Pointers and Sliding Window ===");
        System.out.println("Student: Cao Bao Khuong | ID: ITDSIU22176\n");

        testB1();
        testB2();
        testB3();
        testB4();
        testB5();
        testB6();
        testC1();
        testC2();
        testDistinct();
    }

    private static void testB1() {
        System.out.println("--- B1: Two Sum II ---");
        int[][] inputs = {{2, 7, 11, 15}, {2, 3, 4}, {-1, 0}};
        int[] targets = {9, 6, -1};
        for (int i = 0; i < inputs.length; i++) {
            int[] res = B1_TwoSumII.solve(inputs[i], targets[i]);
            System.out.printf("Test %d: %s, target %d -> Result: [%d, %d]\n", i + 1, Arrays.toString(inputs[i]), targets[i], res[0], res[1]);
        }
        System.out.println();
    }

    private static void testB2() {
        System.out.println("--- B2: Remove Duplicates ---");
        int[][] inputs = {{1, 1, 2}, {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, {1}};
        for (int i = 0; i < inputs.length; i++) {
            int len = B2_RemoveDuplicates.solve(inputs[i]);
            System.out.printf("Test %d: %s -> New Length: %d\n", i + 1, Arrays.toString(inputs[i]), len);
        }
        System.out.println();
    }

    private static void testB3() {
        System.out.println("--- B3: Move Zeroes ---");
        int[][] inputs = {{0, 1, 0, 3, 12}, {0}, {4, 2, 4, 0, 0, 3, 0, 5, 1, 0}};
        for (int i = 0; i < inputs.length; i++) {
            B3_MoveZeroes.solve(inputs[i]);
            System.out.printf("Test %d: -> Result: %s\n", i + 1, Arrays.toString(inputs[i]));
        }
        System.out.println();
    }

    private static void testB4() {
        System.out.println("--- B4: Max Sum Subarray of Size k ---");
        int[][] inputs = {{2, 1, 5, 1, 3, 2}, {2, 3, 4, 1, 5}, {1, 2, 3}};
        int[] ks = {3, 2, 1};
        for (int i = 0; i < inputs.length; i++) {
            int res = B4_MaxSumSubarray.solve(inputs[i], ks[i]);
            System.out.printf("Test %d: %s, k=%d -> Result: %d\n", i + 1, Arrays.toString(inputs[i]), ks[i], res);
        }
        System.out.println();
    }

    private static void testB5() {
        System.out.println("--- B5: Minimum Size Subarray Sum ---");
        int[] targets = {7, 4, 11};
        int[][] inputs = {{2, 3, 1, 2, 4, 3}, {1, 4, 4}, {1, 1, 1, 1, 1, 1, 1, 1}};
        for (int i = 0; i < inputs.length; i++) {
            int res = B5_MinSizeSubarraySum.solve(targets[i], inputs[i]);
            System.out.printf("Test %d: target %d, %s -> Result: %d\n", i + 1, targets[i], Arrays.toString(inputs[i]), res);
        }
        System.out.println();
    }

    private static void testB6() {
        System.out.println("--- B6: Longest Substring Without Repeating Characters ---");
        String[] inputs = {"abcabcbb", "bbbbb", "pwwkew"};
        for (int i = 0; i < inputs.length; i++) {
            int res = B6_LongestSubstring.solve(inputs[i]);
            System.out.printf("Test %d: \"%s\" -> Result: %d\n", i + 1, inputs[i], res);
        }
        System.out.println();
    }

    private static void testC1() {
        System.out.println("--- C1: Container With Most Water ---");
        int[][] inputs = {{1, 8, 6, 2, 5, 4, 8, 3, 7}, {1, 1}, {4, 3, 2, 1, 4}};
        for (int i = 0; i < inputs.length; i++) {
            int res = C1_ContainerWithMostWater.solve(inputs[i]);
            System.out.printf("Test %d: %s -> Result: %d\n", i + 1, Arrays.toString(inputs[i]), res);
        }
        System.out.println();
    }

    private static void testC2() {
        System.out.println("--- C2: 3Sum ---");
        int[][] inputs = {{-1, 0, 1, 2, -1, -4}, {0, 1, 1}, {0, 0, 0}};
        for (int i = 0; i < inputs.length; i++) {
            List<List<Integer>> res = C2_ThreeSum.solve(inputs[i]);
            System.out.printf("Test %d: %s -> Result: %s\n", i + 1, Arrays.toString(inputs[i]), res);
        }
        System.out.println();
    }

    private static void testDistinct() {
        System.out.println("--- Card 25: Longest Substring with at most k Distinct Characters ---");
        String[] strings = {"eceba", "aa", "aabacbebebe"};
        int[] ks = {2, 1, 3};
        for (int i = 0; i < strings.length; i++) {
            int res = Distinct.solve(strings[i], ks[i]);
            System.out.printf("Test %d: \"%s\", k=%d -> Result: %d\n", i + 1, strings[i], ks[i], res);
        }
        System.out.println();
    }
}
