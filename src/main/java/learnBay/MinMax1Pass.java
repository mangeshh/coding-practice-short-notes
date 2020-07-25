package learnBay;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair {
    int min;
    int max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "("+min+", "+max+")";
    }
}
@SuppressWarnings("unused")
public class MinMax1Pass {


    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,7};
        //getPairs(input);
        sumCheck(input, 7);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            if (number < min) {
                min = number;
            } else if (number > max) {
                max = number;
            }
        }

        System.out.println("min is " + min + " max is " + max);
    }

    static void getPairs(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            List<Pair> pairs = new ArrayList();
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] < input[j]) {
                    pairs.add(new Pair(input[i], input[j]));
                }
            }
            System.out.println(pairs);
        }
    }

    static void sumCheck(int[] input, int K) {
        Arrays.sort(input);
        List<Pair> pairs = new ArrayList();
        int i = 0;
        int j = input.length-1;
        while(i < j){
            int sum = input[i] + input[j];
            if( sum < K){
                i++;
            }else if (sum > K ){
                j--;
            } else{
                pairs.add(new Pair(input[i], input[j]));
                i++;
                j--;
            }
        }
        System.out.println("sumCheck " + pairs);
    }

    @Override
    public String toString() {
        return "MinMax1Pass{}";
    }
}
