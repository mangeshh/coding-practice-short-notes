import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class RomanToNumber {

    static Map<Character, Integer> single = new HashMap<>();

    static {
        single.put('I', 1); single.put('V', 5); single.put('X', 10); single.put('L', 50); single.put('C', 100); single.put('D', 500);  single.put('M', 1000);
    }

    public static int getNumber(String roman) {
        char[] chs = roman.toCharArray();
        int start = chs.length - 1;  int end = start; // keeping start and end at same point.
        int sum = 0; int prevTotal = Integer.MIN_VALUE;

        // window sliding
        while (end >= 0) {

            while (start >= 1 && single.get(chs[start - 1]) <= single.get(chs[start])) {
                start = start - 1;
            }
            //displayResult(chs, start, end); // it displays array from start to end.
            int tempTotal = 0;
            boolean max = (end - start) >= 1 && single.get(chs[start]) < single.get(chs[start + 1]) ? true : false; // here we check - IV, IX..

            for (int j = start; j <= end; j++) {
                if (max) {
                    tempTotal = Math.abs(tempTotal - single.get(chs[j]));
                } else {
                    tempTotal = tempTotal + single.get(chs[j]);
                }
            }

            if (prevTotal > tempTotal) {
                throw new IllegalArgumentException("invalid roman number");
            }

            prevTotal = tempTotal;
            sum = sum + tempTotal;

            start = start - 1;
            end = start;
        }
        return sum;
    }

    public static void displayResult(char[] chs, int start, int end) {
        for (int j = start; j <= end; j++) {
            System.out.print(chs[j]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        getNumber("XL");
    }
}
