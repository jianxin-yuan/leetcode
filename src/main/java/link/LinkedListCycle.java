package link;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/3/16 9:56 下午
 *
 * 环形链表
 */
public class LinkedListCycle {

    //思路1: 循环链表元素,将其加入set,如果发现set中已有,说明有环
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    //思路2: 快慢指针,快指针每次移动2步,慢指针移动1步,
    // 如果没有环,则快指针会先到达链表末尾
    // 如果有环,则最终快指针会追上慢指针(套圈)
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
