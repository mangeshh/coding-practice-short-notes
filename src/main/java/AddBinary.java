/**
 * adding two binary numbers.
 *
 *
 *
 */
class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0, sum;
        while (i >= 0 || j >= 0) {
            sum = carry;
            System.out.println("loop start again, sum/carry is " + sum + " [" + i +"]");
            if (i >= 0) {
                int temp1 = a.charAt(i--) - '0';
                System.out.println("char[a] " + temp1);
                sum  = sum + temp1;
            }
            if (j >= 0){
                int temp2 = b.charAt(j--) - '0';
                System.out.println("char[b] " + temp2);
                sum  = sum  + temp2;
            }
            System.out.println("inside sum "+ sum);
            carry = sum / 2;
            System.out.println("[carry=sum/2] "+ carry);
            sum = sum % 2;
            System.out.println("[sum=sum%2] "+ sum);
            result.insert(0, sum);
            System.out.println(result.toString());
        }
        if (carry == 1) result.insert(0, carry);
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(addBinary("101","111"));
    }
}