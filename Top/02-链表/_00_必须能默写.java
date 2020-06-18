import sun.security.krb5.internal.crypto.crc32;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _00_必须能默写 {

    // 翻转链表 时间复杂度O(n),空间复杂度O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, tempNext = null;
        while (head != null) {
            tempNext = head.next;
            head.next = prev;
            prev = head;
            head = tempNext;
        }
        return prev;
    }

    // 获取链表的中间节点
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 删除节点
    public ListNode removeElements(ListNode head, int val) {
        // 哨兵节点 伪节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, cur = head;

        while (cur != null) {
            if (cur.val == val)
                prev.next = cur.next;
            else
                prev = cur;
            cur = cur.next;
        }
        return sentinel.next;
    }

    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

}