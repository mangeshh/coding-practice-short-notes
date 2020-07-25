
@SuppressWarnings("unused")
public class SolutionRotatedArraySearch {


    public static int findPivotBS(int[] nums, int start,int end) {

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid+1;
            } else if (nums[start] > nums[mid]) {
                return findPivotBS(nums, start, mid-1);
            } else{
                return findPivotBS(nums, mid+1, end);
            }
        }

        return -1;
    }


    public static int findPivot(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }


    public static int search(int[] arr, int search) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == search) {
                return mid;
            }

            if (arr[mid] < arr[high]) {
                if (arr[mid] < search && search <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (search >= arr[low] && search < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2);
        System.out.println(index);
        //System.out.println(findPivot(new int[]{4,5,6,7,0,1,2}));
    }
}
