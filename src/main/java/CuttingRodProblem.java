import java.util.*;

@SuppressWarnings("unused")
public class CuttingRodProblem {
    static int EXPECTED = 5;
    public static int listTotal(LinkedList<Integer> input, int expected) {
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            sum += input.get(i);
            if (sum == expected) {
                return 0;
            }
            if (sum > expected) {
                return 1;
            }
        }
        return -1;
    }

    static int getTotal (LinkedList<Integer> input) {
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            sum += input.get(i);

        }
        return sum;
    }

    static LinkedList<Integer> possibleEntries = new LinkedList<>();

    public static int maxProfit(List<Integer> input, int n, int sum) {
        if (n < 0) {
            return 0;
        }
        int total = getTotal(possibleEntries);

        if(total == 0) return 0;

        if (total == EXPECTED) {
            System.out.println(total);
            System.out.println(possibleEntries);
            possibleEntries = new LinkedList<>();
            return 0;
        }if (total > EXPECTED){
            possibleEntries = new LinkedList<>();
            return 0;
        }

        for (int j = 0; j < EXPECTED; j++) {
            if(j == EXPECTED - 1 ) break;
            int element = input.get(j%input.size());
            possibleEntries.add(element);
            maxProfit(input, (n + 1 - element), sum + element);
        }

        possibleEntries = new LinkedList<>();
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList();
        input.add(0 );
        input.add(1 );
        input.add(2 );
        input.add(3 );
        input.add(4 );
        System.out.println(maxProfit(input, 5, 0));
    }
}
