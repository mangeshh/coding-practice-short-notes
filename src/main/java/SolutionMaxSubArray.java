public class SolutionMaxSubArray {

    public int maxProduct(int[] nums) {

        int max_so_far = Integer.MIN_VALUE;
        int max_till_here = 1;

        for (int i = 0; i < nums.length; i++) {
            max_till_here = max_till_here * nums[i];

            if (max_till_here > max_so_far) {
                max_so_far = max_till_here;
            }
            if (max_till_here < 0 && nums[i+1] > 0) {
                max_till_here = 0;
            }
        }

        return max_so_far;

    }

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + nums[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        SolutionMaxSubArray max = new SolutionMaxSubArray();
        //max.maxSubArray(new int[]{-2, -1});
        max.maxProduct(new int[]{-2, -1});
    }
}
