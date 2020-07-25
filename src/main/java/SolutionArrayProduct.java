public class SolutionArrayProduct {

    public static int[] productExceptSelf(int[] nums) {
        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            t1[i] = t1[i - 1] * nums[i-1];
        }

        t2[nums.length-1] = 1;

        for (int j = nums.length-2; j >=0; j--) {
            t2[j] = t2[j + 1] * nums[j + 1];
        }

        int[] ans = new int[nums.length];

        for (int k = 0; k < nums.length; k++) {
            ans[k] = t1[k] * t2[k];
        }
        return ans;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[] {1,2,3,4});
    }
}
