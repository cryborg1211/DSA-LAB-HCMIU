// Student: Cao Bao Khuong - ITDSIU22176
// Lab 5 - Exercise C1: Remove Adjacent Duplicates
// Data structure: Stack

import java.util.Stack;

public class ExerciseC1_RemoveAdjacentDuplicates {

    // repeatedly remove pairs of adjacent same characters
    // stack approach: if top of stack equals current char -> pop (cancel them)
    //                 otherwise -> push current char
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // cancel the pair
            } else {
                stack.push(c);
            }
        }

        // build result from what's left in stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // test 1: from the lab - abbaca -> aaca -> ca
        System.out.println("Test 1: " + removeDuplicates("abbaca"));  // ca

        // test 2: all pairs collapse
        System.out.println("Test 2: " + removeDuplicates("aabbcc"));  // (empty)

        // test 3: no adjacent duplicates
        System.out.println("Test 3: " + removeDuplicates("abc"));     // abc

        // test 4: edge - single char
        System.out.println("Test 4: " + removeDuplicates("a"));       // a

        // test 5: edge - all same char (even length)
        System.out.println("Test 5: " + removeDuplicates("aaaa"));    // (empty)

        // test 6: chain collapse like abccba
        System.out.println("Test 6: " + removeDuplicates("abccba"));  // (empty)
    }
}
