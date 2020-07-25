import java.util.ArrayList;

public class GenerateParenthesis {

    public static String  level(String s){
        String s1 = s + "------" ;
        return s1;
    }

    public static void dfs(String space, ArrayList<String> result, String s, int left, int right){
        System.out.println(space + "calling dfs with " + s + " left " + left + " right "+ right);
        if(left > right)
            return;

        if(left==0 && right==0){
            //System.out.println("======");
            System.out.println(s);
           // System.out.println("======");
            result.add(s);
            return;
        }

        if(left>0){
            dfs(level(space), result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(level(space), result, s+")", left, right-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        dfs("-", result, "", 3, 3);
    }
}
