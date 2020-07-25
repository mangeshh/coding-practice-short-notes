public class SolutionRemoveOuterPrnt {

    public static String removeOuterParentheses(String S) {
        int opened = 0;
        String res ="";
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                ++opened;
                if (opened != 1) {
                    res += ch;
                }
            } else {
                --opened;

                if (opened != 0) {
                    res += ch;
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        removeOuterParentheses( "((()())(()))");
    }
}

