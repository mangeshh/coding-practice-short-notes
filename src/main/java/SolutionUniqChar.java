public class SolutionUniqChar {

        public static int firstUniqChar(String s) {
            int index = -1;
            char [] chars = s.toCharArray();
            int [] results = new int[26];
            for(int i =0; i < chars.length; i++){
                results[chars[i] - 'a'] = results[chars[i] - 'a'] + 1;
            }

            for(int i = 0 ; i < results.length; i++){
                if(results[chars[i] - 'a'] == 1){
                    index = i;
                    break;
                }
            }

            return index;
        }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    }