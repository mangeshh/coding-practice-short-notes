package code.course;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MinCoins {

    public static String doubleLevel(String level){
        return level + level + level;
    }

    public static void coin(String level, int[] C, int n, int bufferIndex, int[] buf) {
        if (bufferIndex == 4) {
            System.out.println(level + "coin(C:"+ Arrays.toString(C) + ", n:" + (n+1) + ", buf:" + Arrays.toString(buf) + ")");
            return;
        }

        for (int i = 0; i < C.length; i++) {
            buf[bufferIndex] = C[i];

            System.out.println(level + "to buf"+ Arrays.toString(buf) + " at index " + bufferIndex + " from C[i:"+i+"]");
            System.out.println(level + "coin(C:"+ Arrays.toString(C) + ", --> n:" + (n) + ", buf:" + Arrays.toString(buf) + ")");
            coin(doubleLevel(level), C, n + 1, n + 1, buf);
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,1};
        int buf[] = new int[4];
        coin("  ", A, 0, 0, buf);
    }

}
