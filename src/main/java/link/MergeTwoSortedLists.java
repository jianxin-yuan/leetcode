package link;


/**
 * @author yuan
 * @date 2020/3/16 10:55
 * <p>
 *
 *     合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-list/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
 */
public class MergeTwoSortedLists {

    //递归
    public link.ListNode mergeTwolist2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwolist2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwolist2(l2.next, l1);
            return l2;
        }
    }

    //迭代
    public link.ListNode mergeTwolists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prevNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prevNode.next = l1;
                l1 = l1.next;
            } else {
                prevNode.next = l2;
                l2 = l2.next;
            }

            prevNode = prevNode.next;
        }

        //当l1为null时,将l2拼接到prev后,否则拼接l1
        prevNode.next = l1 == null ? l2 : l1;

        return dummy.next;


    }
}
