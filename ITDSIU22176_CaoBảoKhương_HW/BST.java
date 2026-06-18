public class BST {
    
    // Node class to represent each node in the tree
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the BST
    Node root;

    public BST() {
        root = null;
    }

    // 1. Insert a node into the BST
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // 2. Search for a node
    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node root, int data) {
        // Base Cases: root is null or data is present at root
        if (root == null) return false;
        if (root.data == data) return true;

        // Data is greater than root's data
        if (data > root.data) {
            return searchRecursive(root.right, data);
        }

        // Data is smaller than root's data
        return searchRecursive(root.left, data);
    }

    // 3. Delete a node
    public void delete(int data) {
        root = deleteRecursive(root, data);
    }

    private Node deleteRecursive(Node root, int data) {
        // Base Case: empty tree
        if (root == null) return root;

        // Recur down the tree
        if (data < root.data) {
            root.left = deleteRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRecursive(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // A utility function to do inorder traversal (to check if it works)
    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the BST:");
        tree.inorder();

        System.out.println("\nSearch for 40: " + (tree.search(40) ? "Found" : "Not Found"));
        System.out.println("Search for 90: " + (tree.search(90) ? "Found" : "Not Found"));

        System.out.println("\nDelete 20 (Leaf node)");
        tree.delete(20);
        tree.inorder();

        System.out.println("\nDelete 30 (Node with one child)");
        tree.delete(30);
        tree.inorder();

        System.out.println("\nDelete 50 (Node with two children)");
        tree.delete(50);
        tree.inorder();
    }
}
