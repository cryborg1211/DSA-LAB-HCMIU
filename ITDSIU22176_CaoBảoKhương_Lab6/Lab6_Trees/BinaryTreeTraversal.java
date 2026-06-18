import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeTraversal {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Preorder: Root -> Left -> Right
    static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder: Left -> Root -> Right
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    // Postorder: Left -> Right -> Root
    static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    // Level-order uses a queue to visit nodes level by level (BFS)
    static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Sample tree from the lab
        //       10
        //      /  \
        //     5    20
        //    / \     \
        //   3   7    30
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(30);

        System.out.println("=== Test Case 1: Sample Tree ===");
        System.out.print("Preorder:    "); preorder(root);    System.out.println();
        System.out.print("Inorder:     "); inorder(root);     System.out.println();
        System.out.print("Postorder:   "); postorder(root);   System.out.println();
        System.out.print("Level-order: "); levelOrder(root);  System.out.println();

        System.out.println();

        // Test Case 2: Single node (edge case)
        TreeNode single = new TreeNode(42);
        System.out.println("=== Test Case 2: Single Node ===");
        System.out.print("Preorder:    "); preorder(single);    System.out.println();
        System.out.print("Inorder:     "); inorder(single);     System.out.println();
        System.out.print("Postorder:   "); postorder(single);   System.out.println();
        System.out.print("Level-order: "); levelOrder(single);  System.out.println();

        System.out.println();

        // Test Case 3: Empty tree (edge case)
        System.out.println("=== Test Case 3: Empty Tree (null) ===");
        System.out.print("Preorder:    "); preorder(null);    System.out.println("(empty)");
        System.out.print("Inorder:     "); inorder(null);     System.out.println("(empty)");
        System.out.print("Postorder:   "); postorder(null);   System.out.println("(empty)");
        System.out.print("Level-order: "); levelOrder(null);  System.out.println("(empty)");

        System.out.println();

        // Test Case 4: Right-skewed tree
        //  1
        //   \
        //    2
        //     \
        //      3
        TreeNode skewed = new TreeNode(1);
        skewed.right = new TreeNode(2);
        skewed.right.right = new TreeNode(3);
        System.out.println("=== Test Case 4: Right-skewed Tree ===");
        System.out.print("Preorder:    "); preorder(skewed);    System.out.println();
        System.out.print("Inorder:     "); inorder(skewed);     System.out.println();
        System.out.print("Postorder:   "); postorder(skewed);   System.out.println();
        System.out.print("Level-order: "); levelOrder(skewed);  System.out.println();
    }
}
