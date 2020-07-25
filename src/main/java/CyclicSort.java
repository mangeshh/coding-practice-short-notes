import java.util.Arrays;

class CyclicSort {

    public static void sortM(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[a[i] - 1] != a[i]) {
                int temp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = temp;
            } else {
                i++;
            }
        }
    }

    public static void sort(int[] nums) {
        int i = 0;
        System.out.println(Arrays.toString(nums));
        while (i < nums.length) {
            int j = nums[i] - 1;
            System.out.println("nums[" + i + "]=" + nums[i] + " supposed to be at position " + j);
            System.out.println("comparing nums[" + i + "]=" + nums[i] + " with nums[" + j + "]=" + nums[j]);
            if (nums[i] != nums[j]) {
                System.out.println("swapping...");
                swap(nums, i, j);
                System.out.println("updates " + Arrays.toString(nums));
            } else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sortM(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 6, 4, 3, 1, 5};
        CyclicSort.sortM(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{1, 5, 6, 4, 3, 2};
        CyclicSort.sortM(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
