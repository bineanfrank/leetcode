public class L4_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,2};
        int[] nums2 = new int[]{};
        System.out.println(new L4_寻找两个正序数组的中位数().findMedianSortedArrays1(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 && n == 0) {
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
        int i = 0;
        int j = 0;
        int k = 0;
        boolean o = (m + n) % 2 == 0;
        int index1 = -1;
        if (o) {
            index1 = (m + n) / 2;
        }
        int index2 = (m + n) / 2 + 1;
        int curNum = -1;
        int mNum = -1;
        int nNum = -1;
        int[] kList = new int[nums1.length + nums2.length];
        while (i < m || j < n) {
            if (i < m && j < n && nums1[i] <= nums2[j]) {
                curNum = nums1[i];
                i++;
            } else if (j < n) {
                curNum = nums2[j];
                j++;
            }
            kList[k] = curNum;
            k++;

            if (o) {
                if (k == index1) {
                    mNum = curNum;
                } else if (k == index2) {
                    nNum = curNum;
                    break; // 找到了两个数
                }
            } else {
                if (k == index2) {
                    return curNum * 1.0f;
                }
            }
        }
        return (mNum + nNum) * 1.0f / 2;
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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
//        int[] kList = new int[m + n];
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
//                kList[k] = x;
                cur = x;
                i++;
            } else {
//                kList[k] = y;
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
