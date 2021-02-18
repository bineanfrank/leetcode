public class L2_两数相加 {

    public static void main(String[] args) {
        L2_两数相加 in = new L2_两数相加();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);
        ListNode result = in.addTwoNumbers(l1, l2);

        System.out.println(result);
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = (l1.val + l2.val) / 10; // 进位标志
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode current = result;
        while (l1 != null && l2 != null) {
            current.next = new ListNode((l1.val + l2.val + c) % 10);
            c = (l1.val + l2.val + c) / 10;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            current.next = new ListNode((l1.val + c) % 10);
            c = (l1.val + c) / 10;
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            current.next = new ListNode((l2.val + c) % 10);
            c = (l2.val + c) / 10;
            current = current.next;
            l2 = l2.next;
        }
        if (c == 1) {
            current.next = new ListNode(c);
        }
        return result;
    }

    // 更简洁版本
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return new ListNode(0);

        ListNode tail1 = l1;
        ListNode tail2 = l2;

        ListNode result = new ListNode(0);
        ListNode tail = result;
        int c = 0;// 进位

        // 从头到尾开始想加，有进位的则进位
        while (tail1 != null || tail2 != null) {

            int x = tail1 == null ? 0 : tail1.val;
            int y = tail2 == null ? 0 : tail2.val;
            int a = (x + y + c) % 10;
            c = x + y + c >= 10 ? 1 : 0;

            tail.next = new ListNode(a);
            tail = tail.next;
            if (tail1 != null) tail1 = tail1.next;
            if (tail2 != null) tail2 = tail2.next;
        }

        // 算到最后还有进位
        if(c == 1) {
            tail.next = new ListNode(1);
        }

        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
