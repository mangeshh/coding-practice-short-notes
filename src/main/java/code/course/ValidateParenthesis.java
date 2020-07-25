package code.course;

import java.util.Stack;

@SuppressWarnings("unused")
public class ValidateParenthesis {

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 1) return 0;
        Stack<Pair> stack = new Stack<>();
        int length = 0;
        Pair temp;
        int tempL = s.length();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Pair p = new Pair(i, c);

            if (!stack.isEmpty()) {
                temp = stack.peek();
                if (temp != null && temp.c == '(' && p.c == ')') {
                    stack.pop();
                    continue;
                }
            }
            stack.add(p);
        }

        if (stack.isEmpty()) {
            length = tempL;
        } else {
            while (!stack.isEmpty()) {
                int t = stack.pop().i;
                length = Math.max(length, tempL - t - 1);
                tempL = t;
            }
            if (tempL > 0) {
                length = Math.max(length, tempL - 0);
            }
        }

        return length;
    }

    static class Pair {
        int i;
        char c;

        Pair(int i, char c) {
            this.i = i;
            this.c = c;
        }

    }

    public static void main(String[] args) {
        longestValidParentheses("(((((()");
        longestValidParentheses("(())");
        longestValidParentheses("())");
        longestValidParentheses(")()())");
    }
}