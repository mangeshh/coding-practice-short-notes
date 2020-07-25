import java.util.Arrays;

public class IndexBecomesValue2DArray {


    public static void getAnswer(int [] a){
        int [] newA = new int [a.length];

        for(int i=0; i < a.length ; i++){
            newA[a[i]] = i;
        }

        System.out.println(Arrays.toString(newA));
    }

    public static void main(String[] args) {
        int [] input = new int [] {1,2,0,3};
        getAnswer(input);
    }
}
