package code.course.extra;

public class Solution {

    public static int isPalindrome(String A) {
        int l = 0;
        int r = A.length()-1;

        while(l<r){
            char lc = Character.toLowerCase(A.charAt(l));
            char rc = Character.toLowerCase(A.charAt(r));

            if(lc == ':' || lc == ' ' || lc == '=' || lc == '#'){
                l++;
                continue;
            }

            if(rc == ':' || rc == ' ' || rc == '=' || rc == '#'){
                r--;
                continue;
            }

            if(lc == rc){
                l++;
                r--;
            } else{
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        //System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("1a2"));
    }
}
