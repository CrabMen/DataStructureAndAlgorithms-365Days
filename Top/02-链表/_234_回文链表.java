/**
 * 
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2 输出: false 示例 2:
 * 
 * 输入: 1->2->2->1 输出: true 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
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
    /**
     * 找到前半部分链表的尾节点。
     * 
     * 反转后半部分链表。
     * 
     * 判断是否为回文。
     * 
     * 恢复链表。 
     * 
     * 返回结果。
     * 
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.next.next == null)
            return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);

        // 翻转右半部分（中间节点的右边部分）
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode rOldHead = rHead;
         
        // 从lHead、rHead出发，判断是否为回文链表
        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                result = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }

        // 恢复右半部分（对右半部分再次翻转）
        reverseList(rOldHead);
        return result;

    }

    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private reverseList(ListNode head) {
        ListNode prev = null, tempNext = null;
        while (head != null) {
            tempNext = head.next;
            head.next = prev;
            prev = head;
            head = tempNext;
        }
        return prev;
    }

}