package code.course;

@SuppressWarnings("unused")
public class SweetChocolate {


    public static int maximizeSweetness(int[] nums, int m) {
        m++;
        long l = Integer.MAX_VALUE, r = 0;
        for (int n : nums) {
            r += n;
            l = Math.min(l, n);
        }

        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            System.out.println("start [" + l + "] mid [" + mid + "] end [" + r + "]");

            if (canSplit(nums, m, mid)) {
                l = mid;
                System.out.println("can split so start ["+ mid + "]= mid and end ["+ r +"]");
            } else {
                r = mid - 1;
                System.out.println("can't split so, start ["+ l + "] and end ["+ (mid-1) +"] = mid-1");
            }
        }
        System.out.println("==> now l ["+ l +"] and r [" + r +"] criteria existed, and split cnt ["+ m + "]");
        if (canSplit(nums, m, r)) return (int) r;
        else return (int) l;
    }

    public static boolean canSplit(int[] nums, int m, long target) {
        System.out.println("ƒunct(cansplit): given split count " + m + " and mid " + target);
        long sum = 0, cnt = 0;
        System.out.println("Loop:");

        for (int n : nums) {
            if (sum + n >= target) {
                System.out.println("     (sum:"+ sum +", n:" + n+") " + (sum+n) + " is greater than target " + target);
                sum = 0;
                cnt++;
            } else {
                sum += n;
                System.out.println("     sum:" + sum + " is less than target " + target);
            }
        }
        System.out.println("ƒ(T/F) splits[" + cnt + "] can be sliced (cnt >= m)? " + (cnt >= m));
        System.out.println();
        return cnt >= m;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int x = maximizeSweetness(a, 2);
        System.out.println(x);
    }
}
