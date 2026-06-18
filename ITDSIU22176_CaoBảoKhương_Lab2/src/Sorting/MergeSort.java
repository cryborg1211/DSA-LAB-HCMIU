package Sorting;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, new SortInstrumentation());
    }

    public static void sort(int[] arr, SortInstrumentation inst) {
        if (arr == null || arr.length <= 1) return;
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1, inst);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right, SortInstrumentation inst) {
        inst.enterRecursion();
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid, inst);
            mergeSort(arr, temp, mid + 1, right, inst);
            merge(arr, temp, left, mid, right, inst);
        }
        inst.exitRecursion();
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right, SortInstrumentation inst) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
            inst.recordSwapMove(); // copying to temp counts as move
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            inst.recordComparison();
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            inst.recordSwapMove();
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
            inst.recordSwapMove();
        }
    }
    
    // Basic test cases
    public static void main(String[] args) {
        int[] test1 = {5, 2, 9, 1, 5, 6};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {9, 8, 7, 6, 5};

        System.out.println("Testing Merge Sort:");
        testAndPrint(test1);
        testAndPrint(test2);
        testAndPrint(test3);
    }

    public static void testAndPrint(int[] arr) {
        System.out.print("Original: ");
        printArray(arr);
        SortInstrumentation inst = new SortInstrumentation();
        sort(arr, inst);
        System.out.print("Sorted:   ");
        printArray(arr);
        inst.printStats("MergeSort");
        System.out.println("========");
    }

    private static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}
