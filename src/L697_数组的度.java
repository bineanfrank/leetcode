import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L697_数组的度 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3, 3, 1, 2, 1};
        int minLen = new L697_数组的度().findShortestSubArray1(nums);
        System.out.println(minLen);
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> du = new HashMap<>();
        Map<Integer, Integer> minLength = new HashMap<>();
        int maxDu = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int existsDu = du.getOrDefault(nums[i], 0);
            if (existsDu == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        // 度加1
                        int numDu = du.getOrDefault(nums[i], 0);
                        du.put(nums[i], numDu + 1);
                        maxDu = Math.max(maxDu, numDu + 1);
                        minLength.put(nums[i], j - i + 1);
                    }
                }
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : du.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == maxDu) {
                for (Map.Entry<Integer, Integer> entrySet : minLength.entrySet()) {
                    int len = entrySet.getValue();
                    int num = entrySet.getKey();
                    if (num == key) {
                        minLen = Math.min(minLen, len);
                    }
                }
            }
        }
        return minLen;
    }

    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> du = new HashMap<>();
        int maxDu = Integer.MIN_VALUE;
        Set<Integer> numSet = new HashSet<>(); // 所有度最高的数字

        // 计算所有的度，并得到所有数字最大的度
        for (int i = 0; i < nums.length; i++) {
            int oldDu = du.getOrDefault(nums[i], 0);
            du.put(nums[i], oldDu + 1);
            if (maxDu < oldDu + 1) {
                maxDu = oldDu + 1;
                // 更新了最大度数，相应的数字集合应该修改
                numSet.clear();
                numSet.add(nums[i]);
            } else if (maxDu == oldDu + 1) {
                numSet.add(nums[i]);
            }

            // 当前还没出现最高度
            if (maxDu == Integer.MIN_VALUE) {
                numSet.add(nums[i]);
                maxDu = 1;
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (Integer in : numSet) {
            int i = 0;
            while (nums[i] != in) {
                i++;
            }
            int j = nums.length - 1;
            while (nums[j] != nums[i] && j > i) {
                j--;
            }
            minLen = Math.min(minLen, j - i + 1);
        }
        return minLen;
    }
}
