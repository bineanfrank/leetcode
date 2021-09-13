package questionbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47_全排列2 {

    public static void main(String[] args) {
        L47_全排列2 l47 = new L47_全排列2();
        List<List<Integer>> permute = l47.permuteUnique(new int[]{1, 2, 3});
        System.out.println(permute);
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
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
            /**
             * 用过了，剪枝
             */
            if (visited[i]) {
                continue;
            }
            /**
             * [1,1`,2]
             *
             * [1,1`,2]和[1`,1,2]是重复的，需要剪枝
             * 需要画出 DFS 图，判断哪里需要剪枝
             * 逻辑上就是，当前节点和上一个节点相同，但是上一个节点没有使用，也就是上一个节点没有被选择或者被取消选择
             * 其实上一个节点的visited状态被置为false，那肯定是被选择后，又被反选了（因为都已经到当前节点了，那么上一个节点肯定被"选择"过了），也就是路径中已经包含了
             * 所以此时如果当前节点和前一个节点相同，那么产生的路径和上一个节点产生的路径肯定是一模一样的，因为后续的选择是一样的
             *
             */
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
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
