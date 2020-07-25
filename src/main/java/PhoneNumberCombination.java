import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PhoneNumberCombination {

    static ArrayList<String> letterCombinationsUtil(int[] number, int n,
                                                    String[] table) {
        ArrayList<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.remove();
            System.out.println("before adding removing letter from queue " + s);
            if (s.length() == n)
                list.add(s);
            else {
                String val = table[number[s.length()]];
                for (int i = 0; i < val.length(); i++) {
                    System.out.println("adding into queue " + s + val.charAt(i));
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }

    static void letterCombinations(int[] number, int n) {
        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> list = letterCombinationsUtil(number, n, table);

        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
    }

    public static void main(String args[]) {
        int[] number = {2, 3, 4};
        int n = number.length;
        letterCombinations(number, n);
    }
}