public class RearrangeArray {
    public static void rearrange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Trỏ trái tiến lên nếu số hiện tại đang là số âm (đã đúng vị trí)
            while (left <= right && nums[left] < 0) {
                left++;
            }

            // Trỏ phải lùi lại nếu số hiện tại đang là số dương hoặc bằng 0 (đã đúng vị
            // trí)
            while (left <= right && nums[right] >= 0) {
                right--;
            }

            // Nếu 2 trỏ chưa gặp nhau, tức là đã chốt được cặp đứng sai vị trí -> Swap
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                // Nhích tiếp 2 trỏ sau khi swap xong
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };

        rearrange(arr);

        System.out.print("Array sau khi sắp xếp: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output mong đợi: Các số âm nằm hết bên trái, dương/0 nằm hết bên phải.
        // Lưu ý: Thứ tự tương đối của các số sẽ không được giữ nguyên.
    }
}