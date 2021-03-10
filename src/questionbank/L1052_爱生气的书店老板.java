package questionbank;

public class L1052_爱生气的书店老板 {

    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        int res = new L1052_爱生气的书店老板().maxSatisfied1(customers, grumpy, x);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int maxNotMad = 0;
        for (int i = 0; i < customers.length - (X - 1); i++) {
            int curNotMad = 0;
            for (int j = 0; j < X; j++) {
                curNotMad += customers[i + j] * grumpy[i + j];
            }
            maxNotMad = Math.max(curNotMad, maxNotMad);
        }
        int res = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        return res + maxNotMad;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int maxIncrease = 0;
        for (int i = 0; i < X; i++) {
            maxIncrease += customers[i] * grumpy[i];
        }
        int increase = maxIncrease;
        // 窗口从 第二个 位置开始滑动，i表示窗口最后一个位置的下一位
        for (int i = X; i < customers.length; i++) {
            // 滑动窗口到i, i - X 被移出窗口，减去i - X的数，并加上当前i位置的数
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(increase, maxIncrease);
        }
        int res = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        return res + maxIncrease;
    }
}
