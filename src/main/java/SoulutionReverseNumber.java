public class SoulutionReverseNumber {

    public static int reverse(int x) {

        int rem = x % 10;
        int ans = 0;

        while (x > 0) {
            ans = ans * 10 + rem;
            x = x / 10;
            rem = x % 10;
        }
        System.out.println(ans);
        return ans;

    }

    public static void main(String[] args) {
        reverse(123);
    }
}
