package questionbank;

public class L766_托普利茨矩阵 {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1, 2, 3, 4},
//                {5, 1, 2, 3},
//                {9, 5, 1, 2}
//        };
        int[][] matrix = new int[][]{{39, 24}};
        boolean res = new L766_托普利茨矩阵().isToeplitzMatrix(matrix);
        System.out.println(res);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) return true;
        if ((m == 1 && n > 1) || (n == 1 && m > 1)) return true;

        for (int i = 0; i < m - 1; i++) {
            int tmp = matrix[i][0];
            int line = i + 1;
            int column = 1;
            while (column < n && line < m) {
                if (matrix[line][column] != tmp) {
                    return false;
                }
                line++;
                column++;
            }
        }

        for (int j = 1; j < n - 1; j++) {
            int tmp = matrix[0][j];
            int line = 1;
            int column = j + 1;
            while (column < n && line < m) {
                if (matrix[line][column] != tmp) {
                    return false;
                }
                line++;
                column++;
            }
        }

        return true;
    }
}
