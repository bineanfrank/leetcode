package dynamic_programming;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/7/18
 * Time: 11:39
 * Description: 给定一个字符串，求它的最长回文子串的长度。
 * Solution: 如果一段字符串是回文，那么以某个字符为中心的前缀和后缀都是相同的，例如以一段回文串“aba”为例，以b为中心，它的前缀和后缀都是相同的，都是a。
 * 那么，我们是否可以可以枚举中心位置，然后再在该位置上用扩展法，记录并更新得到的最长的回文长度呢？答案是肯定的，参考代码如下：
 */
public class L5_最长回文子串 {

    public static void main(String[] args) {
        L5_最长回文子串 l5_最长回文子串 = new L5_最长回文子串();
        String result = l5_最长回文子串.longestPalindrome("abb");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        int max, c = -1;
        int max_i, max_j;
        if (s == null || s.length() <= 0) return "";

        max = 0;

        int length = s.length();

        for (int i = 0; i < length; i++) {
            for (int j = 0; (i - j >= 0) && (i + j < length); j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                c = j * 2 + 1;
            }
            if (c > max) {
                max = c;
            }
        }
    }
}
