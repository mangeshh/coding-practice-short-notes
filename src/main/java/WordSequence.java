import java.util.HashMap;
import java.util.Map;

public class WordSequence {

    public static boolean matchString(String str1, String str2) {
        for (int j = 0; j < Math.min(str1.length(), str2.length()); j++) {
            if (str1.charAt(j) != str2.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap(order.length());
        char[] chs = order.toCharArray();

        for (int i = 0; i < chs.length; i++) map.put(chs[i], i);


        for (int x = 1; x < words.length; x++) {
            char[] c0 = words[x - 1].toCharArray();
            char[] c1 = words[x].toCharArray();

            if (c0.length > c1.length && matchString(words[x-1], words[x])) {
                return false;
            }

            int limit = Math.min(c0.length, c1.length);
            for (int j = 1; j < limit; j++) {
                if (map.get(c1[j]) < map.get(c0[j - 1])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean a = isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz");
        System.out.println(a);
    }
}