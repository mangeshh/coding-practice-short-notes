@SuppressWarnings("unused")
public class SolutionHouseRobMax2 {
    public int rob(int[] nums) {

        int evenSum1 = 0;
        int evenSum2 = 0;
        int oddSum1 = 0;
        int oddSum2 = 0;
        int sum1 = 0;
        int sum2 = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                evenSum1 = Math.max(evenSum1 + nums[i], oddSum1);
            } else {
                oddSum1 = Math.max(oddSum1 + nums[i], evenSum1);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum2 = Math.max(evenSum2 + nums[i], oddSum2);
            } else {
                oddSum2 = Math.max(oddSum2 + nums[i], evenSum2);
            }
        }

        int max1 = Math.max(evenSum1, oddSum1);
        int max2 = Math.max(evenSum2, oddSum2);

        return Math.max(max1, max2);

    }
}
