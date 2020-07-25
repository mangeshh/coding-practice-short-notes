import java.util.HashMap;
import java.util.Map;

//leetcode 1160
@SuppressWarnings("unused")
public class FindWord {

    public static void main(String[] args) {
        String [] strs = new String[]{"cat","bt","hat","tree"};
        String [] strs2 = new String[]{"hello","world","leetcode"};
        String chars = "atach";
        String chars2 = "welldonehoneyr";
        int total = countCharacters(strs, chars);
        System.out.println(total);
    }

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (map.get(c) != null) {
                int temp = map.get(chars.charAt(i));
                map.put(c, temp + 1);
            } else {
                map.put(c, 1);
            }
        }
        int total = 0;
        for (String str : words) {
            Map<Character, Integer> tempMap = new HashMap();
            char[] chs = str.toCharArray();
            for (char c : chs) {
                if (tempMap.get(c) != null) {
                    int temp = tempMap.get(c);
                    tempMap.put(c, temp + 1);
                } else {
                    tempMap.put(c, 1);
                }
            }
            boolean isAvailable = true;
            for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
                Character key = entry.getKey();
                if (key != null && !map.containsKey(key) || tempMap.get(key) > map.get(key)) {
                    isAvailable = false;
                }
            }

            if(isAvailable){
                System.out.println("adding string " + str);
                total = total+ str.length();
            }
        }

        return total;

    }
}
