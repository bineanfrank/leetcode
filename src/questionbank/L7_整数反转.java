package questionbank;

public class L7_整数反转 {

    // Integer.MAX_VALUE=2^31-1=2147483647
    // Integer.MIN_VALUE=-2^31=-2147483648
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        int res = 0;
        while (x != 0) {
            int lastNum = x % 10;
            // 1. 循环继续，说明lastNum还有非0值，如果res>214748364
            // 那么不论lastNum是多少，res最终都会大于Integer.MAX_VALUE
            // 2. 如果res=214748364，那么最终结果取决与lastNum
            // 如果lastNum>7,说明最终结果大于Integer.MAX_VALUE
            if (res > 214748364 || (res == 214748364 && lastNum > 7)) {
                return 0;
            }

            // 1. 循环继续，说明lastNum还有非0值，如果res<-214748364
            // 那么不论lastNum是多少，res最终都会小于Integer.MIN_VALUE
            // 2. 如果res=214748364，那么最终结果取决与lastNum
            // 如果lastNum>7,说明最终结果大于Integer.MAX_VALUE
            if (res < -214748364 || (res == -214748364 && lastNum < -8)) {
                return 0;
            }

            // 获取x最后一位
            res = res * 10 + lastNum;

            // x向右移动一位，即去掉个位
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        new L7_整数反转().reverse(1534236469);
    }
}
