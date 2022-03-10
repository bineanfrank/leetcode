package questionbank;

import java.util.ArrayList;
import java.util.List;

public class L589_叉树的前序遍历 {

    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPreorder(root, result);
        return result;
    }

    public List<Integer> doPreorder(Node root, List<Integer> result) {
        if (root == null) return result;
        result.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                doPreorder(node, result);
            }
        }
        return result;
    }
}


