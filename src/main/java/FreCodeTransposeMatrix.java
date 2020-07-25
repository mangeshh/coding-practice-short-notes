public class FreCodeTransposeMatrix {

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transposeMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("i=" + i + " & j=" + j);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                printMatrix(matrix);
            }
        }
    }

    public static void main(String[] args) {
        int a[][] = new int[][]{{1, 0, 1}, {1, 0, 1}, {1, 0, 1}};
        transposeMatrix(a);
    }
}
