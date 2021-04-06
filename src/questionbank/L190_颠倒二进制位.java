package questionbank;

public class L190_颠倒二进制位 {

    // you need treat n as an unsigned value
    // res = 0，每次获取 n 最后一位，拼接到res后面，然后n右移
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // res左移一位（0补位）,然后或运算将n的最后一位补在res最后一位(即刚出来的0位置)
            res = (res << 1) | (n & 1);
            // n右移动一位（无符号右移，前面补0）
            // 这里之所以用无符号，是因为翻转操作无关数学计算，只是要把二进制字符串翻转过来而已
            // 无符号右移，高位补0，低位去掉
            n >>>= 1;

            // 等同于
            // res = res * 2 + n % 2; // 10进制乘上10，模10；二进制改成2即可
            // n = n / 2; // 从十进制的10改成2即可
        }
        return res;
    }

    // res = 0，每次获取 n 最后一位，拼接到res后面，然后n右移
    public int reverseBits1(int n) {
        // 先分成两段交换
        // 例如：10101010 11111111 00000000 00000000
        // 交换后：00000000 00000000 10101010 11111111
        // 再将这两段再分别分成两端再交换：00000000 00000000 11111111 10101010
        // 如此下去，直到只分开后只有一位，再做交换

        // 分成两半，再交换
        n = (n >>> 16) | (n << 16);

        // 前16位的前8位 后16位的前8位 ｜ 前16位的后8位，后16位的后8位
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        // 左移
        int a = 8;
        System.out.println(a >>= 1);
        a = -8;
        System.out.println(a >>= 1);
        a = -8;
        System.out.println(a >>>= 1);
        a = 8;
        System.out.println(a);
    }
}


