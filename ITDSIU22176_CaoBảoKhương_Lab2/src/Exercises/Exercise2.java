package Exercises;

import Sorting.MergeSort;
import Sorting.QuickSort;
import Sorting.SortInstrumentation;
import java.util.Arrays;
import java.util.Random;

public class Exercise2 {
    public static void main(String[] args) {
        int n = 1000;
        int[] random = new int[n];
        int[] sorted = new int[n];
        int[] reverse = new int[n];
        int[] duplicates = new int[n];
        
        Random rand = new Random(42);
        for(int i=0; i<n; i++) {
            random[i] = rand.nextInt(n);
            sorted[i] = i;
            reverse[i] = n - i;
            duplicates[i] = rand.nextInt(5); // Only 5 distinct values
        }
        
        System.out.println("--- Comparing Advanced Sorts (N = " + n + ") ---");
        runTest("Random", random);
        runTest("Already Sorted", sorted);
        runTest("Reverse Sorted", reverse);
        runTest("Many Duplicates", duplicates);
    }
    
    private static void runTest(String desc, int[] data) {
        System.out.println("Dataset: " + desc);
        int[] dataForMerge = Arrays.copyOf(data, data.length);
        int[] dataForQuick = Arrays.copyOf(data, data.length);
        
        SortInstrumentation mergeInst = new SortInstrumentation();
        MergeSort.sort(dataForMerge, mergeInst);
        
        SortInstrumentation quickInst = new SortInstrumentation();
        QuickSort.sort(dataForQuick, quickInst);
        
        System.out.println("Merge Sort => Comps: " + mergeInst.comparisons + ", Swaps/Moves: " + mergeInst.swapsMoves + ", Depth: " + mergeInst.maxDepth);
        System.out.println("Quick Sort => Comps: " + quickInst.comparisons + ", Swaps/Moves: " + quickInst.swapsMoves + ", Depth: " + quickInst.maxDepth);
        System.out.println();
    }
}
