package code.course;


import java.util.Arrays;

@SuppressWarnings("unused")
public class BinaryCombination {

    public static int [] A = new int [3];

    public static String makeSpace(String s){
        return s + s;
    }

    public static void binary(String level, int n){
        if(n < 1){
            System.out.println(level + "|");
            System.out.println(level + "base case binary("+ n+"), " + Arrays.toString(A));
        }else{
            A[n-1] = 0;
            System.out.println(level + "|");
            System.out.println(level + "|");
            System.out.println(level + "A[" + (n-1) +"] = 0, " + Arrays.toString(A));
            System.out.println(level + "ƒ(0), binary("+ n+"), " + Arrays.toString(A));
            binary(makeSpace(level), n-1);
            A[n-1] = 1;
            System.out.println(level + "|");
            System.out.println(level + "|");
            System.out.println(level + "A[" + (n-1) +"] = 1, " + Arrays.toString(A));
            System.out.println(level + "ƒ(1), binary("+ n+")" + Arrays.toString(A));
            binary(makeSpace(level), n-1);
        }
    }


    public static void binary( int n){
        if(n < 1){
            System.out.println(Arrays.toString(A));
        }else{
            A[n-1] = 0;
            binary(n-1);
            A[n-1] = 1;
            binary(n-1);
        }
    }

    public static void main(String[] args) {
            binary("   ",A.length);
    }
}
