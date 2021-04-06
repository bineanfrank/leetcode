package questionbank;

public class L74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m <= 0) return false;
        int n = matrix[0].length;
        if (n <= 0) return false;

        // 定位在哪一行
        for (int i = 0; i < m; i++) {
            int leftV = matrix[i][0];
            int rightV = matrix[i][matrix[i].length - 1];
            if (target < leftV) return false;
            else if (target == leftV) return true;
            else if (target > leftV && target < rightV) return contains(matrix[i], target);
            else if (target == rightV) return true;
            else {
                // target > rightV, continue next line
            }
        }
        return false;
    }

    // 二分法查找目标值
    public boolean contains(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (target == array[middle]) {
                return true;
            } else if (target < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}
