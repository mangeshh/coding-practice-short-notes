import java.util.Arrays;

public class Combination {

    public static String getLevel(String s) {
        s = s + s + s;
        return s;
    }

    public static String space(int i) {
        String s = " ";
        for (int k = 0; k < i; k++) {
            s = s + " ";
        }
        return s;
    }

    public static void printCombo(String level, int[] a, int[] buffer, int startIndex, int bufferIndex) {

        System.out.println(space(level.length()) + "|");
        System.out.println(space(level.length()) + "|");
        System.out.println(space(level.length()) + " >> printCombo(" + Arrays.toString(buffer) + ", " + startIndex + ", " + bufferIndex + ")");

        if (buffer.length == bufferIndex) {
            System.out.println(Arrays.toString(buffer));
            System.out.println(space(level.length()) + " return, buffer full " + Arrays.toString(buffer));
            return;
        }

        for (int i = startIndex; i < a.length; i++) {
            buffer[bufferIndex] = a[i];
            System.out.println(space(level.length()) + " added a[" + i + "] = " + a[i] + ", " + Arrays.toString(buffer) + " bufferIndex " + bufferIndex);
            printCombo(getLevel(level), a, buffer, startIndex + 1, bufferIndex + 1);
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        int[] b = new int[2];
        printCombo("--", a, b, 0, 0);

    }
}
