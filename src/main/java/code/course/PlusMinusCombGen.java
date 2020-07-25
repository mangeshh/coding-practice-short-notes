package code.course;

public class PlusMinusCombGen {
    final static int MAX = 5;

    public static String generate(String s, int n) {
        if (n == MAX) {
            System.out.println(s);
            return s;
        }
        return generate(s + "+", n + 1) +
                generate(s + "-", n + 1);
    }

    public static void main(String[] args) {
        generate("", 0);
    }
}
