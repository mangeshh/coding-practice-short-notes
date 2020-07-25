package code.course.extra;

public class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int i = 0;
        System.out.println("length is " + nums.length);
        while (i < nums.length) {
            System.out.println("i index is " + i + " with value " + nums[i]);
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                System.out.println("comparing at " + i + " ~ " + nums[i] + " and " + nums[nums[i]]);
                swap(nums, i, nums[i]);
            }
            else{
                i++;
                System.out.println("increasing i " + i);
            }
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[]{4, 0, 3, 1}));
        System.out.println(MissingNumber.findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}
