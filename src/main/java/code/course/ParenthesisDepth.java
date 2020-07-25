package code.course;

import java.util.Stack;

public class ParenthesisDepth {

    public static void main(String[] args) {
        String s = "(()()()()((())))";
        // (()(()))
        int max = Integer.MIN_VALUE;
        char [] chs = s.toCharArray();
        Stack<Character> stack = new Stack();

        for (int i=0; i < chs.length; i++){

            if(stack.isEmpty()){
                stack.push(chs[i]);
            } else{
                char c = stack.peek();
                if(c == '(' && chs[i] == ')'){
                    stack.pop();
                    max = Math.max(max, stack.size()+1);
                }else{
                    stack.push(chs[i]);
                }
            }

        }

        System.out.println(max);

    }
}
