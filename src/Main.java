//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String testString = "(((("; // the thing about this is, it will push all items onto stack and return stack.empty on
        // final line, but not sure why this defaults to false
        String otherTest = "()[]";
        System.out.println(new Solution().isValid(otherTest));

    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') { // if one of these three, pushes it onto stack
                stack.push(c);
            } else { // the goal here is not to push all items then pop all items, it is only first...
                if (stack.empty()) { // check if any item was pushed, no subsequent character would make the boolean true
                    return false;
                } // here checking to see if a pushed char matches the current char in enhanced loop. if yes, then the
                // only item in the stack is popped off
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                    // the stack should always be emptied after finding its corresponding bracket
                } else {
                    return false;
                }
            }
        }
        return stack.empty(); // this is a boolean. it returns true if stack empty and false if not. It is to a command
        //TO empty. so when i pass a string "((((", all items are pushed and none are popped, so empty = false.
        // if i pass "()[]{}",  ( { and [ get pushed and then popped by their counterpart and return true for empty
    }
}





// MINE. RIGHT IDEA BUT FOR SOME REASON ITS NOT REGESTERING WHEN SOMETHING IS DIFFERENT AND NOT EXECUTING ELSE IF STATEMENTS
//class Solution {
//    public boolean isValid(String s) {
//        boolean isTrue;
//        char[] convertedString = s.toCharArray();
//        for (int i = 0; i < convertedString.length; i +=2) {
//            System.out.println(convertedString[i] + " " + convertedString[i+1]);
//
//            if ((convertedString[i] == '(' ) && (convertedString[i + 1] == ')') ) {
//               isTrue = true;
//            } else if (convertedString[i] == '{' && convertedString[i + 1] == '}') {
//                isTrue = true;
//            } else if (convertedString[i] == '[' && convertedString[i + 1] == ']') {
//                isTrue = true;
//            } else {
//                isTrue = false;
//            }
//        }
//        return isTrue;
//    }
//}