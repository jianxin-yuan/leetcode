package link;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/3/16 8:44 下午
 */
public class 回文链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }

    //思路1: 先将链表值存入一个数组,然后利用双指针判断数组是否为回文
    //时间复杂度O(n),空间复杂度O(n)
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start).equals(list.get(end))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }


    //思路2:先找出链表中间节点,然后翻转链表后半部分,最后利用2个指针head,mid比较值
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        ListNode midNode = endOfFirstHalf(head);
        midNode = reverse(midNode);

        while (head != null && midNode != null) {
            if (head.val != midNode.val) {
                return false;
            } else {
                head = head.next;
                midNode = midNode.next;
            }
        }
        return true;
    }

    //翻转链表
    private ListNode reverse(ListNode head) {
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


    //找出链表中间节点
    private ListNode endOfFirstHalf(ListNode head) {
        //快慢指针: 快指针每次移动2步,慢指针移动1步,当快指针到达末尾时,慢指针指向就是链表中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
