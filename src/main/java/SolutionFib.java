import java.util.HashMap;
import java.util.Map;

public class SolutionFib {
    // 0 1 1 2 3 5
    static Map<Integer, Integer> map = new HashMap<>();
    public static int fib(int n){
        if(n <= 0 ){
            return 1;
        }

        if(map.get(n-1) != null && map.get(n-2)!=null){
            return map.get(n-1)  + map.get(n-2) ;
        }

        int n1 = fib(n-1);
        int n2 = fib(n-2);
        map.put(n-1, n1);
        map.put(n-2, n2);
        return n1 + n2;
    }

    public static void main(String[] args) {
        System.out.println(fib(44));
    }
}
