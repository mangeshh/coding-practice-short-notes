public class KadaneAlgorithm {

    public static void main(String[] args) {
        int [] array = new int[]{1,3,-15,0,-1,4,10,1,3,-1,20,12,11,-12,10};

        int max_till_now = 0;
        int max_value = 0;
        int start = 0;
        int end = 0;
        int f_start = 0;
        for(int i = 0; i < array.length; i++){

            max_till_now = max_till_now + array[i];

            if(max_till_now <  0){
                max_till_now = 0;
                start = i + 1;
            }


            if(max_value < max_till_now){
                max_value = max_till_now;
                end = i;
                f_start = start;
            }
        }

        System.out.println(max_value);
        System.out.println(f_start);
        System.out.println(end);

    }
}
