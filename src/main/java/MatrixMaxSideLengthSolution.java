public class MatrixMaxSideLengthSolution {

    public static void main(String[] args) {
        int[][] a1 = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int[][] a2 = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int[][] a3 = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int[][] a = {{1, 1, 1, 1}, {0, 1, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 1}};
        int[][] a4 = {{1, 1}, {1, 1}};

        System.out.println(maxSideLength(a, 2));
    }

    static int m, n;


    public static int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];

        int res = 0;
        int len = 1; // square side length

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];

            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println("----------------------> checking for i= "+i+" and j=" + j + " and len=" + len);
                if(i >= len && j >= len ) {
                    System.out.println("?? <== sum[" + i + "][" + j + "] - sum[" + i + " - "+len+"][" + j + "] - sum[" + i + "][" + j + " - " + len + "] + sum[" + i + " - "+ len + "][" + j + " - "+ len + "]");
                    int temp = sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len];
                    System.out.println(temp + " <== sum[" + i + "][" + j + "] - sum[" + i + " - "+len+"][" + j + "] - sum[" + i + "][" + j + " - " + len + "] + sum[" + i + " - "+ len + "][" + j + " - "+ len + "]");
                    if (sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len] <= threshold) {
                        res = len++;
                        System.out.println("increasing res "+ res + " with len " + len);
                    }
                }
            }
        }

        return res;
    }


}