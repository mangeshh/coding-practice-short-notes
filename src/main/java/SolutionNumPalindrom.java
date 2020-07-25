/**
 *
 *
 *
 */
class SolutionNumPalindrom {

    public static  boolean isPalindrome(int x) {

       int origin = x;
       int mod ;
       int result = 0;
       // 121
       while (x > 0){
           mod = x % 10; // 1 2 1
           x = x / 10; // 12
           result = (result * 10) + mod; // 10
        }

        System.out.println(result);

        if(origin == result){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(321));
    }
}