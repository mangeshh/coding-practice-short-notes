public class SolutionInsertPlace {

    public static int searchInsert(int[] nums, int target) {
        if(target <= nums[0]){
            return 0;
        }
        if(target > nums[nums.length-1]){
            return nums.length;
        }
        int i =0;

        while(nums[i] < target) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        searchInsert(new int [] {1,3,5,6} , 2);
    }
}
