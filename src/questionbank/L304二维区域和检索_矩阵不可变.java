package questionbank;

public class L304二维区域和检索_矩阵不可变 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix m = new NumMatrix(matrix);
        int re1 = m.sumRegion(2, 1, 4, 3);
        int re2 = m.sumRegion(1, 1, 2, 2);
        int re3 = m.sumRegion(1, 2, 2, 4);
        System.out.println(re1);
        System.out.println(re2);
        System.out.println(re3);
    }

    static class NumMatrix {
        private int[][] matrix;
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            if(matrix.length > 0) {
                preSum = new int[matrix.length + 1][matrix[0].length + 1];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        preSum[i + 1][j + 1] = matrix[i][j] + preSum[i][j];
                        int index = i - 1;
                        while (index >= 0) {
                            preSum[i + 1][j + 1] += matrix[index][j];
                            index--;
                        }
                        index = j - 1;
                        while (index >= 0) {
                            preSum[i + 1][j + 1] += matrix[i][index];
                            index--;
                        }
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(this.matrix.length > 0) {
                return preSum[row2 + 1][col2 + 1] - (preSum[row2 + 1][col1] + preSum[row1][col2 + 1]) + preSum[row1][col1];
            }
            return 0;
        }
    }
}
