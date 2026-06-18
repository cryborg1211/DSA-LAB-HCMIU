public class BinarySearchTree {

    static class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;

        BSTNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    BSTNode root;

    BinarySearchTree() {
        root = null;
    }

    // Recursive insert helper
    BSTNode insertHelper(BSTNode node, int value) {
        if (node == null) return new BSTNode(value);
        if (value < node.value) {
            node.left = insertHelper(node.left, value);
        } else if (value > node.value) {
            node.right = insertHelper(node.right, value);
        }
        // if value == node.value, we ignore duplicates
        return node;
    }

    void insert(int value) {
        root = insertHelper(root, value);
    }

    // Recursive search helper
    boolean searchHelper(BSTNode node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        if (value < node.value) return searchHelper(node.left, value);
        return searchHelper(node.right, value);
    }

    boolean search(int value) {
        return searchHelper(root, value);
    }

    // Inorder gives sorted output for a BST
    void inorderHelper(BSTNode node) {
        if (node == null) return;
        inorderHelper(node.left);
        System.out.print(node.value + " ");
        inorderHelper(node.right);
    }

    void inorderTraversal() {
        inorderHelper(root);
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Sample from the lab
        System.out.println("=== Test Case 1: Basic BST Operations ===");
        BinarySearchTree bst1 = new BinarySearchTree();
        int[] vals1 = {50, 30, 70, 20, 40, 60, 80};
        for (int v : vals1) bst1.insert(v);
        System.out.println("Inserted: 50 30 70 20 40 60 80");
        System.out.println("search(60): " + bst1.search(60));  // true
        System.out.println("search(25): " + bst1.search(25));  // false
        System.out.print("Inorder: ");
        bst1.inorderTraversal();  // 20 30 40 50 60 70 80

        System.out.println();

        // Test Case 2: Duplicate insertion is ignored
        System.out.println("=== Test Case 2: Duplicate Insertion ===");
        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(10);
        bst2.insert(5);
        bst2.insert(10); // duplicate, should be ignored
        bst2.insert(15);
        System.out.print("Inorder after inserting 10,5,10,15: ");
        bst2.inorderTraversal();  // 5 10 15

        System.out.println();

        // Test Case 3: Search for a missing value
        System.out.println("=== Test Case 3: Search Missing Value ===");
        BinarySearchTree bst3 = new BinarySearchTree();
        bst3.insert(100);
        bst3.insert(50);
        bst3.insert(200);
        System.out.println("search(75):  " + bst3.search(75));   // false
        System.out.println("search(100): " + bst3.search(100));  // true

        System.out.println();

        // Test Case 4: Edge case - single element tree
        System.out.println("=== Test Case 4: Single Element ===");
        BinarySearchTree bst4 = new BinarySearchTree();
        bst4.insert(1);
        System.out.println("search(1): " + bst4.search(1));  // true
        System.out.println("search(2): " + bst4.search(2));  // false
    }
}
