public class L303_区域和检索_数组不可变 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        new NumArray(nums).sumRange(0, 2);
    }

    static class NumArray {
        private int[] nums;
        private int[] sumsArray;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.sumsArray = new int[this.nums.length + 1];
            for (int i = 0; i < this.nums.length; i++) {
                this.sumsArray[i + 1] = this.sumsArray[i] + this.nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return this.sumsArray[j + 1] - this.sumsArray[i];
        }
    }
}
