
import java.util.Stack;

public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack();
        Stack<Integer> temp = new Stack();
        input.push(10);
        input.push(100);
        input.push(1);
        input.push(5);
        input.push(2);
        input.push(6);
        input.push(4);

        while(!input.isEmpty()){
            int test = input.pop();

            while(!temp.isEmpty() && test < temp.peek()){
                input.push(temp.pop());
            }

            temp.push(test);
        }

        System.out.println(temp);
    }
}
