import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(c == ')'){
                char c1 = stk.pop();
                if(c1 != '('){
                    return false;
                }
            }
            else if(c == ']'){
                char c1 = stk.pop();
                if(c1 != '['){
                    return false;
                }
            }
            else if(c == '}'){
                char c1 = stk.pop();
                if(c1 != '{'){
                    return false;
                }
            }
            else {
                stk.push(c);
            }

        }

        if(stk.isEmpty()){
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        isValid("()");
    }
}
