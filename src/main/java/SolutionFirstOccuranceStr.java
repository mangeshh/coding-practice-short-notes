public class SolutionFirstOccuranceStr {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty()) {
            return -1;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }

        char[] h = haystack.toCharArray();
        char[] s = needle.toCharArray();
        // here we want to iterate ~ say haystack is abcde and needle is css
        // then we need to iterate to ab as j will be incremented.
        for (int i = 0; i < h.length - s.length + 1; i++) {
            int k = 0;
            int j = i;
            System.out.println("i is " + i + " and k is " + k);
            while (k < s.length && h[j] == s[k]) {
                k++;
                j++;
            }
            if (k == s.length) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int i = strStr("mississippi", "issipi");
        System.out.println(i);
    }
}
