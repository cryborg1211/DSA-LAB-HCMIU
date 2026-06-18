package Sorting;

public class SortInstrumentation {
    public long comparisons = 0;
    public long swapsMoves = 0;
    public int currentDepth = 0;
    public int maxDepth = 0;

    public void reset() {
        comparisons = 0;
        swapsMoves = 0;
        currentDepth = 0;
        maxDepth = 0;
    }

    public void recordComparison() {
        comparisons++;
    }

    public void recordSwapMove() {
        swapsMoves++;
    }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        currentDepth--;
    }

    public void printStats(String algoName) {
        System.out.println("--- " + algoName + " Statistics ---");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps/Moves: " + swapsMoves);
        System.out.println("Max Recursion Depth: " + maxDepth);
        System.out.println("--------------------------------");
    }
}
