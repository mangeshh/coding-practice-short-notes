public class KeyborardDistanc {

    public static int calc(String keyBoard, String word){
        char[] words = word.toCharArray();
        int distance = words[0] - 95;

        for(int i=0; i < words.length; i++){
            distance = distance + Math.abs(distance- (words[i]-95));
        }
        return distance;
    }

    public static void main(String[] args) {
        int res = calc("Abcdefgh", "cd");
        System.out.println(res);
    }
}
