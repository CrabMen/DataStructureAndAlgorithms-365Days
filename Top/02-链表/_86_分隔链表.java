/**
 * 
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 示例:
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3 输出: 1->2->2->4->3->5
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// 要求 时间复杂度 O(n),空间复杂度O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {

        if (head == null)
            return null;
        ListNode lHead = new ListNode(0), lTail = lHead;
        ListNode rHead = new ListNode(0), rTail = rHead;

        while (head != null) {
            if (head.val < x)
                lTail = lTail.next = head;
            else
                rTail = rTail.next = head;

            head = head.next;
        }

        /**
         * 这句代码很重要,可能会出现以下情况:
         * 
         * 原链表倒数第N个节点A的值是>=x的,A后面所有节点的值都是<x的
         * 
         * 然后rTail.next最终其实就是A.next
         */
        rTail.next = null;
        lTail.next = rHead.next;

        return lHead.next;

    }
}