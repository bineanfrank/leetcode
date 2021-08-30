package questionbank;


import common.TreeNode;

public class L783_二叉搜索树节点最小距离 {

    private TreeNode pre = null;
    private int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return ans;
    }

    /**
     * 二叉搜索树的中序遍历是有序的，可以保存遍历当中的
     * 前序节点，计算每一对前后序节点之间，差值最小的那个就是答案
     * @param curNode
     */
    void inOrder(TreeNode curNode) {
        if (curNode == null) return;

        // 遍历左子树
        inOrder(curNode.left);

        // 遍历当前节点，计算与前序节点之间的差值
        if (pre != null) {
            ans = Math.min(ans, Math.abs(pre.val - curNode.val));
        }
        //  当前节点变为前序节点
        pre = curNode;

        // 遍历右子树
        inOrder(curNode.right);
    }
}
