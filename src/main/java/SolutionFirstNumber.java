import java.util.Arrays;

//TODO
class SolutionFirstNumber {

    public static int firstMissingPositive(int[] nums) {

        int ans = nums.length;
        Arrays.sort(nums);
        int largest = nums[nums.length-1] + 1;
        int [] test = new int[largest];
        test [0] = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0)
                continue;
            test[nums[i]] = 1;
        }

        for(int j=0; j < largest; j++){
            if(test[j] !=1){
                ans = j;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int i [] = new int [] {2147483647};
        System.out.println(firstMissingPositive(i));
    }
}