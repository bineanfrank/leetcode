package questionbank;

import java.util.ArrayList;
import java.util.List;

public class L46_全排列 {

    public static void main(String[] args) {
        L46_全排列 l46_全排列 = new L46_全排列();
        List<List<Integer>> permute = l46_全排列.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, visited, path, res);
        return res;
    }

    public void helper(int[] nums, boolean[] visited,
                       List<Integer> path, List<List<Integer>> res) {

        // 如果path长度和nums一样，说明已经完成一组枚举
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                // 没有遍历到，加入路径中
                visited[i] = true;
                path.add(nums[i]);

                // 继续递归，深度搜索树
                helper(nums, visited, path, res);

                // 回溯时，要把之前的选择去除
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
