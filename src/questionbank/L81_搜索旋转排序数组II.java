package questionbank;

public class L81_搜索旋转排序数组II {
    /**
     * 旋转之后，左边和右边依然是一个非递减序列，依然可以用二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return false;
        int k = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                k = i;
                break;
            }
        }
        return binarySearch(nums, target, 0, k - 1)
                || binarySearch(nums, target, k, nums.length - 1);

    }

    /**
     * 旋转的情况有两种
     * 1，旋转点为0,等于没有旋转
     * 2，旋转点为非0，那么必定有 nums[0] >= nums[nums.length-1]
     * 假设分割点为k(k>0)，那么nums[0->k] >= nums[k+1->nums.length-1]
     * 3，分割点如果是0，那么 nums[0] < nums[nums.length-1]
     * @param nums
     * @param target
     * @return
     */
    public boolean binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int middle = (right + left) / 2;
            if (nums[middle] == target) return true;
            else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new L81_搜索旋转排序数组II().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3);
        System.out.println(res);
    }
}
