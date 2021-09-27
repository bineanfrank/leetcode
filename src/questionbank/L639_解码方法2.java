package questionbank;

public class L639_解码方法2 {

    /**
     * f[i] 表示以 s[i] 结尾的字符串最多的编码结果数
     * 那么结果是f[n-1] s[n-1]是s字符串最后一位字符
     * n表示s的长度
     * <p>
     * s[0] != 0
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[s.length()];
        // '*'，0-9
        char c = s.charAt(0);
        f[0] = '*' == c ? 9 : '0' == c ? 0 : 1;
        return 1;
    }
}
