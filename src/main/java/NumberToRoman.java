public class NumberToRoman {

    final static int MAX_LENGTH_NUMBER = 4; // limit till 4999

    public static String getRoman(int number) {

        String[] single = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM", "MMMM"};

        String[][] dictionary = new String[][]{single, tens, hundreds, thousands};
        String answer = "";

        for (int i = 0; i < MAX_LENGTH_NUMBER; i++) {
            int prev = number;
            number = number / 10;
            answer = dictionary[i][prev - number * 10] + answer;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception{

        for(int i = 0; i < 5000; i++){
            String roman = getRoman(i);
            int ans = RomanToNumber.getNumber(roman);
            System.out.printf("roman = %16s | number = %d \n", roman, ans);

            if(i != ans){
                throw new Exception("failed test");
            }
        }

    }
}
