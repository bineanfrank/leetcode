package questionbank;

public class L153_寻找旋转排序数组中的最小值 {

    // 假设n=nums.length
    // 旋转n次，则倒序，n+1次恢复原状
    // 1. 二分法找出旋转点
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] <= nums[right]) {
            // 原状,left即为最小值
            return nums[left];
        }

        // 二分找到分割点
        while (left < right) {
            int middle = (left + right + 1) / 2;
            if (nums[middle] >= nums[0]) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return nums[right + 1];
    }

    public int findMin1(int[] nums){
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

    public static void main(String[] args) {
        int res = new L153_寻找旋转排序数组中的最小值().findMin(new int[]{2, 1});
        System.out.println(res);
    }
}
