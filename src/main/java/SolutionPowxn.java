public class SolutionPowxn {

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if(n == Integer.MIN_VALUE){
            return 0;
        }
        boolean negPow = n < 0 ? true : false;
        n = Math.abs(n);
        double res = 1.0;

        for(int i=31; i>=0; i--) {
            res = res * res;
            if((n & (1<<i)) > 0) {
                res = res * x;
                System.out.println("and res is " + res);
            }
        }
        if(negPow) res = 1/res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.000,-2147483648));
    }
}
