/**
 * Created by Harlan1994 on 2018/12/21.
 */
public class L27_移除元素 {

    public static void main(String[] args) {
        L27_移除元素 l27_移除元素 = new L27_移除元素();

        int[] ints = new int[]{1, 2, 2, 3, 4, 5, 6};
        int result = l27_移除元素.removeElement2(ints, 2);
        System.out.println(result);
    }

    public int removeElement(int[] nums, int val) {
        int i = -1, j = 0;
        while (j < nums.length && nums[j] != val) {
            j++;
        }
        if (j == nums.length) return j;
        i = j + 1;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j++] = nums[i++];
            } else {
                i++;
            }
        }
        return j;
    }

    public int removeElement2(int[] nums, int val) {
        if (nums.length <= 0) return 0;
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
