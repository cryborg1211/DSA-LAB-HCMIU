// C1: Maximum Depth of a Binary Tree

public class FurtherPractice1 {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // Base case: null node has depth 0
    // Otherwise: depth = 1 + max(left depth, right depth)
    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        // Test Case 1: Lab example
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        System.out.println("=== Test Case 1: Lab Example ===");
        System.out.println("Max depth: " + maxDepth(t1));  // 3

        System.out.println();

        // Test Case 2: Single node (edge case)
        TreeNode t2 = new TreeNode(5);
        System.out.println("=== Test Case 2: Single Node ===");
        System.out.println("Max depth: " + maxDepth(t2));  // 1

        System.out.println();

        // Test Case 3: Null tree (edge case)
        System.out.println("=== Test Case 3: Null Tree ===");
        System.out.println("Max depth: " + maxDepth(null));  // 0

        System.out.println();

        // Test Case 4: Right-skewed tree (depth = 4)
        //  1
        //   \
        //    2
        //     \
        //      3
        //       \
        //        4
        TreeNode t4 = new TreeNode(1);
        t4.right = new TreeNode(2);
        t4.right.right = new TreeNode(3);
        t4.right.right.right = new TreeNode(4);
        System.out.println("=== Test Case 4: Right-skewed Tree ===");
        System.out.println("Max depth: " + maxDepth(t4));  // 4
    }
}
