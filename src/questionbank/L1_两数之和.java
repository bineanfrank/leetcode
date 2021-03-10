package questionbank;

public class L1_两数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] res = new L1_两数之和().twoSum(nums, target);
        System.out.println(res);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
            j++;
        }
        return new int[]{-1, -1};
    }
}
