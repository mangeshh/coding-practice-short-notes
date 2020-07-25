@SuppressWarnings("unused")
public class CountTotal {

    public static int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int i = 0;
        int sum = 0;

        while (i < nums.length) {
            sum = sum + nums[i];
            if (sum == k || (i > 0 && sum - nums[i - 1] == k)) {
                cnt++;
                sum = 0;
                continue;
            }
            i++;

        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
     }

}
