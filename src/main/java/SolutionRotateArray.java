public class SolutionRotateArray {

    public static void reverse(int[] nums, int startA, int endA) {
        while (startA < endA) {
            int temp = nums[endA];
            nums[endA] = nums[startA];
            nums[startA] = temp;
            startA++;
            endA--;
        }
    }

    public static void rotate(int[] nums, int k) {

        if (nums.length == 1) {
            return;
        }

        if (k > 0) {
            if (nums.length <= k) {
                k = k % nums.length;
            }
        }

        if(k ==0){
            return;
        }
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        for(int i : nums){
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2}, 1);
    }
}
