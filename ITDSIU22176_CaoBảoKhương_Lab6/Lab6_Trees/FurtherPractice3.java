// C3: Kth Smallest Element in a BST

public class FurtherPractice3 {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // Inorder traversal of BST gives sorted order.
    // We count how many nodes we have visited;
    // when count reaches k, that is the answer.
    static int count = 0;
    static int result = -1;

    static void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.value;
            return;
        }
        inorder(node.right, k);
    }

    static int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    public static void main(String[] args) {
        // Build BST from lab:
        //     5
        //    / \
        //   3   6
        //  / \
        // 2   4
        // /
        // 1
        // Inorder: 1 2 3 4 5 6
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        // Test Case 1: k=3 -> 3rd smallest = 3
        System.out.println("=== Test Case 1: k=3 ===");
        System.out.println("3rd smallest: " + kthSmallest(root, 3));  // 3

        System.out.println();

        // Test Case 2: k=1 -> minimum element = 1
        System.out.println("=== Test Case 2: k=1 (minimum) ===");
        System.out.println("1st smallest: " + kthSmallest(root, 1));  // 1

        System.out.println();

        // Test Case 3: k=6 -> maximum element = 6
        System.out.println("=== Test Case 3: k=6 (maximum) ===");
        System.out.println("6th smallest: " + kthSmallest(root, 6));  // 6

        System.out.println();

        // Test Case 4: k=4
        System.out.println("=== Test Case 4: k=4 ===");
        System.out.println("4th smallest: " + kthSmallest(root, 4));  // 4
    }
}
