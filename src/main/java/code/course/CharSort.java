package code.course;

import java.util.Stack;

@SuppressWarnings("unused")
public class CharSort {

    public static void main1(String[] args) {
        String str = "BBBRBRRRB";
        char[] chs = str.toCharArray();

        Stack<Character> stack = new Stack();
        int k  = 3;
        for(int i =0; i < chs.length; i++){
            if(chs[i] != 'R' && chs[i] != 'B'){
                continue;
            }

            if(!stack.isEmpty()){
                char temp = chs[i];
                int cnt  = 0;
                while(!stack.isEmpty() && temp == stack.peek()){
                    stack.pop();
                    cnt++;
                    if(cnt > k){
                        System.out.println("failed");
                    }
                }
                stack.push('X');
            }else{
                stack.push(chs[i]);
            }
        }

    }

    public static void main(String[] args) {

    }

    public static void main2(String[] args) {
        String str = "BBBRBRRRB";

        char[] chs = str.toCharArray();
        Character prev = null;
        int occurrence = 1;
        int limit = 2;

        for (int i=1;i<chs.length; i++) {
            if(chs[i-1] == chs[i]){
                occurrence++;
                if(occurrence > limit) {
                    System.out.println("failed");
                }
            }else{
                occurrence = 0;
            }
        }

    }
}
