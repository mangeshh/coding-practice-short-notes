import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class CasePermutation {

    Map map = new HashMap();
    /**
     * we can do it better to keep the cache.
     * Letter Case Permutation
     */
    static String[] strs = new String[]{"000", "001", "010", "011", "100", "101", "110", "111"};


    static void bin(Integer n)
    {
        if (n > 1)
            bin(n>>1);
        System.out.printf("%d", n & 1);
    }


    public static boolean isCharacter(Character s) {
        if (Character.isAlphabetic(s)) {
            return true;
        }
        return false;
    }

    public static void permute(String s) {

        for (int i = 0; i < strs.length; i++) {
            char[] cacheStringPossibilities = strs[i].toCharArray();
            int k = 0;
            String newStr = "";
            for (int j = 0; j < s.length(); j++) {
                Character letterFromString = s.charAt(j);
                if (isCharacter(letterFromString)) {
                    char cacheString = cacheStringPossibilities[k++];
                    char tempChar = cacheString == '1' ? Character.toUpperCase(letterFromString) : letterFromString;
                    newStr = newStr + tempChar;
                    continue;
                }
                newStr = newStr + letterFromString;
            }

            System.out.println(newStr);
        }

    }

    public static void main(String[] args) {
        //permute("abc12");
        bin(2);
    }
}
