public class KeyBoardDistance {

    public static int calc(String keyBoard, String word){
        char[] words = word.toCharArray();
        char [] keyBoards = keyBoard.toCharArray();
        int [] arr = new int[26];
        for(int k=0; k< keyBoard.length(); k++){
            arr[keyBoards[k] - 97] = k;
        }
        int current = arr[words[0] - 97];
        int distance = current;
        for(int i= 1; i < words.length; i++){
            distance = distance + Math.abs(current - (arr[words[i]-97]));
            current = (arr[words[i]-97]);
        }
        return distance;
    }

    public static void main(String[] args) {
        int res = calc("pqrstuvwxyzabcdefghijklmno", "leetcode");
        System.out.println(res);
    }
}
