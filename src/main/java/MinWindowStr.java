import java.util.*;

@SuppressWarnings("unused")
public class MinWindowStr {

    public static boolean matchedAll(Map<Character, Integer> counter, String string, int start, int end) {
        if (string.length() < counter.size()) return false;
        Set<Character> set = new HashSet();

        for (int i = start; i <= end; i++) {
            set.add(string.charAt(i));
        }

        for (Character c : counter.keySet()) {
            if (!set.contains(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String str = "AXYZPQRBCDA";
        System.out.println("total length is " + str.length());
        String pattern = "ABC";
        System.out.println("Original string is " + str);
        Map<Character, Integer> counter = new LinkedHashMap<>();

        char[] chs = str.toCharArray();
        int windowStart = 0;
        int windowEnd = 0;
        int minLength = str.length();

        for (int p = 0; p < pattern.length(); p++) {
            char pChar = pattern.charAt(p);
            if (!counter.containsKey(pattern.charAt(p))) {
                counter.put(pChar, 1);
            } else {
                counter.put(pChar, counter.get(pChar));
            }
        }

        while (windowStart < str.length() && windowEnd < str.length()) {
            // Step - 1 : find all patterns inside the string.

            for (int strCounter = windowEnd; strCounter < str.length(); strCounter++) {
                char charStr = str.charAt(strCounter);
                if (matchedAll(counter, str, windowStart, strCounter)) {
                    int currentLength = strCounter - windowStart + 1;
                    minLength = Math.min(minLength, currentLength);
                    System.out.println(str.substring(windowStart, strCounter + 1) + "[" + currentLength + "]");
                    windowEnd = strCounter;
                    break;
                }
            }

            // Step - 2 : increased the window's other end.
            char charWinStart = str.charAt(windowStart);

            while (windowEnd < str.length() && str.charAt(windowEnd) != charWinStart) {
                windowEnd++;
            }

            // Step - 3 : now shrink the window.
            if (counter.containsKey(charWinStart)) {
                counter.put(charWinStart, counter.get(charWinStart) - 1);
            }
            if (counter.containsKey(charWinStart) && counter.get(charWinStart) == 0) {
                counter.remove(charWinStart);
            }

            while (windowStart < str.length() && !counter.containsKey(str.charAt(windowStart))) {
                windowStart++;
            }

            if (counter.get(charWinStart) == null) {
                counter.put(charWinStart, 1);
            }

        }

        System.out.println("minimum window length is " + minLength);
    }
}
