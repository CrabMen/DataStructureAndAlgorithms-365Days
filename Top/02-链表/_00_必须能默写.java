
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _00_必须能默写 {

    // 翻转链表 时间复杂度O(n),空间复杂度O(1)
    public  reverseList(ListNode head) {
        ListNode prev = null, tempNext = null;
        while (head != null) {
            tempNext = head.next;
            head.next = prev;
            prev = head;
            head = tempNext;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}