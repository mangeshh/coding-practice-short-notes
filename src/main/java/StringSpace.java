import java.util.Arrays;

public class StringSpace {

    public static void swap(char[] chs, int from, int to) {
        if (from == to) return;
        char c = chs[from];
        chs[from] = chs[to];
        chs[to] = c;
    }

    public static void main(String[] args) {
        String s = "abc def gh";
        char[] chs = s.toCharArray();
        int i =0;
        int j = 0;
        for (int k = 0; k < chs.length; k++) {
            if (chs[k] == ' ') {
                j++;
                continue;
            }
            swap(chs, j, i);
            i++;
            j++;
        }
        System.out.println("value of i " + i);
        System.out.println(Arrays.toString(chs));
    }
}
