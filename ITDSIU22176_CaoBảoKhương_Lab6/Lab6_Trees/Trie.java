public class Trie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEndOfWord = true;
    }

    // Returns true only if the full word was inserted
    boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) return false;
            current = current.children[idx];
        }
        return current.isEndOfWord;
    }

    // Returns true if any inserted word starts with this prefix
    boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (current.children[idx] == null) return false;
            current = current.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Sample from the lab
        System.out.println("=== Test Case 1: Sample from lab ===");
        Trie trie1 = new Trie();
        trie1.insert("cat");
        trie1.insert("car");
        trie1.insert("care");
        System.out.println("search(\"car\"):      " + trie1.search("car"));       // true
        System.out.println("search(\"cap\"):      " + trie1.search("cap"));       // false
        System.out.println("startsWith(\"ca\"):   " + trie1.startsWith("ca"));    // true
        System.out.println("startsWith(\"dog\"): " + trie1.startsWith("dog"));   // false

        System.out.println();

        // Test Case 2: Prefix that is also a complete word
        System.out.println("=== Test Case 2: Prefix vs Full Word ===");
        Trie trie2 = new Trie();
        trie2.insert("car");
        trie2.insert("care");
        System.out.println("search(\"car\"):    " + trie2.search("car"));     // true
        System.out.println("search(\"care\"):   " + trie2.search("care"));    // true
        System.out.println("search(\"ca\"):     " + trie2.search("ca"));      // false - prefix only, not a word
        System.out.println("startsWith(\"ca\"): " + trie2.startsWith("ca"));  // true

        System.out.println();

        // Test Case 3: Short words, single character
        System.out.println("=== Test Case 3: Short Words ===");
        Trie trie3 = new Trie();
        trie3.insert("a");
        trie3.insert("ab");
        System.out.println("search(\"a\"):    " + trie3.search("a"));         // true
        System.out.println("search(\"ab\"):   " + trie3.search("ab"));        // true
        System.out.println("search(\"abc\"):  " + trie3.search("abc"));       // false
        System.out.println("startsWith(\"a\"): " + trie3.startsWith("a"));   // true

        System.out.println();

        // Test Case 4: Words with no shared prefix
        System.out.println("=== Test Case 4: No Shared Prefix ===");
        Trie trie4 = new Trie();
        trie4.insert("dog");
        trie4.insert("cat");
        System.out.println("search(\"dog\"):     " + trie4.search("dog"));      // true
        System.out.println("search(\"cat\"):     " + trie4.search("cat"));      // true
        System.out.println("startsWith(\"ca\"):  " + trie4.startsWith("ca"));   // true
        System.out.println("startsWith(\"co\"):  " + trie4.startsWith("co"));   // false
    }
}
