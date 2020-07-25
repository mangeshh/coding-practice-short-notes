package code.course.extra;

public class IndexEqualsValueSearch {

    static int index(int[] arr, int l, int r) {
        // your code goes here
        if (r < l) {
            return -1;
        }
        if (arr.length == 1) {
            if (arr[0] == 0) return 0;
            return -1;
        }

        int min = 99;
        int mid = (l + (r - 1)) / 2;

        if (arr[mid] == mid) {
            return mid;
        }

        if (mid == 0) return -1;

        if (arr[mid] < mid) {
            min = Math.min(min, index(arr, mid + 1, r));
        } else {
            min = Math.min(mid, index(arr, l, mid - 1));
        }


        return min;
    }

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here
        return index(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        indexEqualsValueSearch(new int[]{-5, 0, 3, 4, 10, 18, 27});
    }

}
