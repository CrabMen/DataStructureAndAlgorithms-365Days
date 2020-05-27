/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。   示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL  
 * 
 * 限制：
 * 
 * 0 <= 节点个数 <= 5000
 * 
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // return doublePointer(head);
        return recursive(head);
    }
    //方法一:双指针
    private ListNode doublePointer(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //方法二:递归
    private ListNode recursive(ListNode head) {
        // 递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 这里的cur就是最后一个节点
        ListNode cur = recursive(head.next);
        // 这里请配合动画演示理解
        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // 而head是4，head的下一个是5，下下一个是空
        // 所以head.next.next 就是5->4
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        // 每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

}