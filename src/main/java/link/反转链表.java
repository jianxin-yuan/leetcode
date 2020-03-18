package link;

/**
 * @author yuan
 * @date 2020/3/14 1:11 下午
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 */
public class 反转链表 {


    //递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

}
