package questionbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90_子集2 {

    private List<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(0, nums);
        return res;
    }

    void backtrace(int index, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrace(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new L90_子集2().subsetsWithDup(new int[]{1, 2, 2});
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
