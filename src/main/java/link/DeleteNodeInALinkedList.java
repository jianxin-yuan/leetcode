package link;

/**
 * @author yuan
 * @date 2020/3/14 11:17 上午
 *
 * 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/shan-chu-lian-biao-zhong-de-jie-dian-by-leetcode/
 * <p>
 * <p>
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 * <p>
 * 从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，使其指向之后的节点。
 * 因为，我们无法访问我们想要删除的节点 之前 的节点，我们始终不能修改该节点的 next 指针。
 * 相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
 * 因为我们知道要删除的节点不是列表的末尾，所以我们可以保证这种方法是可行的。
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}



