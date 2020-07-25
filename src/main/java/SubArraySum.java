public class SubArraySum {
        public static int subarraySum(int[] nums, int k) {
            int cnt = 0;

            for(int i = 0 ; i < nums.length; i++){
                int sum  = nums [i];
                if(sum == k){
                    cnt++;

                }
                for(int j = i+1 ; j < nums.length; j++){
                    sum  =  sum + nums[j];
                    if(sum == k){
                        cnt++;
                    }
                }
            }

            return cnt;
        }


    public static boolean checkSubarraySum(int[] nums, int k) {

        for(int i =0; i < nums.length ; i++){
            int sum  =  nums[i];
            for(int j = i+1 ; j < nums.length ; j++){
                sum = sum + nums[j];
                if(k != 0 && sum%k == 0){
                    return true;
                }else if (k == 0 && sum ==0){
                    return true;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        checkSubarraySum(new int [] {23,2,4,6,7}, -6);
        //subarraySum(new int [] {28,54,7,-70,22,65,-6}, 100);
    }
}
