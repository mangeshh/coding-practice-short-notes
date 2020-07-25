
@SuppressWarnings("unused")
//leetcode - contains-duplicate-ii
public class NUmberLimit {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i <= nums.length - k; i++) {
            int limit = Math.min(nums.length, i + k); // i = 0,1 & limit = 2,3
            for (int j = i+1; j <= limit && j < nums.length; j++) {
                 if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i= 0; i < nums.length; i++){
            int start = i + 1;
            int limit = start + k;
            for(int j = start; j <= limit && j < nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) <= t && j - i <= k){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //System.out.println(containsNearbyDuplicate(new int[]{99,99}, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{10,100,11,2}, 1, 2));
    }
}