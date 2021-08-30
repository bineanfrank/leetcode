package questionbank;

public class L300_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            max = Math.max(lis[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        new L300_最长递增子序列().lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
}
