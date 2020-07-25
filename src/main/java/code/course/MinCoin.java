package code.course;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MinCoin {

    public static int cost(int[] a, int n, int sum) {
        if (sum == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] > sum) continue;
            int t = 1 + cost(a, n, sum - a[i]); // increment the count as coin is being added.
            res = Math.min(t, res);
        }
        return res;
    }

    public static void bottomUpCost(int[] a, int sum) {
        int temp[][] = new int[sum][a.length];

        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j == 0) {
                    temp[i][j] = 0;
                    continue;
                }
                if (j < a[j]) {
                    temp[i][j] = a[j];
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - a[j]]);
                }
            }
        }

        System.out.println(Arrays.toString(temp));
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 3, 5, 7, 9, 10};
        //System.out.println(cost(a, a.length, 15));
        bottomUpCost(a, 15);
    }
}
