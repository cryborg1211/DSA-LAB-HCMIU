// Student: Cao Bao Khuong - ITDSIU22176
// Lab 5 - Exercise B4: Simple Hash Table using Separate Chaining
// Manual implementation - String key -> int value

import java.util.LinkedList;

public class ExerciseB4_SimpleHashTable {

    // each "bucket" is a linked list of (key, value) pairs
    // when two keys hash to the same index, they are chained in the same list
    static class SimpleHashTable {

        private static final int SIZE = 16;

        // inner class to hold a key-value pair
        static class Entry {
            String key;
            int value;

            Entry(String key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Entry>[] table;

        @SuppressWarnings("unchecked")
        public SimpleHashTable() {
            table = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                table[i] = new LinkedList<>();
            }
        }

        // hash function: multiply by 31 and take modulo
        // 31 is a common prime used for string hashing
        private int hash(String key) {
            int h = 0;
            for (int i = 0; i < key.length(); i++) {
                h = h * 31 + key.charAt(i);
            }
            return Math.abs(h) % SIZE;
        }

        public void put(String key, int value) {
            int idx = hash(key);
            // check if key already exists -> update it
            for (Entry e : table[idx]) {
                if (e.key.equals(key)) {
                    e.value = value;
                    return;
                }
            }
            // key not found -> add new entry
            table[idx].add(new Entry(key, value));
        }

        public int get(String key) {
            int idx = hash(key);
            for (Entry e : table[idx]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
            return -1; // not found
        }

        public void remove(String key) {
            int idx = hash(key);
            table[idx].removeIf(e -> e.key.equals(key));
        }

        public boolean containsKey(String key) {
            int idx = hash(key);
            for (Entry e : table[idx]) {
                if (e.key.equals(key)) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SimpleHashTable ht = new SimpleHashTable();

        // --- required example from lab ---
        ht.put("Alice", 90);
        ht.put("Bob", 85);
        ht.put("Alice", 95);   // update Alice's value
        System.out.println("get(Alice) -> " + ht.get("Alice"));            // 95
        System.out.println("containsKey(Bob) -> " + ht.containsKey("Bob")); // true
        ht.remove("Bob");
        System.out.println("containsKey(Bob) -> " + ht.containsKey("Bob")); // false

        System.out.println();

        // --- edge case: key doesn't exist ---
        System.out.println("get(Charlie) -> " + ht.get("Charlie")); // -1
        ht.remove("Charlie"); // should not crash

        System.out.println();

        // --- collision test: more keys than SIZE forces collisions ---
        System.out.println("Collision test (20 keys, SIZE=16):");
        SimpleHashTable ht2 = new SimpleHashTable();
        for (int i = 0; i < 20; i++) {
            ht2.put("Student" + i, i * 5);
        }
        boolean ok = true;
        for (int i = 0; i < 20; i++) {
            if (ht2.get("Student" + i) != i * 5) {
                System.out.println("WRONG at Student" + i);
                ok = false;
            }
        }
        System.out.println("All values correct: " + ok);
    }
}
