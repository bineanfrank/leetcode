package questionbank;

public class L371_两整数之和 {

    /**
     * 如果将两个值转化成二进制计算,那么每一位的运算是这样的：
     * 1) 0+0=0
     * 2) 1+0=1
     * 3) 0+1=1
     * 4) 1+1=0
     * <p>
     * 其实就是抑或运算，只有1+1是需要进位的，一种方法是使用二进制计算的方式计算加法
     * 就是从低到高每一位按照十进制的方式相加，有进位则进位
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int ans = 0;
        int t = 0;
        for (int i = 0; i < 32; i++) {

            // 取出当前位
            int a1 = (a >> i) & 1;
            int b1 = (b >> i) & 1;

            // 需要进位
            if (a1 == 1 && b1 == 1) {
                ans |= (t << i);
                t = 1; // 向前进位，进位后，ans当前位的值就是t
            } else if (a1 == 1 || b1 == 1) {
                // 当前值相加是1，所以取决于t是多少，确定下一位的计算t是多少
                // t=1, 那么需要进位，t依然等于1，t=0,不进位，t依然等于0
                ans |= ((t ^ 1) << i);
            } else {
                // 只需要加进位值即可
                ans |= (t << i);
                t = 0;
            }
        }
        return ans;
    }

    /**
     * 如果将两个值转化成二进制计算,那么每一位的运算是这样的：
     * 1) 0+0=0
     * 2) 1+0=1
     * 3) 0+1=1
     * 4) 1+1=0（有进位）
     * 也就是说除了 1+1，其余的都是异或操作，考虑进位操作的话
     * 异或并且加上进位后：a^b + ((a&b)<<1)
     * 如果没有进位，则加法就等于异或的结果，否则需要加上进位
     * 进位需要左移一位并加在结果里
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum1(int a, int b) {
        int sum = a, carry = b;
        while (carry != 0) {
            int temp = sum;
            sum = temp ^ carry;
            carry = (temp & carry) << 1;
        }
        return sum;
    }
}
