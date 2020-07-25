public class SolutionMatrixRotate {

    public static void rotate(int[][] matrix) {
            int[][] ans = new int[matrix[0].length][matrix[0].length];
            int length = matrix[0].length;

            for (int i = 0; i < length; i++) {
                for (int j = length - 1; j >= 0; j--) {
                    ans[i][length-j-1] = matrix[j][i];
                }
            }

            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = ans[i][j];
                    System.out.print(matrix[i][j] + ",");
                }
                System.out.println();
            }
        }

    public static void main(String[] args) {
        rotate(new int [][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
