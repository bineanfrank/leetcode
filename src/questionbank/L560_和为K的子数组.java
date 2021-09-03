package questionbank;

import java.util.HashMap;
import java.util.Map;

public class L560_和为K的子数组 {

    public static void main(String[] args) {
        L560_和为K的子数组 solution = new L560_和为K的子数组();
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        System.out.println(solution.subarraySum3(nums, k));
    }

    /**
     * preSum[i] 表示 [0-i] 的和
     * preSum[j] 表示 [0-j] 的和
     * preSum[i+1]-preSum[j] 表示 [j-i] 的和
     * 枚举所有子数组[j-i]，计算 preSum[i+1]-preSum[j] == k 即可统计所有情况
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        if (n <= 0) {
            return -1;
        }
        int[] preSum = new int[n + 1];
        preSum[0] = 0; // preSum[i] -> [0...i-1]
        preSum[1] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // preSum[i+1] -> [0-i]
        // preSum[j+1] -> [0-j]
        // [j-i] -> preSum[i+1] preSum[j]
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                // 枚举所有子数组的和
                int ijSum = preSum[i + 1] - preSum[j]; // [i...j]
                if (ijSum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 从 left 到 right, 枚举所有子数组，计算出它们的和
     * 判断是否等于k，统计所有情况即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            int sum = 0;
            // 枚举0-right所有的情况
            for (int left = right; left >= 0; left--) {
                sum += nums[left];
                // 在for循环里面，就可以判断当前枚举的子数组 [left,right]的和是否=k
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * preSum[i] -> [0,i]
     * 前面的解法都是枚举所有的子数组，计算它们的和，然后判断是否等于k，等于k的就ans++
     * 也就是当前枚举的子数组[i,j]满足：preSum[i,j] = preSum[i]-preSum[j-1] = k
     * 经过变形得到满足： preSum[j-1] = preSum[i] - k即可
     * <p>
     * 解体思路：
     * 我们通过从左往右，不停的计算preSum[i]，也就是前缀和，然后保存到hash表中
     * hash表的key用前缀和表示，value用出现的次数表示，
     * 计算过程中，我们要统计的所有子数组的和=k的，也就是要计算
     * [0,i]的所有子数组中，和=k的
     * 也就是 0<=j<=i 时，preSum[i] - preSum[j] = k
     * 也就相当于统计满足 preSum[j] = preSum[i] - k 的，满足则ans++
     * 这个算式中因为j<=i，也就是如果前面有满足前缀和=preSum[i]-k的就ans++
     * 这个前面，就等于枚举了所有j的情况，因为已经计算过，放入hash表中了
     * <p>
     * 当 preSum[i] == k 也就是 前缀和等与k时，
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        Map<Integer, Integer> preMap = new HashMap<>();
        int preSum = 0; // 当前前缀和
        int ans = 0;
        preMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i]; // 计算当前前缀和
            // preSum - k = preSum[j]
            if (preMap.containsKey(preSum - k)) {
                ans += preMap.get(preSum - k);
            }
            preMap.put(preSum, preMap.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
