import java.util.*;

class Pair {

    int rowStart;
    int colStart;
    int range;

    public Pair(int rowStart, int colStart, int range) {
        this.rowStart = rowStart;
        this.colStart = colStart;
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return rowStart == pair.rowStart &&
                colStart == pair.colStart &&
                range == pair.range;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowStart, colStart, range);
    }
}

public class MatrixSqurSum {
    static Map<Pair, Integer> total = new HashMap();

    @SuppressWarnings("unused")
    public static int sumCut(int[][] a, int rowStart, int colStart, int range, int threshold) {
        Integer tillNowSum = total.get(new Pair(rowStart, colStart, (range - 1)));
        Integer sum = tillNowSum;
        if (range == 4) {
            System.out.println();
        }
        if (tillNowSum == null) {
            sum = sum(a, rowStart, colStart, range, threshold);
            total.put(new Pair(rowStart, colStart, range), sum);
        } else {
            if (sum > threshold) {
                return sum;
            }
            for (int colIndx = colStart; colIndx < (colStart + range) && (colStart + range) <= a[0].length; colIndx++) {
                sum = sum + a[rowStart + range - 1][colIndx];
            }
            if (sum > threshold) {
                total.put(new Pair(rowStart, colStart, range), sum);
                return sum;
            }
            for (int rowIndex = rowStart; rowIndex < (rowStart + range - 1) && rowStart + range <= a.length; rowIndex++) {
                sum = sum + a[rowIndex][range - 1];
            }
            if (sum > threshold) {
                total.put(new Pair(rowStart, colStart, range), sum);
                return sum;
            }
        }
        System.out.println("range " + range + ", sum is " + sum + ", for row[" + rowStart + "] col [" + colStart + "]");
        total.put(new Pair(rowStart, colStart, range), sum);
        return sum;
    }

    public static int sum(int[][] a, int rowStart, int colStart, int range, int threshold) {
        int sum = 0;
        for (int k = rowStart; k < (rowStart + range); k++) {
            for (int l = colStart; l < (colStart + range); l++) {
                sum = sum + a[k][l];
                if (sum > threshold) {
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] a1 = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int[][] a2 = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int[][] a3 = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int[][] a = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};

        int rows = a.length;
        int cols = a[0].length;
        int threshold = 6;

        total.put(new Pair(0, 0, 1), a[0][0]);

        Map<Integer, Integer> collection = new HashMap();
        for (int i = 2; i <= rows; i++) {
            collection.putAll(calculate(a, i, rows, cols, threshold));
        }

        System.out.println(collection);
        int max = -1;
        for (Integer i : collection.values()) {
            if (i > max) {
                max = i;
            }
        }

        System.out.println(max);
    }


    public static Map<Integer, Integer> calculate(int[][] a, int range, int rows, int cols, int threshold) {
        Map<Integer, Integer> map = new HashMap(Math.max(rows, cols));
        for (int row = 0; row <= (rows - range); row++) {
            for (int col = 0; col <= (cols - range); col++) {
                int result = sumCut(a, row, col, range, threshold);
                System.out.println(result);
                if (result <= threshold) {
                    map.put(result, range);
                }
            }

        }
        return map;
    }
}
