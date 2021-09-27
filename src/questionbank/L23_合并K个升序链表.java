package questionbank;

import java.util.PriorityQueue;

public class L23_合并K个升序链表 {

    /**
     * 按从大大小的顺序排列
     */
    public class ListNode implements Comparable<ListNode> {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public int compareTo(ListNode o) {
            return this.val - o.val;
        }
    }

    class Node implements Comparable<Node> {
        int val;
        ListNode ptr;

        public Node(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        if (lists == null) return res;
        int listNum = lists.length;
        /**
         * 优先队列中存放的是每一个列表当前指针指向的项，并且是从小到达排好序的
         */
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < listNum; i++) {
            if (lists[i] != null) {
                priorityQueue.offer(new Node(lists[i].val, lists[i]));
            }
        }
        ListNode tail = res;
        while (!priorityQueue.isEmpty()) {
            Node ptr = priorityQueue.poll(); // 最小的
            tail.next = ptr.ptr;
            tail = tail.next;

            // 将此列表的下一项放到优先队列中
            if (ptr.ptr.next != null) {
                priorityQueue.offer(new Node(ptr.ptr.next.val, ptr.ptr.next));
            }
        }
        return res.next;
    }
}
