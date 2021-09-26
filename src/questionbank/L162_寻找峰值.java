package questionbank;

public class L162_寻找峰值 {

    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int right = n - 1;
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
