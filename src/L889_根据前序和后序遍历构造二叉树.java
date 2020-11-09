public class L889_根据前序和后序遍历构造二叉树 {


    /**
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solution/kan-wo-jiu-gou-liao-san-chong-bian-li-fang-shi-gou/
     *
     * @param pre
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length <= 0 || post.length <= 0) return null;
        return doConstructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode doConstructFromPrePost(int[] pre, int[] post, int preLeft,
                                            int preRight, int postLeft, int postRight) {

        // 不能一直递归下去呀
        if (preLeft > preRight || postLeft > postRight) return null;

        // 创建当前root节点
        TreeNode root = new TreeNode(pre[preLeft]);

        // 递归到了最后，返回
        if (preLeft == preRight) return root;

        // 前 + 后中，前序preLeft + 1节点是后序的最后一个节点，也就是下一轮的root节点
        int leftFirst = pre[preLeft + 1];
        int index = -1;
        for (int i = postLeft; i <= postRight; i++) {
            if (leftFirst == post[i]) {
                index = i;
                break;
            }
        }
        root.left = doConstructFromPrePost(pre, post, preLeft + 1,
                preLeft + (index - postLeft + 1), postLeft, index);
        root.right = doConstructFromPrePost(pre, post, preLeft + (index - postLeft + 1) + 1,
                preRight, index + 1, postRight - 1);

        return root;
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode treeNode = new L889_根据前序和后序遍历构造二叉树().constructFromPrePost(pre, post);
    }

}
