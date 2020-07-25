import java.util.ArrayList;
import java.util.List;

public class SolutionPalimdrom {

    public static boolean isPalindrome(String s) {

        List<Character> list = new ArrayList<>();
        s = s.toLowerCase();

        for(int i =0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            if (!( (ch1 >=97  && ch1 <= 122) || (ch1 >= 48 && ch1 <= 57)) ) {
                continue;

            }
            list.add(ch1);
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            char ch1 = list.get(i);
            char ch2 = list.get(j);

            if (ch1 != ch2) {
                return false;
            }

            i++;
            j--;

        }

        return true;
    }

    public static void main(String[] args) {
        boolean ans = isPalindrome("aba");
        System.out.println(ans);
    }
}
