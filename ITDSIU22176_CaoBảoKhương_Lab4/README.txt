Name: Cao Bảo Khương
ID: ITDSIU22176
Lab 4: Prefix Sum and Hashing

### Completed Tasks:
- Part A: Guided Practice (Pattern Identification, Storage Analysis, Complexity Comparison)
- Part B: Classical Exercises (B1-B6 implemented in Java)
- Part C: Intermediate Exercises (C1: Longest Subarray Equal 01, C2: Subarray Divisible by k)
- Part D: Reflection and Plain English Explanation

### Project Structure:
- src/PartB/: Contains classes for required exercises.
- src/PartC/: Contains classes for selected intermediate exercises.
- src/Runner.java: Main class to run all tests.
- Report.md: Full report with logic explanations and complexity analysis.
- ReasoningLog.txt: Documentation of implementation decisions.

### How to Run:
1. Open a terminal in the 'src' directory.
2. Compile all files:
   javac PartB/*.java PartC/*.java Runner.java
3. Run the test suite:
   java Runner

### Assumptions and Limitations:
- The input arrays are assumed to fit in memory.
- Prefix sums use 'long' to prevent integer overflow for large arrays.
- For B6 (Pivot Index), if multiple indices exist, the first one encountered is returned.
