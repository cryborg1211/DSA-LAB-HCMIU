public class ValidateBST {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // Check if node value is within valid range (min, max)
    // When going left, upper bound becomes current node value
    // When going right, lower bound becomes current node value
    static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return validate(node.left, min, node.value) &&
               validate(node.right, node.value, max);
    }

    static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        // Test Case 1: Valid BST
        //    5
        //   / \
        //  3   7
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(7);
        System.out.println("=== Test Case 1: Valid BST [5,3,7] ===");
        System.out.println("isValidBST: " + isValidBST(t1));  // true

        System.out.println();

        // Test Case 2: Invalid BST - 4 is right child of 7 but 4 < 5 (violates upper bound)
        //    5
        //   / \
        //  3   7
        //     /
        //    4    <- 4 < 5, invalid for right subtree of 5
        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(7);
        t2.right.left = new TreeNode(4);
        System.out.println("=== Test Case 2: Invalid BST [5,3,7,_,_,4] ===");
        System.out.println("isValidBST: " + isValidBST(t2));  // false

        System.out.println();

        // Test Case 3: Valid larger BST
        //        50
        //       /  \
        //      30   70
        //     / \  / \
        //    20 40 60 80
        TreeNode t3 = new TreeNode(50);
        t3.left = new TreeNode(30);
        t3.right = new TreeNode(70);
        t3.left.left = new TreeNode(20);
        t3.left.right = new TreeNode(40);
        t3.right.left = new TreeNode(60);
        t3.right.right = new TreeNode(80);
        System.out.println("=== Test Case 3: Valid Large BST ===");
        System.out.println("isValidBST: " + isValidBST(t3));  // true

        System.out.println();

        // Test Case 4: Edge case - single node
        TreeNode t4 = new TreeNode(10);
        System.out.println("=== Test Case 4: Single Node ===");
        System.out.println("isValidBST: " + isValidBST(t4));  // true

        System.out.println();

        // Test Case 5: Edge case - null tree
        System.out.println("=== Test Case 5: Null Tree ===");
        System.out.println("isValidBST: " + isValidBST(null));  // true

        System.out.println();

        // Test Case 6: Tricky case - looks valid locally but not globally
        //    10
        //   /  \
        //  5    15
        //      /  \
        //     6    20   <- 6 < 10, invalid even though 6 > 5 locally under 15
        TreeNode t6 = new TreeNode(10);
        t6.left = new TreeNode(5);
        t6.right = new TreeNode(15);
        t6.right.left = new TreeNode(6);
        t6.right.right = new TreeNode(20);
        System.out.println("=== Test Case 6: Tricky Invalid BST ===");
        System.out.println("isValidBST: " + isValidBST(t6));  // false
    }
}
