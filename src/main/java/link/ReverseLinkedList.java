package link;

/**
 * @author yuan
 * @date 2020/3/14 1:11 下午
 * <p>
 * <p>
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 */
public class ReverseLinkedList {

    //递归
    public ListNode reverseList1(ListNode head) {
        //头结点为空,或者只有一个节点,直接返回
        if (head == null || head.next == null) return head;
        // 递归翻转head.next后续节点,返回的节点为新链表头结点
        ListNode newHead = reverseList1(head.next);
        // 头结点的下一节点翻转后为头结点的上一节点
        head.next.next = head;
        //头结点的next-> null
        head.next = null;
        return newHead;
    }


    // n1 - > n2 -> n3 -> null
    //prev = null,current = n1,
    //temp = n2 ,  n1->null, prev = n1, current = n2
    // temp = n3, n2-> n1, prev = n2, current = n3
    // temp = null, n3 -> n2, prev = n3, current =  null
    // return n3->n2->n1->null

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
