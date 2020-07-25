import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordPosition {

    public static List<String> list = new ArrayList();

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static List<String> test_data_possiblePermutation(int l, int r, String str) {
        if (l == r) {
            list.add(str);
            return list;
        } else {
            for (int i = l; i < str.length(); i++) {
                String s = swap(str, l, i);
                test_data_possiblePermutation(l + 1, r, s);
            }
        }
        return list;
    }

    public static int getPosition(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += (str.charAt(i) - 'A' + 1) * (int)Math.pow(26, (str.length()-i-1));
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ABCD";
        List<String> testScenarios = test_data_possiblePermutation(0, s.length() - 1, s);
        for (String testStr : testScenarios) {
            System.out.println();
            testStr = testStr.toUpperCase();
            System.out.println("Testing word " + testStr);
            System.out.println("answer using maths " + getPosition(testStr));
            System.out.println("answer using manual queue " + getQueuePosition(testStr));
        }
    }

    public static int getQueuePosition(String str) {
        LinkedList<String> q = new LinkedList<>();
        int cnt = 0;
        for (int k = 65; k < 91; k++) {
            cnt++;
            String temp = (char) k + "";
            if (str.equals(temp)) {
                return cnt;
            }
            //System.out.println("adding string into queue " + temp);
            q.add(temp);
        }
        while (!q.isEmpty()) {
            String s = q.pop();

            for (int k = 65; k < 91; k++) {
                cnt++;
                String temp = s + (char) k;
                //System.out.println("string++ in queue " + temp);
                if (str.equals(temp)) {
                    return cnt;
                }
                q.add(temp);
            }
        }
        return -1;
    }

}
