import java.math.BigInteger;

/**
 *
 */
public class DuplicatesInSortedArray {

    @SuppressWarnings("unused")
    public static String multiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        return n1.multiply(n2).toString();
    }

    /**
     *
     * @param number
     * @return
     */
    public static String findBinary(long number) {
        String result = "";
        int i;
        if(number == 0){
            return "0";
        }

        for (i = 0; i < number; i++) {
            if ((int) Math.pow(2, i) > number){
               break;
            }
        }

        for (int j = i-1; j >= 0; j--) {
            long temp = (int) Math.pow(2, j);
            long ans = number / temp;
            result = result + ans + "";
            number = number % temp;
        }

        System.out.println(result);
        return result;
    }

    public static void addBinary(String a, String b) {
        long c = addBinary(a) + addBinary(b);
        findBinary(c);
    }

    public static long addBinary(String a) {
        int sum = 0;
        char[] chars = a.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int target = Character.getNumericValue(chars[chars.length - 1 - i]);
            if(target > 0){
                sum = sum + (int) Math.pow(2, i);
            }
        }
        System.out.println(sum);
        return sum;
    }

    @SuppressWarnings("unused")
    public static int removeDuplicates(int[] nums) {
        int k = nums.length;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (true) {
                if (nums[j] == nums[j + 2] && j < nums.length - 1) {
                    j++;
                    k--;
                } else {
                    if (i != j) {
                        nums[i] = nums[j + 1];
                        j = k + 1;
                    } else {
                        j++;
                        i++;
                    }
                }
            }
        }

        for (int c = 0; c < k; c++) {
            System.out.print(nums[c]);
            System.out.println();
        }
        System.out.println(k);
        return k;

    }

    public static void main(String[] args) {
        //removeDuplicates(new int[] {1,1,1,1,2,3});
        //multiply("6913259244", "71103343");
        addBinary("0", "1");
     }
}
