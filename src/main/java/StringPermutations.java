@SuppressWarnings("unused")
public class StringPermutations {


    public static void main(String[] args) {
        String str = "ABC";
        int[] count = new int[]{1, 1, 1};
        char[] chars = str.toCharArray();
        char[] result = new char[str.length()];

        //permute(chars, count, result, 0);
        combination(chars, count, result, 0,0);
    }

    public static void permute(char[] chars, int[] count, char[] result, int level) {

        if (level == chars.length) {
            for (int k = 0; k < result.length; k++) {
                System.out.print(result[k]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[level] = chars[i];
            count[i]--;
            permute(chars, count, result, level + 1);
            count[i]++; // This is that magic line! , basically we need to restore the count back for the next call.
        }
    }

    /**
     * subset
     * @param chars
     * @param count
     * @param result
     * @param pos
     * @param level
     */
    public static void combination(char[] chars, int[] count, char[] result, int pos, int level) {


        for (int k = 0; k < level; k++) {
            System.out.print(result[k]);
        }
        System.out.println();


        for (int i = pos; i < chars.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[level] = chars[i];
            count[i]--;
            combination(chars, count, result, i, level + 1);
            count[i]++; // This is that magic line! , basically we need to restore the count back for the next call.
        }
    }
}
