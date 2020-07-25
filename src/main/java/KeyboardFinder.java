import java.util.HashMap;
import java.util.Map;

public class KeyboardFinder {

    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> keyMap = new HashMap();
        char[] keys = keyboard.toCharArray();
        char[] words = word.toCharArray();
        for (int i = 0; i < keys.length; i++) {
            keyMap.put(keys[i], i);
        }
        int start = keyMap.get(words[0]);
        int total = start;
        for (int j = 1; j < words.length; j++) {
            total = total + Math.abs(start - keyMap.get(words[j]));
            start = keyMap.get(words[j]);
        }

        return total;
    }

    public static long power(int n, int k){
        long num = 1;
        for(int i=0; i < k ; i++){
             num = num * n;
        }
        return num;
    }

    public static boolean isArmstrong(int N) {
        int temp = N;
        int cnt = 0;
        long sum = 0;
        int org = N;
        while (temp > 0){
            temp  = temp / 10;
            cnt++;
        }

        while (N > 0){
            sum = sum + power(N % 10, cnt);
            N = N /10;
        }

       if(org == sum){
            return true;
       }

        return false;

    }

    public static void main(String[] args) {
        calculateTime("abcdefghijklmnopqrstuvwxyz", "cba");
        boolean ans = isArmstrong(153);
        System.out.println(ans);
    }
}
