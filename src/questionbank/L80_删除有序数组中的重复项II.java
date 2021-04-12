package questionbank;

public class L80_删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1; // j始终指向当前数组的最后一个元素的后一位，即代表新数据的长度
        int tmp = nums[0]; // 记录当前元素
        int count = 1; // 重复次数，最多两次
        while (i < nums.length) {
            if (nums[i] == tmp) {
                count++;
                if (count <= 2) {
                    nums[j++] = tmp;
                }
            } else {
                tmp = nums[i];
                count = 1;
                nums[j++] = tmp;
            }
            i++;
        }
        return j;
    }

    public int removeDuplicates1(int[] nums) {
        return removeNDuplicates(nums, 2);
    }

    public int removeNDuplicates(int[] nums, int n) {
        if (nums == null || nums.length <= n) return nums == null ? 0 : nums.length;
        int k = n;
        for (int i = n; i < nums.length; i++) { // 从位置n开始
            if (nums[k - n] != nums[i]) nums[k++] = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        new L80_删除有序数组中的重复项II().removeDuplicates1(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 7, 7, 7});
    }
}
