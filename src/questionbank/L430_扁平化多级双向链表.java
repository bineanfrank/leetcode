package questionbank;

public class L430_扁平化多级双向链表 {


    // Definition for a Node.
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    static Node root = new Node();
    static Node p = root;

    public static void main(String[] args) {
        L430_扁平化多级双向链表 solution = new L430_扁平化多级双向链表();
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.next.val = 2;
        head.next.next = new Node();
        head.next.next.val = 3;
        head.next.next.next = new Node();
        head.next.next.next.val = 4;

        head.next.child = new Node();
        head.next.child.val = 5;

        head.next.child.next = new Node();
        head.next.child.next.val = 6;

        head.next.child.next.next = new Node();
        head.next.child.next.next.val = 7;

        head.next.next.next.child = new Node();
        head.next.next.next.child.val = 8;

        head.next.next.next.child.next = new Node();
        head.next.next.next.child.next.val = 9;

        Node flatten = solution.flatten(head);
        System.out.println(flatten);
    }


    public Node flatten(Node head) {
        // 要初始化，否则提交时是多个案例一起执行，会有上一个case的数据
        root = new Node();
        p = root;
        if (head == null) return null;
        dfs(head);
        Node q = p.next;
        q.prev = null;
        return q;
    }

    public void dfs(Node head) {
        if (head == null) {
            return;
        }
        root.next = new Node();
        root.next.prev = root;
        root.next.val = head.val;
        root.next.child = null;
        root = root.next;
        root.child = null;
        dfs(head.child);
        dfs(head.next);
    }
}
