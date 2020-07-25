import java.util.Arrays;

public class MinWIndowChar {
    public static void main(String[] args) {
        //Input: S = "ADOBECODEBANC", T = "ABC"

        String s = "ABCDE";

        int end = s.length()-1;
        char [] chs = s.toCharArray();
        int start = 0;

        while (start < end){
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(chs));

    }
}
