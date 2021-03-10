package questionbank;

import java.util.Arrays;

public class L832_翻转图像 {

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] res = new L832_翻转图像().flipAndInvertImage1(A);
        System.out.println(Arrays.toString(res));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            // 水平翻转
            int l = 0;
            int r = A[i].length - 1;
            while (l < A[i].length / 2) {
                if (A[i][l] != A[i][r]) {
                    int tmp = A[i][l];
                    A[i][l] = A[i][r];
                    A[i][r] = tmp;
                }
                l++;
                r--;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
        return A;
    }

    // 情况一：A[i][l]=0,A[i][r]=0A[i][l]=0,A[i][right]=0。
        // 对第 ii 行进行水平翻转之后，A[i][l]=0,A[i][r]=0A[i][l]=0,A[i][right]=0。
        // 进行反转之后，A[i][l]=1,A[i][r]=1A[i][l]=1,A[i][right]=1。
    // 情况二：A[i][l]=1,A[i][r]=1A[i][l]=1,A[i][right]=1。
        // 对第 ii 行进行水平翻转之后，A[i][l]=1,A[i][r]=1A[i][l]=1,A[i][right]=1。
        // 进行反转之后，A[i][l]=0,A[i][r]=0A[i][l]=0,A[i][right]=0。
    // 情况三：A[i][l]=0,A[i][r]=1A[i][l]=0,A[i][right]=1。
        // 对第 ii 行进行水平翻转之后，A[i][l]=1,A[i][r]=0A[i][l]=1,A[i][right]=0。
        // 进行反转之后，A[i][l]=0,A[i][r]=1A[i][l]=0,A[i][right]=1。
    // 情况四：A[i][l]=1,A[i][r]=0A[i][l]=1,A[i][right]=0。
        // 对第 ii 行进行水平翻转之后，A[i][l]=0,A[i][r]=1A[i][l]=0,A[i][right]=1。
        // 进行反转之后，A[i][l]=1,A[i][r]=0A[i][l]=1,A[i][right]=0。
    public int[][] flipAndInvertImage1(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int l = 0;
            int r = A[i].length - 1;
            while (l < r) {
                // 1->0, 0->1
                // 1 ^ 1 = 0, 0 ^ 1 = 1
                // 抑或操作：相同为0，不同为1
                // 如果 A[i][l] != A[i][r], 那么经过翻转然后反转两次操作后，A[i][l]，A[i][r]不变
                // 所以这里只需要在A[i][l] == A[i][r]进行变化操作，结果就是翻转然后反转两次操作的结果
                if (A[i][l] == A[i][r]) {
                    A[i][l] ^= 1;
                    A[i][r] ^= 1;
                }
                l++;
                r--;
            }
            // 如果是奇数，那么最后 l == r, 上面的循环会跳出，从而忽略了l == r的情况
            // 如果是奇数，那么中间这个数，水平翻转不会变，反转会变，所以一定会变
            if (l == r) {
                A[i][l] ^= 1;
            }
        }
        return A;
    }
}
