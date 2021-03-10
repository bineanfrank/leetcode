package questionbank;

import java.util.Deque;
import java.util.LinkedList;

public class L995_K连续位的最小翻转次数 {

    public int minKBitFlips(int[] A, int K) {
        Deque<Integer> queue = new LinkedList<>();
        int reverseTime = 0;

        // 从头到尾遍历数组
        for (int i = 0; i < A.length; i++) {

            // 模拟滑动窗口，如果队列不为空并且当前已经往后移动到下一个窗口了
            // 就需要将窗口往后移动一位，即将队头元素出队
            if (queue.size() > 0 && i > queue.peek() + K - 1) {
                queue.removeFirst();
            }

            // 如果前面是翻转了偶数次，那么最终不变，这时如果元素本来是0（经过偶数次翻转后为0），那么需要翻转
            // 如果前面翻转了奇数次，那么最终0->1,1->0，此时如果元素本来是1（经过奇数次翻转后为0），那么需要翻转
            // 奇数次翻转 queue.size() % 2 == 1，偶数次翻转 queue.size() % 2 == 0
            // if(queue.size() % 2 == 0 && A[i] == 0) -> 本来是0，偶数次翻转后变为0
            // if(queue.size() % 2 == 1 && A[i] == 1) -> 本来是1，奇数次翻转后变为0
            if (queue.size() % 2 == A[i]) {
                // 如果当前位置i后面不足K位，那在需要再次翻转的情况下，肯定是不能将所有位置翻转成1的
                if (i + K > A.length) return -1;
                reverseTime++; // 翻转次数增加，将当前元素位置放入队列
                queue.add(i);
            }
        }
        return reverseTime;
    }
}
