package questionbank;

import java.util.HashMap;
import java.util.Map;

public class L560_和为K的子数组 {

    public static void main(String[] args) {
        L560_和为K的子数组 solution = new L560_和为K的子数组();
        int[] nums = new int[]{};
        int k = 8;
        System.out.println(solution.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preMap = new HashMap<>();
        int pre = 0; // 当前前缀和
        preMap.put(0, 1); // 前缀和为0的数组为1个
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i]; // [0...i] 前缀和

            // [0...i] - [0...j] = [i...j]
            // [i...j] =
            if (preMap.containsKey(pre - k)) {
                ans++;
            }
            preMap.put(pre, preMap.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
