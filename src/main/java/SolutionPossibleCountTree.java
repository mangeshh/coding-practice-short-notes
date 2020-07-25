public class SolutionPossibleCountTree {

    public static int count(int n){
        int [] sum = new int [n+1];
        sum[0] = 1;
        sum[1] = 1;
        //TODO pattern.
        for(int i= 2; i <= n; i++){
            for(int j=0; j < i; j++){
                //System.out.println("sum["+i+"] = "+"sum["+j+"] * "+"sum["+(i-j-1)+"]");
                sum[i] += sum[j] * sum[i-j-1];
            }
        }

        return sum[n];
    }

    public static void main(String[] args) {
        int  ans = count(7);
        System.out.println(ans);
    }
}
