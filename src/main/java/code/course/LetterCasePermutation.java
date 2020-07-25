package code.course;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class LetterCasePermutation {

    static List<String> result = new ArrayList<>();

    public static void helper(String s, int startIndex, String current) {
        if (startIndex >= s.length()) {
            result.add(current);
            return;
        }
        Character c = s.charAt(startIndex);
        if (Character.isLetter(c)) {
            String option1 = current + Character.toLowerCase(c);
            String option2 = current + Character.toUpperCase(c);
            helper(s, startIndex + 1, option1);
            helper(s, startIndex + 1, option2);
        } else {
            helper(s, startIndex + 1, current + c);
        }
    }

    public static List<String> letterCasePermutation(String S) {
        helper(S, 0, "");
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a12bc34"));
    }
}
