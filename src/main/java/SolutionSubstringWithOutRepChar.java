import java.util.HashMap;
import java.util.Map;


public class SolutionSubstringWithOutRepChar {

    public static int lengthOfLongestSubstring(String s) {

        int start = 0;
        Map<Character, Integer> m = new HashMap<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (m.containsKey(c)) {
                System.out.println(i + ":" + start + ":" + m.get(s.charAt(i)));
                start = Math.max(start, m.get(s.charAt(i)) + 1);
            }

            m.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
}
