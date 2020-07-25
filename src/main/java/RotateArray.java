import java.util.Arrays;

/**
 * rotate by 2.
 */
public class RotateArray {

    public static void rotate(int start, int end, int[] array){
        while(end < start){
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
        }
    }

    public static void main(String[] args) {
        int [] array = new int [] {1,2,3,4,5,6,7};
        int r = 2;
        rotate(0,1,array);
        rotate(2,array.length-1,array);
        rotate(0, array.length-1,array);
        System.out.println(Arrays.toString(array));
    }
}
