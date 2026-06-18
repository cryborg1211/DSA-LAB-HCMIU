DSA Lab 2 - Sorting and Linked Lists
------------------------------------
Student ID: ITDSIU22176
Full Name: Cao Bảo Khương

Project Structure:
- src/Sorting/: Contains MergeSort, QuickSort, HeapSort implementations alongside a SortInstrumentation framework.
- src/LinkedList/: Contains base implementations of Singly, Doubly, and Circular Linked Lists as well as Cycle tools.
- src/Exercises/: Solutions for Exercise 1 through Exercise 9.
- tests/: Contains input test cases description and execution output traces natively generated.
- report/: Contains Lab02_Report.md.

How to Compile and Run:
1. Ensure you have Java JDK installed.
2. From the project root, compile using:
   > javac -d out src/Sorting/*.java src/LinkedList/*.java src/Exercises/*.java
3. Run any specific file/exercise from the output directory "out":
   > java -cp out Exercises.Exercise1
   > java -cp out Exercises.Exercise2
   ... and so on.

Assumptions and Limitations:
- Array sizes for sorting tests heavily favor logic validation over massive scale benchmarking, limiting out-of-memory errors during mock interview testing.
- QuickSort pivot optimally implements Median-of-Three with randomized fallback gracefully implemented.
- Standard input handling assumes arrays initialized at runtime within main() classes for simplicity over building a complex filesystem parser unless specifically parameterized.
