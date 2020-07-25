public class SolutionPower {

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        boolean negPow = n < 0 ? true : false;
        n = Math.abs(n);
        double res = 1.0;

        for(int i=31; i>=0; i--) {
            res = res * res;
            System.out.println("for now res is " + res);
            System.out.println("calculation with & is " + (n & (1<<i)) + " with i " + i);
            if((n & (1<<i)) > 0) {
                res = res * x;
                System.out.println("and res is " + res);
            }
        }
        if(negPow) res = 1/res;
        return res;
    }

    public static void main(String[] args) {
        double a = myPow(2.500,4);
        System.out.println(a);
    }
}
