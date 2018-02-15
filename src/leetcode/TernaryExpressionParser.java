package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//Input: "T?T?F:5:3"
//
//Output: "F"
//
//Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
//
//             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
//          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
//          -> "F"                                    -> "F"

public class TernaryExpressionParser  {
    public String parseTernary(String expression) {
    if (expression == null || expression.length() == 0) return "";
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {

                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();

                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }
}
