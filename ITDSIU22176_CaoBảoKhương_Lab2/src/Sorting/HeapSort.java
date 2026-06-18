package Sorting;

public class HeapSort {

    public static void sort(int[] arr) {
        sort(arr, new SortInstrumentation());
    }

    public static void sort(int[] arr, SortInstrumentation inst) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, inst);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i, inst);
            heapify(arr, i, 0, inst);
        }
    }

    private static void heapify(int[] arr, int n, int i, SortInstrumentation inst) {
        inst.enterRecursion();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n) {
            inst.recordComparison();
            if (arr[l] > arr[largest]) {
                largest = l;
            }
        }

        if (r < n) {
            inst.recordComparison();
            if (arr[r] > arr[largest]) {
                largest = r;
            }
        }

        if (largest != i) {
            swap(arr, i, largest, inst);
            heapify(arr, n, largest, inst);
        }
        inst.exitRecursion();
    }

    private static void swap(int[] arr, int i, int j, SortInstrumentation inst) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        inst.recordSwapMove();
    }
}
