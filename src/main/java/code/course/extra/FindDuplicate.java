package code.course.extra;

import java.util.Arrays;

public class FindDuplicate {

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                System.out.println("if value at index " + i + " not equals to " + (i+1));
                System.out.println("comparing value " + nums[i]  + " at index " +  i + " with value "+ nums[nums[i] - 1] + " at index " + (nums[i] - 1));
                if (nums[i] != nums[nums[i] - 1]) {
                    System.out.println("swapping indexes at " + i  + " with "+ (nums[i] - 1));
                    System.out.println("before  swap" + Arrays.toString(nums));
                    swap(nums, i, nums[i] - 1);
                    System.out.println("after swap " + Arrays.toString(nums));
                }
                else // we have found the duplicate
                    return nums[i];
            } else {
                i++;
                System.out.println("increasing i " + i);
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[]{1, 4, 4, 3, 2}));
        System.out.println(FindDuplicate.findNumber(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(FindDuplicate.findNumber(new int[]{2, 4, 1, 4, 4}));
    }
}
