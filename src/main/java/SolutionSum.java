import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionSum {

        public static int getIndex(int [] src, int num, int exists){
            int ans = -1;
            for(int i =0; i < src.length; i++){
                if(i== exists){
                    continue;
                }
                if(src[i] == num){
                    ans= i;
                    break;
                }
            }
            return ans;
        }

        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for(int x = 0; x < nums.length; x++){
                map.put(nums[x], x);
            }
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length-1;
            int ans [] = new int[2];

            while(left <= right){
                if( (nums[left] + nums[right]) > target){
                    right --;
                } else if(nums[left] + nums[right] < target){
                    left++;
                } else{
                    ans[0] = map.get(nums[left]);
                    ans[1] = map.get(nums[right]);
                    break;
                }
            }

            return ans;
        }

        public static void main(String[] args) {
            twoSum(new int[]{3,2,4}, 6);
        }
}
