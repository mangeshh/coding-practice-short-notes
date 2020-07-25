@SuppressWarnings("unused")
public class FireCodeMaxGain {

    public static int maxGain(int[] a) {

        int maxGain = 0;

        int diff = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int left = i;
            int right = a.length - 1;
            while (left < right) {
                diff = a[right] - a[left];
                if (diff > maxGain) {
                    maxGain = diff;
                }
                right--;
            }

        }
        return maxGain;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 50, 10, 100, 30};
        System.out.println(maxGain(a));
    }
}
