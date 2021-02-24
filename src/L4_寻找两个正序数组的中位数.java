public class L4_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,2};
        int[] nums2 = new int[]{};
        System.out.println(new L4_寻找两个正序数组的中位数().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 && n == 0){
            return 0;
        }
        if (m == 0) {
            return n % 2 == 0 ? (nums2[n / 2] + nums2[n / 2 - 1]) * 1.0f / 2 : nums2[n / 2];
        }
        if (n == 0) {
            return m % 2 == 0 ? (nums1[m / 2] + nums1[m / 2 - 1]) * 1.0f / 2 : nums1[m / 2];
        }
        if (m == 1 && n == 1) {
            return (nums1[0] + nums2[0]) / 2.0f;
        }

        boolean isOld = (m + n) % 2 == 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int pre = -1;
        int next = -1;
        int cur;
        while (i < m || j < n) {
            int x = i == m ? Integer.MAX_VALUE : nums1[i];
            int y = j == n ? Integer.MAX_VALUE : nums2[j];
            if (x < y) {
                cur = x;
                i++;
            } else {
                cur = y;
                j++;
            }
            k++;
            if (isOld) {
                if (k == (m + n) / 2) {
                    pre = cur;
                }
                if (k == (m + n) / 2 + 1) {
                    next = cur;
                    break;
                }
            } else {
                if (k == (m + n) / 2 + 1) {
                    pre = cur;
                    next = cur;
                    break;
                }
            }
        }
        return (pre + next) / 2.0f;
    }
}
