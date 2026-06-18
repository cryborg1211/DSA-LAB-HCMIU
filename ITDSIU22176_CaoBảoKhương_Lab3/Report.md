# Lab Report: Two Pointers and Sliding Window
**Student:** Cao Bao Khuong  
**ID:** ITDSIU22176  

---

## Part B: Classical Exercises

### B1: Two Sum II (Sorted Array)
- **Pattern:** Two Pointers (Opposite Direction).
- **Invariant:** The target pair always lies within the range defined by `left` and `right`.
- **Brute Force:** Nested loops to check every pair $O(n^2)$.
- **Optimized:** One pass $O(n)$ by moving pointers inward based on the current sum relative to the target.
- **Space:** $O(1)$.

### B2: Remove Duplicates from Sorted Array
- **Pattern:** Two Pointers (Read/Write).
- **Invariant:** All elements before the `write` pointer are unique and sorted.
- **Brute Force:** Copying to a new array or shifting elements repeatedly $O(n^2)$.
- **Optimized:** In-place update $O(n)$ using one pointer to scan and another to overwrite unique elements.
- **Space:** $O(1)$.

### B3: Move Zeroes
- **Pattern:** Two Pointers (Same Direction).
- **Invariant:** All non-zero elements encountered so far are shifted to the front in order.
- **Brute Force:** Counting zeroes and rebuilding the array O(n).
- **Optimized:** Swapping non-zero elements to the `lastNonZeroAt` pointer O(n) in-place.
- **Space:** $O(1)$.

### B4: Maximum Sum Subarray of Size k
- **Pattern:** Fixed-size Sliding Window.
- **Invariant:** The window always contains $k$ contiguous elements.
- **Brute Force:** Recomputing the sum for every possible starting index $O(n \cdot k)$.
- **Optimized:** Sliding the window $O(n)$ by adding the next element and subtracting the one that left.
- **Space:** $O(1)$.

### B5: Minimum Size Subarray Sum
- **Pattern:** Variable-size Sliding Window.
- **Invariant:** The window [left, right] maintains a sum $\ge S$.
- **Brute Force:** Checking every possible subarray O(n^2).
- **Optimized:** Expanding `right` to meet sum $S$ and shrinking `left` to find minimum size O(n).
- **Space:** $O(1)$.

### B6: Longest Substring Without Repeating Characters
- **Pattern:** Variable-size Sliding Window.
- **Invariant:** The window only contains unique characters.
- **Brute Force:** Checking all substrings $O(n^3)$ or $O(n^2)$.
- **Optimized:** Sliding window with a Hash Set $O(n)$ to track character presence.
- **Space:** $O(min(n, m))$ where $m$ is the character set size.

---

## Part D2: Explain Without Code (Exercise B1)

**Exercise B1: Two Sum II**
Imagine walking on a sorted path from both ends. We start with one pointer at the very beginning (smallest value) and another at the very end (largest value). We calculate the sum of these two numbers. 

If the sum matches our target, we've found our pair. If the sum is too small, we know that moving the right pointer inward would only make it smaller, so we must move the left pointer forward to get a larger sum. Conversely, if the sum is too large, we move the right pointer backward to decrease it. This method ensures we explore all relevant pairs in a single trip across the data, making it very efficient.

---

### Card 25: Longest Substring with at most k Distinct Characters
- **Pattern:** Variable-size Sliding Window.
- **Invariant:** The window [left, right] contains at most $k$ distinct characters.
- **Brute Force:** Checking all substrings and counting distinct characters $O(n^3)$.
- **Optimized:** Sliding window with a frequency map $O(n \cdot |\Sigma|)$ where $|\Sigma|$ is the alphabet size (256).
- **Space:** $O(1)$ (fixed size frequency array).

---

