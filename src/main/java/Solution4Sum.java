import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {

                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);

                        result.add(list);

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    } else {
                        l--;
                    }

                }

            }
        }
        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {
        fourSum(new int[]{0, 0, 0, 0}, 0);
    }
}
