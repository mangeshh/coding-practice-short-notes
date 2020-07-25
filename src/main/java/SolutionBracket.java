import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class SolutionBracket {

    static Map<Character,Character> map = new HashMap<Character,Character>(){{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char [] chs = s.toCharArray();
        if(chs.length%2 != 0){
            return false;
        }

        for(int i = 0 ;i < chs.length; i++){
            if(map.get(chs[i]) != null && !stack.isEmpty()){
                char ch = stack.pop();
                if(map.get(chs[i]) != ch){
                    return false;
                }
            } else {
                stack.push(chs[i]);
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = isValid("){");
        System.out.println(res);
    }

}
