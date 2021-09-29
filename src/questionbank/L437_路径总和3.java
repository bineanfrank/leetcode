package questionbank;

import java.util.HashMap;
import java.util.Map;

public class L437_路径总和3 {

    public static void main(String[] args) {

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        traverse(root, targetSum);
        return ans;
    }

    private void traverse(TreeNode root, int targetSum) {
        dfs(root, root.val, targetSum);
        if (root.left != null)
            traverse(root.left, targetSum);
        if (root.right != null)
            traverse(root.right, targetSum);
    }

    private void dfs(TreeNode root, int curSum, int targetSum) {
        if (curSum == targetSum) ans++;
        if (root.left != null)
            dfs(root.left, curSum + root.left.val, targetSum);
        if (root.right != null)
            dfs(root.right, curSum + root.right.val, targetSum);
    }

    // 保存更节点到当前节点路径的前缀和
    // key:前缀和，value:个数
    Map<Integer, Integer> pathSum = new HashMap<>();
    int ans2 = 0;

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        pathSum.put(0, 1); // 前缀和位0的路径节点有1个
        traverse2(root, targetSum, root.val);
        return ans2;
    }

    private void traverse2(TreeNode root, int targetSum, int val) {
        // val - targetSum 表示减去 targetSum 的距离，如果存在，说明存在一个节点
        // 使得当前节点到该节点距离和为 targetSum
        if (pathSum.containsKey(val - targetSum)) ans2 += pathSum.getOrDefault(val - targetSum, 0);
        pathSum.put(val, pathSum.getOrDefault(val, 0) + 1);
        if (root.left != null)
            traverse2(root.left, targetSum, val + root.left.val);
        if (root.right != null)
            traverse2(root.right, targetSum, val + root.right.val);
        pathSum.put(val, pathSum.getOrDefault(val, 0) - 1);
    }
}
