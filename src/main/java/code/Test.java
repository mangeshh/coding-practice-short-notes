package code;

import java.nio.charset.Charset;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        String s = "#_hello_#";
        byte[] b = s.getBytes(Charset.defaultCharset());

        Map<Character, Boolean> tags = new HashMap(2);
        tags.put('#', false);
        tags.put('_', false);

        List<Byte> l = new ArrayList<>();
        for(int i =0 ; i < b.length; i++){
            if(b[i] == (int)'#'){
                if(tags.get('#')){
                    l.add((byte) 60);
                    l.add((byte) 47);
                    l.add((byte) 98);
                    l.add((byte) 62);
                    tags.put('#', false);
                }else{
                    l.add((byte) 60);
                    l.add((byte) 98);
                    l.add((byte) 62);
                    tags.put('#', true);
                }
            } else if (b[i] == (int)'_'){
                if(tags.get('_')){
                    //60, 117, 62
                    l.add((byte) 60);
                    l.add((byte) 47);
                    l.add((byte) 117);
                    l.add((byte) 62);
                    tags.put('_', false);
                }else{
                    l.add((byte) 60);
                    l.add((byte) 117);
                    l.add((byte) 62);
                    tags.put('_', true);
                }
            } else{
                l.add(b[i]);
            }
        }
        byte [] temp = new byte[l.size()];
        for(int j=0; j < l.size(); j++){
            temp[j] = l.get(j);
        }

        System.out.println(new String(temp, "UTF8"));
    }

    public static class CorruptPair {

        public static int[] findNumbers(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                if (nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
                else
                    i++;

                System.out.println(Arrays.toString(nums));
            }

            for (i = 0; i < nums.length; i++)
                if (nums[i] != i + 1)
                    return new int[]{nums[i], i + 1};

            return new int[]{-1, -1};
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            int[] nums = CorruptPair.findNumbers(new int[]{3, 1, 2, 5, 2});
            System.out.println(nums[0] + ", " + nums[1]);
            nums = CorruptPair.findNumbers(new int[]{3, 1, 2, 3, 6, 4});
            System.out.println(nums[0] + ", " + nums[1]);
        }
    }
}
