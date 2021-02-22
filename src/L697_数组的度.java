import com.sun.codemodel.internal.JDoLoop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L697_数组的度 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3, 3, 3, 1, 2, 1};
        int minLen = new L697_数组的度().findShortestSubArray2(nums);
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
        Map<Integer, int[]> window = new HashMap<>(); // 保存最大度的数字对应的子数组范围索引
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
            }
            if (maxDu <= oldDu + 1 || maxDu == Integer.MAX_VALUE) {
                numSet.add(nums[i]);
                if (window.containsKey(nums[i])) {
                    int[] index = window.get(nums[i]);
                    window.put(nums[i], new int[]{index[0], i});
                } else {
                    window.put(nums[i], new int[]{i, i});
                }
            }
            if (maxDu == Integer.MIN_VALUE) {
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

    public int findShortestSubArray2(int[] nums) {
        Map<Integer, Integer> du = new HashMap<>();
        Map<Integer, int[]> window = new HashMap<>(); // 保存所有数字对应的子数组范围索引
        int maxDu = 0;
        int minLen = nums.length;
        Set<Integer> numSet = new HashSet<>(); // 所有数字的度

        // 计算所有的度，并得到所有数字最大的度
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                int oldDu = du.get(nums[i]);
                // 更新度数
                du.put(nums[i], oldDu + 1);

                int j = window.get(nums[i])[0];
                window.put(nums[i], new int[]{j, i});

                // 如果该数字的度数比现有的大，说明这是目前最大的度数，那么此时
                // 最小子数组范围索引就是nums[i]对应的
                if (oldDu + 1 > maxDu) {
                    maxDu = oldDu + 1;
                    minLen = i - j + 1;
                } else if (maxDu == oldDu + 1) {
                    minLen = Math.min(i - j + 1, minLen);
                }
            } else {
                // 第一次出现数字 nums[i]
                // 将数字放入Set
                // 将该数字对应的度设置为1
                // 将该数字对应的最小子数组范围索引放入window，当前就nums[i]一个元素，所以放入[i,i]
                numSet.add(nums[i]);
                du.put(nums[i], 1);
                window.put(nums[i], new int[]{i, i});
                if (maxDu < 1) {
                    maxDu = 1;
                    minLen = 1;
                }
            }
        }
        return minLen;
    }

    // 使用静态数组的方式
    public int findShortestSubArray3(int[] nums) {
        int[] du = new int[50009];
        int[] begin = new int[50009];
        int[] end = new int[50009];
        int maxDu = 0;
        int minLen = nums.length;
        Set<Integer> numSet = new HashSet<>(); // 所有数字的度

        // 计算所有的度，并得到所有数字最大的度
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                int oldDu = du[nums[i]];
                // 更新度数
                du[nums[i]] =oldDu + 1;

                int j = begin[nums[i]];
                begin[nums[i]] = j;
                end[nums[i]] = i;

                // 如果该数字的度数比现有的大，说明这是目前最大的度数，那么此时
                // 最小子数组范围索引就是nums[i]对应的
                if (oldDu + 1 > maxDu) {
                    maxDu = oldDu + 1;
                    minLen = i - j + 1;
                } else if (maxDu == oldDu + 1) {
                    minLen = Math.min(i - j + 1, minLen);
                }
            } else {
                // 第一次出现数字 nums[i]
                // 将数字放入Set
                // 将该数字对应的度设置为1
                // 将该数字对应的最小子数组范围索引放入window，当前就nums[i]一个元素，所以放入[i,i]
                numSet.add(nums[i]);
                du[nums[i]] = 1;
                begin[nums[i]] = i;
                end[nums[i]] = i;
                if (maxDu < 1) {
                    maxDu = 1;
                    minLen = 1;
                }
            }
        }
        return minLen;
    }
}
