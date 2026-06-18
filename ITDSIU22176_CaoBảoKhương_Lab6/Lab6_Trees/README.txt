================================================================
  DSA Lab 6 - Trees and Tree Variants
  Student: Cao Bao Khuong
  Student ID: ITDSIU22176
================================================================

File Structure:
  BinaryTreeTraversal.java  -> Exercise B1
  BinarySearchTree.java     -> Exercise B2
  ValidateBST.java          -> Exercise B3
  MinHeap.java              -> Exercise B4
  Trie.java                 -> Exercise B5
  FurtherPractice1.java     -> C1: Maximum Depth
  FurtherPractice2.java     -> C2: Lowest Common Ancestor in BST
  FurtherPractice3.java     -> C3: Kth Smallest Element in BST

================================================================
  PART A - GUIDED PRACTICE
================================================================

---------------------------------------------------
Task A1: Identify the Best Tree Variant
---------------------------------------------------

1. Print all values level by level
   -> Binary Tree with BFS (level-order traversal)
   Reason: level-order traversal visits nodes level by level using a queue,
   which naturally matches the "level by level" requirement.

2. Store numbers for faster-than-linear search
   -> Binary Search Tree (BST)
   Reason: BST keeps left < node < right, so we can eliminate half the tree
   at every step, giving O(log n) search instead of O(n).

3. Store dictionary words and check if a prefix exists
   -> Trie (prefix tree)
   Reason: Trie stores strings character by character, so checking a prefix
   just means walking down the tree for each character - O(L) where L is
   the prefix length, regardless of how many words are in the dictionary.

4. Repeatedly retrieve the smallest task priority
   -> Min Heap (Priority Queue)
   Reason: Min Heap always keeps the smallest element at the root, so
   extracting the minimum is O(log n). Using BST would work but Heap is
   simpler and more efficient for this specific use case.

5. Answer many range-sum queries on an array with updates
   -> Segment Tree or Fenwick Tree
   Reason: Both support O(log n) range queries and O(log n) point updates.
   A plain array would need O(n) per query. Fenwick Tree is easier to code
   for simple sum queries.

6. Store database index keys efficiently on disk
   -> B-Tree
   Reason: B-Tree is designed for disk-based storage. It is a multi-way
   balanced tree, so each node can hold many keys and reduce the number of
   disk reads. This is why most databases use B-Trees for indexing.

7. Print BST values in sorted order
   -> BST with inorder traversal
   Reason: Inorder traversal (Left -> Root -> Right) of a BST always visits
   nodes in ascending order by the BST property.

8. Keep a search tree balanced after many insertions
   -> AVL Tree or Red-Black Tree
   Reason: Both are self-balancing BSTs. AVL Tree is stricter (balance
   factor must be -1, 0, or 1), while Red-Black Tree is used in Java's
   TreeMap and TreeSet because it has fewer rotations on average.

9. Build an autocomplete feature for a search box
   -> Trie
   Reason: After typing a prefix, we move to the corresponding Trie node
   and then collect all complete words in the subtree below it using DFS.
   This is much faster than scanning every word in a list.

10. Find the kth largest element in an array
    -> Max Heap (or sort the array)
    Reason: We can build a Max Heap and extract the max k times, each
    extraction is O(log n), so total is O(k log n). Alternatively we can
    use a min-heap of size k to keep track of top k elements.

---------------------------------------------------
Task A2: What Is Stored? (I chose problems 1, 3, 4, 7, 9)
---------------------------------------------------

Problem 1: Print all values level by level
- Data structure: Binary Tree + Queue for BFS
- Each node stores: an integer value, a left child reference, a right
  child reference
- Nodes are connected: parent points to left child and right child
- Efficient operation needed: level-order traversal
- Why suitable: the tree structure naturally groups nodes by depth (level).
  Using a queue for BFS, we process all nodes at depth d before moving to
  depth d+1. This matches exactly what "level by level" means.

Problem 3: Store dictionary words and check if a prefix exists
- Data structure: Trie (prefix tree)
- Each node stores: an array of 26 child references (one per letter a-z)
  and a boolean isEndOfWord flag
- Nodes are connected: parent node's child[i] points to the node for
  character 'a' + i
- Efficient operation needed: prefix lookup and word search
- Why suitable: every path from root to a marked node represents a complete
  word. Checking a prefix takes O(L) time where L is the prefix length,
  completely independent of how many words are stored.

Problem 4: Repeatedly retrieve the smallest task priority
- Data structure: Min Heap (array-based)
- Each node stores: a priority value (integer)
- Nodes are connected: stored in an array where for node at index i,
  left child is at 2i+1, right child is at 2i+2, parent is at (i-1)/2
- Efficient operation needed: extractMin in O(log n)
- Why suitable: Min Heap guarantees the minimum is always at index 0.
  After each extraction, heapifyDown restores the heap property in O(log n).
  This is better than scanning the full array each time (O(n)).

Problem 7: Print BST values in sorted order
- Data structure: Binary Search Tree
- Each node stores: an integer value, left child reference, right child
  reference
- Nodes are connected: left child < current node < right child (BST
  property)
- Efficient operation needed: inorder traversal
- Why suitable: BST stores values in sorted order by structure. Inorder
  traversal (Left -> Root -> Right) visits nodes in ascending order
  because all left-subtree values are smaller and all right-subtree values
  are larger.

Problem 9: Autocomplete feature
- Data structure: Trie
- Each node stores: array of 26 children, isEndOfWord boolean
- Nodes are connected: each edge represents one character
- Efficient operation needed: find all words starting with a given prefix
- Why suitable: we first move to the Trie node for the last character of
  the prefix, then DFS from that node to collect all complete words below.
  This avoids scanning words that do not match the prefix at all.

---------------------------------------------------
Task A3: Traversal Recognition
---------------------------------------------------

Given tree:
        8
       / \
      3   10
     / \    \
    1   6    14
       / \  /
      4   7 13

1. Preorder (Root -> Left -> Right):
   8 3 1 6 4 7 10 14 13

2. Inorder (Left -> Root -> Right):
   1 3 4 6 7 8 10 13 14

3. Postorder (Left -> Right -> Root):
   1 4 7 6 3 13 14 10 8

4. Level-order (BFS):
   Level 0: 8
   Level 1: 3 10
   Level 2: 1 6 14
   Level 3: 4 7 13
   Output: 8 3 10 1 6 14 4 7 13

Answers to the extra questions:
- Inorder gives sorted order for a BST. Because BST property guarantees
  Left subtree < Root < Right subtree, visiting in Left -> Root -> Right
  order always produces values in ascending order.

- Level-order is most suitable for level-by-level printing. It uses a queue
  and processes all nodes at depth d before moving to depth d+1.

- Postorder is useful for deleting nodes from bottom to top. Since postorder
  visits Left -> Right -> Root, children are always processed before their
  parent. This means we can safely delete a node after its subtrees are
  already gone.


================================================================
  PART B - REQUIRED EXERCISES (see individual .java files)
================================================================

Exercise B1: BinaryTreeTraversal.java
  Approach: recursive DFS for pre/in/post order, iterative BFS with
  a Queue for level-order.

Exercise B2: BinarySearchTree.java
  Approach: recursive insert and search using BST property.
  Duplicates are ignored (not inserted again).

Exercise B3: ValidateBST.java
  Approach: pass valid (min, max) bounds down the recursion.
  Moving left tightens the upper bound; moving right tightens the lower
  bound. This catches violations that a simple parent-child check misses.

Exercise B4: MinHeap.java
  Approach: ArrayList-based heap. Insert at the end then heapifyUp.
  Extract root, move last element to root, then heapifyDown.

Exercise B5: Trie.java
  Approach: TrieNode with children[26] array. Insert character by character.
  search() requires isEndOfWord=true at the final character.
  startsWith() only needs to reach the final character node.


================================================================
  PART D - REFLECTION AND EXPLANATION
================================================================

---------------------------------------------------
Task D1: Concept Reflection
---------------------------------------------------

1. What is the difference between a linear data structure and a tree?
   A linear data structure (like array, linked list, stack, queue) stores
   elements in a single sequence where each element has at most one
   predecessor and one successor. A tree organizes data hierarchically:
   each node can have multiple children, but only one parent. Trees model
   relationships and hierarchies that a flat sequence cannot represent
   naturally (for example, file systems, family trees, organizational charts).

2. What is the difference between a Binary Tree and a Binary Search Tree?
   A Binary Tree is just a tree where each node has at most two children
   (left and right). There is no rule about ordering. A BST is a Binary
   Tree with an additional constraint: for every node, all values in its
   left subtree are smaller, and all values in its right subtree are larger.
   This ordering property is what makes searching efficient.

3. Why does BST performance depend on height?
   During search or insert, we start at the root and follow one path down
   to a leaf (go left or right at each node). The length of that path is
   at most the height of the tree. So if the height is h, operations take
   O(h). For a balanced tree h = O(log n), but for a skewed tree h = O(n).

4. What happens when a BST becomes unbalanced?
   If we insert values in sorted order (e.g., 1, 2, 3, 4, 5), every new
   node goes to the right of the previous one. The tree becomes a straight
   chain (like a linked list). The height becomes n, so search, insert,
   and delete all degrade from O(log n) to O(n). This is why we need
   balanced trees like AVL or Red-Black Tree for guaranteed performance.

5. Why does inorder traversal of a BST produce sorted values?
   The BST property says: left subtree values < node value < right subtree
   values. Inorder traversal visits in the order Left -> Root -> Right.
   So we always process all smaller values before the current node, and all
   larger values after. This naturally produces ascending sorted order.

6. How is Heap different from BST?
   Both are binary trees, but they have different ordering rules. BST has a
   global ordering: every node in the left subtree is smaller, every node
   in the right subtree is larger. Heap only has a local property: parent
   >= all children (max heap) or parent <= all children (min heap). Because
   of this, BST supports general search efficiently but Heap does not (you
   cannot search for an arbitrary value quickly in a Heap). On the other
   hand, Heap is better at repeatedly finding the min or max since it is
   always at the root.

7. How is Heap related to Priority Queue?
   Priority Queue is an abstract data type that supports insert and
   extractMin (or extractMax) efficiently. Heap is the most common way to
   implement it. A Min Heap keeps the smallest element at the root, so
   extractMin is O(log n) and insert is O(log n). Java's PriorityQueue
   class is backed by a Min Heap internally.

8. Why is Trie useful for prefix search?
   In a Trie, every path from root to a node represents a prefix of some
   stored word. To check if any word starts with a given prefix, we just
   follow the path for each character of the prefix. If we reach the end
   without hitting a null child, the prefix exists. This takes O(L) time
   where L is the prefix length, regardless of how many words are stored.
   Comparing this to a HashSet of words, a HashSet cannot efficiently answer
   "does any word start with 'ca'?" without scanning every word.

9. What type of problem is Segment Tree designed for?
   Segment Tree is designed for range queries on an array that can also be
   updated. For example: "what is the sum of elements from index l to r?"
   or "what is the minimum value in a range?" With a Segment Tree, both
   range queries and point updates take O(log n). Without it, a range query
   on a plain array is O(n), and using a prefix sum array makes updates O(n).

10. Which required exercise was the hardest, and why?
    I found B4 (Min Heap) the hardest. The main difficulty was the
    heapifyDown operation after extractMin. After moving the last element to
    the root, I had to carefully compare with both children and swap with the
    smaller one (not just any child), and repeat until the heap property is
    restored. It took me a few tries to get the index calculations and the
    stopping condition right. Understanding why the parent index is (i-1)/2
    and why we always swap with the smaller child (not just any child that is
    smaller than the parent) was also a bit confusing at first.

---------------------------------------------------
Task D2: Explain Without Code (Exercise B3 - Validate BST)
---------------------------------------------------

Selected exercise: B3 - Validate a Binary Search Tree

Tree structure used:
  Binary Tree (with BST validation using bounds)

What each node stores:
  Each node stores an integer value and references to its left and right
  children. During validation, we also pass down a valid range [min, max]
  for each node - but this range is not stored in the node itself, it is
  just a parameter in the recursive call.

How nodes are connected:
  Each node points to at most two children: a left child (which should have
  a smaller value) and a right child (which should have a larger value).

Why simple parent-child check is not enough:
  Just checking that node.left.value < node.value < node.right.value for
  every node is not sufficient. For example, consider:
      10
     /  \
    5   15
       /  \
      6   20
  The node 6 is the left child of 15, and 6 < 15 so that looks fine locally.
  But 6 is also in the right subtree of 10, which means it must be greater
  than 10. Since 6 < 10, this is actually an invalid BST. A local check
  would miss this.

The idea - using valid range bounds:
  We pass a valid range (min, max) to each node. A node is valid only if
  its value is strictly between min and max. When we go left (to a smaller
  subtree), the current node's value becomes the new upper bound - because
  all values in the left subtree must be less than the current node. When
  we go right, the current node's value becomes the new lower bound - because
  all values in the right subtree must be greater than the current node.
  We start with min = -infinity and max = +infinity for the root.

When recursion is used:
  We use recursion because we need to validate every node in the tree, and
  each node's valid range depends on where it is in the tree. Recursion
  naturally carries the bounds down through each level.

Why this structure is suitable:
  By propagating min and max bounds, we enforce the global BST property
  (not just the local parent-child relationship) at every node. This is
  exactly what BST validation requires.

Time and space complexity:
  Time complexity is O(n) because we visit every node exactly once.
  Space complexity is O(h) for the recursion stack, where h is the height
  of the tree. In the worst case (skewed tree), this is O(n).


================================================================
  FURTHER PRACTICE SELECTIONS (Part C)
================================================================

  C1: Maximum Depth of a Binary Tree -> FurtherPractice1.java
  C2: Lowest Common Ancestor in BST  -> FurtherPractice2.java
  C3: Kth Smallest Element in BST    -> FurtherPractice3.java

================================================================
