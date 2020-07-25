import java.util.Stack;

public class StackSorting {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.add(10);
        s1.add(5);
        s1.add(4);
        s1.add(6);
        s1.add(20);

        while(!s1.isEmpty()){
            Integer src = s1.pop();
            if(s2.isEmpty()){
                s2.add(src);
                continue;
            }
            int target = s2.pop();

            if(src < target){
              while(true){

              }
            }
        }


    }
}
