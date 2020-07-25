public class ReverseInt {

    public static int reverse(int x) {
        int isSign = 0;

        String s = String.valueOf(x);
        if(s.charAt(0) == '-'){
            s = s.substring(1);
            isSign = 1;
        } else if(s.charAt(0) == '+'){
            s = s.substring(1);
            isSign = 2;
        }

        char[] chs = s.toCharArray();
        int length = s.length();
        int temp = Character.getNumericValue(chs[length - 1]);
        int dec = 10;
        for (int i = length - 2; i >= 0; i--) {
            if(temp > (Integer.MAX_VALUE/10)){
                temp = 0;
                break;
            }
            temp = (dec * temp) +  Character.getNumericValue(chs[i]);

        }
        if(isSign == 1){
            temp = temp * -1;
        }
        return temp;
    }

    public static void main(String[] args) {
        int ans = reverse(1534236469);
        System.out.println(ans);
    }
}
