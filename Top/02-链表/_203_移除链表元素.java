/**
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
 * 
 */

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;
        // 新链表的头结点和尾结点,使用虚拟头结点进行优化
        ListNode newHead = new ListNode(0), newTail = newHead;
        while (head != null) {

            if (head.val != val) {
                // 保证当前链表连贯性以后,并重新挪动newTail位置
                // newTail.next = head;
                // newTail = head;
                newTail = newTail.next = head;
            }
            head = head.next;
        }
        // 重新给尾节点指向
        newTail.next = null;
        return newHead.next;
    }
}