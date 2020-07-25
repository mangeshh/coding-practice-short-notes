import java.util.ArrayList;
import java.util.List;

public class SolutionShortestDistChar {

    @SuppressWarnings("unused")
    public static int [] findRange(List<Integer> list, int val){
        int [] range = new int[2];

        for(int i= 0; i < list.size() -1 ; i++){
            if(list.get(i) > 0){
                range[0] = -1;
                range[1] = i;
                break;
            }
            else if(i!=0 && list.get(i) <= val && list.get(i+1)>=val){
                range[0] = i;
                range[1] =  i+1;
                break;
            }
        }

        return range;
    }

    public static int[] shortestToChar(String S, char C) {
        int[] output = new int[S.length()];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if (C == S.charAt(i)) {
                list.add(i);
            }

        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < S.length(); j++) {
            char ch = S.charAt(j);

            for (int k = 0; k < list.size(); k++) {

                if (ch != C) {
                    int diff = Math.abs(j - list.get(k));
                    if (diff < min) {
                        min = diff;
                    }
                }else{
                    min = 0;
                }
            }

            output[j] = min;
            min = Integer.MAX_VALUE;

        }
        print(output);
        return output;

    }

    public static void print(int [] arg){
        for(int i: arg){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        shortestToChar("loveleetcode", 'e');
    }

}
