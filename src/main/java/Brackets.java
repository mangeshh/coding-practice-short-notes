import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        int input = 3;
        input = (int)Math.pow(2, (input));
        String binary = numberToBinary(input, -1);
        int expectedLength = binary.length();
        Set<String> set = new HashSet();
        for (int i = 0; i < input; i++) {
            set.add(printBrackets(i, expectedLength));
        }

        System.out.println(set);
    }

    @SuppressWarnings("unused")
    public static String printBrackets(int number, int expectedLength) {

        char[] ans = numberToBinary(number, expectedLength).toCharArray();
        String brackets = "";

        Stack<String> stack = new Stack();

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '1') {
                if (!stack.isEmpty()) {
                    brackets = brackets + stack.pop();
                }
                brackets = brackets + "()";
            } else if (ans[i] == '0') {
                if (stack.isEmpty()) {
                    stack.push("()");
                } else {
                    String temp = stack.pop();
                    stack.push("(" + temp + ")");
                }
            }
        }
        if (!stack.isEmpty()) {
            brackets = brackets + stack.pop();
        }

        return brackets;
    }

    public static String numberToBinary(int number, int expectedLength) {

        int pow = 1;

        while (pow < (number / 2) + 1) {
            pow = 2 * pow;
        }

        StringBuilder result = new StringBuilder();
        while (pow >= 1) {
            try {
                int a = number / pow;
                result.append(a);
                number = number % pow;
                pow = pow / 2;
            } catch (Exception e) {
            }
        }

        if (expectedLength > 0) {
            int padding = Math.abs(result.toString().length() - expectedLength);
            String paddingString = "";

            for (int i = 0; i < padding; i++) {
                paddingString = paddingString + "0";
            }

            result.append(paddingString);
        }

        String returnResult = result.toString();
        return returnResult;
    }
}
