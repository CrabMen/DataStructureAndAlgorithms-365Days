import apple.laf.JRSUIUtils.Tree;

/**
 * 二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
进阶:

使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/recover-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */
/***
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 二叉树的中序遍历 结果是升序的
 * 
 * 如果交换的是挨在一起的节点,交换结果中会出现唯一的一组逆序对
 * 
 * 如果不是挨在一起的节点,中序遍历的结果会出现两个逆序对 第一个逆序对中较大的节点和第二个逆序对中较小的节点.
 * 
 */
class Solution {
    // 上一次中序遍历的节点
    private TreeNode prev;
    // 第一个错误节点
    private TreeNode first;
    // 第二个错误节点
    private TreeNode second;

    public void recoverTree_center(TreeNode root) {
        findWrongNodes(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null)
            return;
        findWrongNodes(root.left);
        find(root);
        findWrongNodes(root.right);
    }

    /**
     * 使用 O(n) 空间复杂度的解法很容易实现。
     * 
     * 你能想出一个只使用常数空间的解决方案吗？
     * 
     * 上方对二叉树的中序遍历,空间复杂度为O(h) h代表树高,最坏空间复杂度为O(n)
     *
     * 
     * 二叉树的Morris遍历
     * 
     * 线索二叉树 实现空间复杂度为O(1)
     */
    public void recoverTree(TreeNode root) {
        morrisInorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void find(TreeNode root) {
        if (prev != null && prev.val > root.val) {
            second = root;
            if (first != null)
                return;
            first = prev;
        }
        prev = root;
    }

    private void morrisInorder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else {// pred.right == node
                    // 将线断掉
                    // System.out.println(node.val);
                    find(node);
                    pred.right = null;
                    node = node.right;
                }

            } else {
                // System.out.println(node.val);
                find(node);
                node = node.right;
            }
        }
    }

}