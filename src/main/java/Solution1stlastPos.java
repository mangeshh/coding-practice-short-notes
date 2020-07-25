@SuppressWarnings("unused")
public class Solution1stlastPos {

    public static int search(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                return search(nums, mid + 1, end, target);
            } else if (nums[mid] > target) {
                return search(nums, 0, mid - 1, target);
            } else {
                return mid;
            }
        }


        return -1;

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int a = search(nums, 0, nums.length - 1, target);
        int res = a;
        int start = -1;
        int end = -1;

        if (a == -1) {
            return new int[]{-1, -1};
        } else {
            while (a < nums.length - 1 && nums[a] == nums[a + 1]) {
                a++;
            }
            end = a;
            a = res;
            while (a > 0 && nums[a] == nums[a - 1]) {
                a--;
            }
            start = a;

        }

        ans[0] = start;
        ans[1] = end;
        return ans;

    }

    public static void main(String[] args) {
        int[] ans = searchRange(new int[]{1,4}, 4);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
    }
}
