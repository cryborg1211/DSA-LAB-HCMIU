// Student: Cao Bao Khuong - ITDSIU22176
// Lab 5 - Exercise B1: Valid Parentheses
// Data structure used: Stack

import java.util.Stack;

public class ExerciseB1_ValidParentheses {

    // idea: use a stack to keep track of opening brackets
    // when we see a closing bracket, check if it matches the top
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // closing bracket - stack must not be empty
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        // if stack still has elements, some brackets were never closed
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // test 1: normal valid case
        System.out.println("Test 1: " + isValid("{[()]}"));   // true

        // test 2: wrong order
        System.out.println("Test 2: " + isValid("{[(])}"));   // false

        // test 3: edge case - empty string
        System.out.println("Test 3: " + isValid(""));         // true

        // test 4: edge case - only closing bracket
        System.out.println("Test 4: " + isValid("]"));        // false

        // test 5: unclosed bracket
        System.out.println("Test 5: " + isValid("(("));       // false

        // test 6: multiple types all valid
        System.out.println("Test 6: " + isValid("()[]{}"));   // true
    }
}
