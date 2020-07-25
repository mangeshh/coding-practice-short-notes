package code.course;

import java.util.Stack;

public class GoogleInterview1 {
    public static void main(String[] args) {
        String s1 = "abc-def-dhi";
        String s = "a0001afds-";
        Stack stack = new Stack();
        int cnt = 0;

        for(int i = s.length() - 1 ; i >= 0 ; i--){
            char c = s.charAt(i);
            if((c == '-' || c < 'a' && c > 'z')){
                continue;
            }

            if(cnt == 4){
                stack.push('-');
                cnt = 0;
            }
            cnt++;
            stack.push(Character.toUpperCase(c));

        }

        String str = "";
        while (!stack.isEmpty()){
            str = str + stack.pop();
        }

        System.out.println(str);

    }
}
