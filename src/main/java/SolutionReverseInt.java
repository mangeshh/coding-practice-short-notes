public class SolutionReverseInt {

    public static int reverse(int x) {
        long sum = 0;
        boolean sign = true;
        long result;

        long n = Math.abs(x);

        if (x < 0) {
            sign = false;
        }

        while (n > 0) {
            long r = n % 10;
            sum = sum * 10 + r;
            n = n / 10;
        }

        if (sum > Integer.MAX_VALUE) {
            result = 0;
        } else {
            result = (int) sum;
        }

        if (!sign) {
            result = -1 * result;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));

        //System.out.println(964632435 * 10);
    }
}
