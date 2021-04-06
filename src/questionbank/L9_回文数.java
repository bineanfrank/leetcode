package questionbank;

public class L9_回文数 {
    public boolean isPalindrome(int x) {
        int res = 0;
        int result = x;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == result;
    }

    public static void main(String[] args) {
        System.out.println(new L9_回文数().isPalindrome(-121));
    }
}
