public class RegionArea {
    static int[][] a = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
    static boolean[][] isVisited = new boolean[a.length][a[0].length];
    static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (!isVisited[i][j] && a[i][j] == 1) {
                    connectRegion(i, i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    public static void connectRegion(int m, int n) {
        if (n >= a[0].length || m >= a.length) {
            return;
        }
        while (m < a.length && n < a[0].length && a[m][n] != 0) {
            if (!isVisited[m][n]) {
                isVisited[m][n] = true;
                connectRegion(m, n + 1);
            }
            m++;
        }
    }
}
