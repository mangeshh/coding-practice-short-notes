public class NumberOfwaysCoinChangingProblem {

    public static int numberOfWays(int [] input, int n){

        if(n == 0 ){
            return 1;
        }

        if(n < 0 ){
            return 0;
        }

        int x = numberOfWays(input, n-1);
        int y = numberOfWays(input, n-2);
        int z = numberOfWays(input, n-3);

        return x+y+z;
    }

    public static void main(String[] args) {
        int a [] = new int [] {1,2,3};
        System.out.println(numberOfWays(a, 4));
    }
}
