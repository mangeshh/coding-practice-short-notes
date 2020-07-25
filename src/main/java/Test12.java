import java.util.Arrays;

//learnBay
@SuppressWarnings("unused")
public class Test12 {

    public static void test1(int a) {
        a = a + 10;
        System.out.println(a);
    }

    public static void main(String[] args) {

    }

    public static void main2(String[] args) {
        int[] a = {6,2,4,5,3,1};
        int n = a.length;
        int temp = a[n-1];

        for(int i = n-2; i>=0; i--){
          if(a[i] < a[i+1]){
              a[i] = a[i+1];
          }
        }

        System.out.println(Arrays.toString(a));
    }

    public static void main1(String[] args) {
        int[] a = {6,2,4,5,3,1};
        int n = a.length;
        int temp = a[n-1];
        a[n-1] = -1;

        for(int i = n-2; i>=0;i--){
            int curr = a[i];
            if(a[i+1] > temp){
                a[i] = a[i+1];
            }else{
                a[i] = temp;
            }

            temp = curr;
        }

        System.out.println(Arrays.toString(a));
    }
}
