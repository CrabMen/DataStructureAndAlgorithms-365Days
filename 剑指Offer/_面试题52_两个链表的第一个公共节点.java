import java.util.HashMap;

/**
 * 如果两个链表没有交点，返回 null. 在返回结果后，两个链表仍须保持原有的结构。 可假定整个链表结构中没有循环。 程序尽量满足 O(n)
 * 时间复杂度，且仅用 O(1) 内存。 本题与主站 160
 * 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNode_doublePointer(headA, headB);
    }

    static ListNode getIntersectionNode_doublePointer(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        // A+B 和B+A 路程一致
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        return pointerA;
    }

    static ListNode getIntersectionNode_map(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        HashMap<ListNode,ListNode> map = new HashMap<>();

        while (nodeA != null) {
            map.put(nodeA, nodeA.next);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            if (map.containsKey(nodeB))
                return nodeB;
            nodeB = nodeB.next;
        }
        return null;
    }

}