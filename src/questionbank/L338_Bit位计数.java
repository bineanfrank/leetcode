package questionbank;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/18
 * Time: 11:14
 * Description:给定一个非负整数 num。 对于范围 0 ≤ i ≤ num 中的每个数字 i ，计算其二进制数中的1的数目并将它们作为数组返回。
 * <p>
 * Solution: 一个大于0的数对应的二进制和其自身减去1的数相与会使得自身的一个低位1消失，那么每次都这么做的话就可以计算出1的位数了
 * 注：当给定的数是一个负数的时候，由于计算机表示二进制
 */
public class L338_Bit位计数 {

    public static void main(String[] args) {
        String binary = Integer.toBinaryString(56);
        System.out.println(binary);
    }

    public int[] countBits(int num) {
        int[] counts = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                count++;
                temp = temp & (temp - 1);
            }
            counts[i] = count;
        }

        return counts;
    }

    public int[] countBits2(int num) {
        int[] counts = new int[num + 1];
        counts[0] = 0;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 1) { // 奇数
                counts[i] = counts[i - 1] + 1;
            } else {
                counts[i] = counts[i / 2];
            }
        }
        return counts;
    }
}
