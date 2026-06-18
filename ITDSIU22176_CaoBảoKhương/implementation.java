public class Implementation {
    public static void merge(int[] theArray, int[] workspace, int lowPtr, int highPtr, int upperBound) {
        int tempIndex = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // Số lượng phần tử

        // 1. Trộn hai nửa mảng
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr]) { // Sắp xếp tăng dần
                workspace[tempIndex++] = theArray[lowPtr++];
            } else {
                workspace[tempIndex++] = theArray[highPtr++]; // Chỗ này phải là ++ nhé!
            }
        }

        // 2. Hốt nốt các phần tử còn sót lại bên trái
        while (lowPtr <= mid) {
            workspace[tempIndex++] = theArray[lowPtr++];
        }

        // 3. Hốt nốt các phần tử còn sót lại bên phải
        while (highPtr <= upperBound) {
            workspace[tempIndex++] = theArray[highPtr++];
        }

        // 4. Chép ngược từ workspace về mảng gốc
        for (int i = 0; i < n; i++) {
            theArray[lowerBound + i] = workspace[i];
        }
    }
}