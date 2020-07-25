
@SuppressWarnings("unused")
public class StringTriplet {

    public static void removeTriplet(String str) {

        char[] chs = str.toCharArray();
        int cnt = -1;
        for (int i = 0; i < chs.length - 3; i = i + 2) {
            if (chs[i] == chs[i + 1] && chs[i + 1] == chs[i + 2]) {
                cnt = i;
                break;
            }
        }

    }

    public static void main(String[] args) {
        String s = "AAABC";
    }
}
