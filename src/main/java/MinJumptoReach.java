import java.util.Arrays;

public class MinJumptoReach {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 3, 2, 3, 4, 5, 1, 2, 8};
        int[] jumps = new int[array.length];
        int[] indexTracker = new int[array.length];

        for (int k = 1; k < array.length; k++) {
            jumps[k] = 999;
        }
        jumps[0] = 0;
        indexTracker[0] = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + array[j]) {
                    int min;
                    if (jumps[i] <= jumps[j] + 1) {
                        min = jumps[i];
                    } else {
                        min = jumps[j] + 1;
                        indexTracker[i] = j;
                    }
                    jumps[i] = min;
                }

            }
        }

        System.out.println(Arrays.toString(jumps));
        System.out.println(Arrays.toString(indexTracker));
    }
}
