package link;

/**
 * @author yuan
 * @date 2020/3/24 15:15
 *
 * 返回倒数第k个节点
 */
public class KthNodeFromEndOfListLcci {

    /**
     * 快慢指针:快指针先移动K,然后同时移动,快指针到末尾是慢指针就是目标点
     */
    public int kthToLast2(ListNode head, int k) {
        if (head == null) return 0;
        ListNode slow = head, fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;

    }

}
