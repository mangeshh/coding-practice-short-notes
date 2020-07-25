import java.util.Arrays;

public class AuxBufferPerm {


    public static void function(int[] a, int[] b, int pos) {
        if (pos == (b.length)) {
            System.out.println(Arrays.toString(b));
            return;
        }

        for(int i= pos; i < b.length; i++){
            for(int j = i; j < a.length; j++){
                b[pos] = a[j];
                function(a, b, i+1);
            }
        }
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};
        int b[] = new int[2];
        function(a, b, 0);
    }
}
