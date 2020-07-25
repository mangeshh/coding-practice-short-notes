import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
class GenerateBracket {

    public static void generateParenthesis(String level, String str, int left, int right, List<String> list){
        System.out.println(level + "generateParenthesis("+ str + ", " + left + ", "+ right);
        if(left < 0) return;
        if(left > right) {
            return;
        }

        if(right == left && left == 0){
            System.out.println(level + "matched : generateParenthesis("+ str + ", " + left + ", "+ right);
            list.add(str);
        }
        generateParenthesis(getLevel(level), str+"(", left-1, right, list);
        generateParenthesis(getLevel(level), str+")", left, right-1, list);
    }

    public static String getLevel(String b){
        return b + b ;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        String level = " ";
        generateParenthesis(level, "", n,n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("answer : " + generateParenthesis(3));
    }
}