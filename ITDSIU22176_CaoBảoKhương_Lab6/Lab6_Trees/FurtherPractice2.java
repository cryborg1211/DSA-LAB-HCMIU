// C2: Lowest Common Ancestor in a BST

public class FurtherPractice2 {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // Use BST property to navigate:
    // - if both p and q are smaller, LCA must be in left subtree
    // - if both are larger, LCA must be in right subtree
    // - otherwise, current node is the split point = LCA
    static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (p < root.value && q < root.value) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p > root.value && q > root.value) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        // Build BST from lab:
        //       6
        //      / \
        //     2   8
        //    / \ / \
        //   0  4 7  9
        //     / \
        //    3   5
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Test Case 1: p=2, q=8 -> one is in left subtree, one in right -> LCA = 6
        TreeNode lca1 = lowestCommonAncestor(root, 2, 8);
        System.out.println("=== Test Case 1: LCA(2, 8) ===");
        System.out.println("LCA: " + lca1.value);  // 6

        System.out.println();

        // Test Case 2: p=2, q=4 -> 4 is a descendant of 2 -> LCA = 2
        TreeNode lca2 = lowestCommonAncestor(root, 2, 4);
        System.out.println("=== Test Case 2: LCA(2, 4) ===");
        System.out.println("LCA: " + lca2.value);  // 2

        System.out.println();

        // Test Case 3: p=3, q=5 -> both under 4 -> LCA = 4
        TreeNode lca3 = lowestCommonAncestor(root, 3, 5);
        System.out.println("=== Test Case 3: LCA(3, 5) ===");
        System.out.println("LCA: " + lca3.value);  // 4

        System.out.println();

        // Test Case 4: p=7, q=9 -> both under 8 -> LCA = 8
        TreeNode lca4 = lowestCommonAncestor(root, 7, 9);
        System.out.println("=== Test Case 4: LCA(7, 9) ===");
        System.out.println("LCA: " + lca4.value);  // 8
    }
}
