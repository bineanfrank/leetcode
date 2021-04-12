package questionbank;

public class L154_寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else if (nums[middle] < nums[right]) {
                right = middle;
            } else {
                right -= 1;
            }
        }
        // left == right
        return nums[right];
    }
}
