package Sorting;

public class QuickSort {
    
    public static void sort(int[] arr) {
        sort(arr, new SortInstrumentation());
    }

    public static void sort(int[] arr, SortInstrumentation inst) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1, inst);
    }

    private static void quickSort(int[] arr, int low, int high, SortInstrumentation inst) {
        inst.enterRecursion();
        if (low < high) {
            int pivotIndex = medianOfThree(arr, low, high, inst);
            swap(arr, pivotIndex, high, inst); // Move pivot to end
            
            int pi = partition(arr, low, high, inst);

            quickSort(arr, low, pi - 1, inst);
            quickSort(arr, pi + 1, high, inst);
        }
        inst.exitRecursion();
    }
    
    private static int medianOfThree(int[] arr, int low, int high, SortInstrumentation inst) {
        int mid = low + (high - low) / 2;
        
        inst.recordComparison();
        if (arr[low] > arr[mid]) swap(arr, low, mid, inst);
        
        inst.recordComparison();
        if (arr[low] > arr[high]) swap(arr, low, high, inst);
        
        inst.recordComparison();
        if (arr[mid] > arr[high]) swap(arr, mid, high, inst);
        
        return mid;
    }

    private static int partition(int[] arr, int low, int high, SortInstrumentation inst) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            inst.recordComparison();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j, inst);
            }
        }

        swap(arr, i + 1, high, inst);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j, SortInstrumentation inst) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        inst.recordSwapMove();
    }

    public static void main(String[] args) {
        int[] test1 = {5, 2, 9, 1, 5, 6};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {9, 8, 7, 6, 5};

        System.out.println("Testing Quick Sort:");
        testAndPrint(test1.clone());
        testAndPrint(test2.clone());
        testAndPrint(test3.clone());
    }

    public static void testAndPrint(int[] arr) {
        System.out.print("Original: ");
        printArray(arr);
        SortInstrumentation inst = new SortInstrumentation();
        sort(arr, inst);
        System.out.print("Sorted:   ");
        printArray(arr);
        inst.printStats("QuickSort");
        System.out.println("========");
    }

    private static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}
