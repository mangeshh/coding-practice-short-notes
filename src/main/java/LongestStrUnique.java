import java.util.HashMap;
import java.util.Map;


public class LongestStrUnique {

    static Map map = new HashMap();

    public static void main(String[] args) {
        String str = "whatwhywhere";

        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length - 1; i++) {
            map = new HashMap();
            map.put(chs[i], i);
            for (int j = i + 1; j < chs.length; j++) {
                if (map.get(chs[j]) != null) {
                    map.put(chs[j], j);
                    System.out.println("max " + (j-i));
                    break;
                } else {
                    map.put(chs[j], j);
                }
            }
        }
    }
}
