public class LBSMQ3 {
    public static void main(String[] args) {
        int [] input = new int[] {2,4,11,5,8,1,9};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int maxValue = 0;
        for(int i =0; i< input.length; i++){

            if(input[i] < min){
                min = input[i];
                startIndex = i;
            } else if(input[i] > max){
                max = input[i];
                endIndex = i;
            }

            if(maxValue < (max-min) && endIndex > startIndex){
                maxValue = max - min;
                System.out.println(maxValue + " start index " + startIndex + " endIndex " + endIndex);
            }
        }

    }
}
