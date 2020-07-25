package code.course;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class Test1 {
    public static void main(String[] args) {
        String str = "aaaacccccbbbbbbscba";
        System.out.println(str.substring(2, 5));

        Set<Character> set = new HashSet();
        set.add('c');
        set.add('a');
        set.add('b');

        Map<Character, Integer> map = new HashMap<>();
        int startWindow = 0;
        int endWindow = -1;

        char[] chs = str.toCharArray();
        int cnt = 0;
        int total = 0;

        for (int i = 0; i < chs.length; i++) {

            if (set.contains(chs[i])) {
                map.put(chs[i], ++cnt);
                total++;
            }

            if (total == set.size()) {
                endWindow = i;
                System.out.println("start is " + startWindow + " and end is " + endWindow);
            }

        }
    }
}
