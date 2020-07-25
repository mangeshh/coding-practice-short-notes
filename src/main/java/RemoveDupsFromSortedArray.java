import java.util.Arrays;

public class RemoveDupsFromSortedArray {

    public static void swap(char [] chs, int i1, int i2){
        char temp = chs[i1];
        chs[i1] = chs[i2];
        chs[i2] = temp;
    }

    public static void removeSpace(String str){
            char [] chs = str.toCharArray();
            int j = 0;

            for(int i =0 ; i < chs.length; i++){
               if(chs[i] == ' '){
                   i++;
                   continue;
               }
               j++;
               swap(chs, i, j);
            }

            for(int k =0; k < j; k++){
                System.out.println(chs[k]);
            }
    }


    public static void main(String[] args) {
        int [] array = new int [] {1,2,3,3,4,4,5,5,5};
        int [] temp = new int[array.length];
        temp[0] = array[0];
        int j = 1;
        for(int i=1; i < array.length; i++){
            if(array[i-1] != array[i]){
                temp[j] = array[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(temp));

        removeSpace("remove space");
    }
}
