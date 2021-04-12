package questionbank;


import java.util.Arrays;

public class L179_最大数 {

    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = nums[i] + "";
        }
        // 9+34 -> 34+9
        // 934 > 349
        Arrays.sort(numsStr, (number1, number2) -> (number2 + number1).compareTo(number1 + number2));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(numsStr[i]);
        }
        String result = stringBuilder.toString().replaceFirst("^0*", "");
        if (result.length() == 0) {
            return "0";
        }
        return result;
    }

    public static void main(String[] args) {
        String res = new L179_最大数().largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(res);
    }
}
