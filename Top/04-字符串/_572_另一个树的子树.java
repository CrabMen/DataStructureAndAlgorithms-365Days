import javax.swing.tree.TreeNode;

/**
 * 
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4 
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subtree-of-another-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

/**
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

class Solution {

    /**
     * 前序遍历 后序遍历 层序遍历(不建议)因为遍历节点不需要兄弟节点,而是遍历子节点
     * 
     * 通过二叉树序列化并通过字符串包含解决
     * 
     * ◼ 非空节点:值
     * 
     * ◼ 空节点也必须要序列化，才能完整地表达唯一的一棵树
     * 
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
        return postSerialize(s).contains((postSerialize(t)));
    }

    /**
     * 利用后序遍历的方式进行序列化
     * 
     * @param root
     * @return
     */
    private String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();//如果是前序遍历的话可以初始化的时候使用一个符号 防止误判(12 2 )
        postSerialize(root, sb);
        return sb.toString();
    }

    private void postSerialize(TreeNode node, StringBuilder sb) {
      
        if (node.left == null) {
            sb.append("#!");
        } else {
            postSerialize(node.left, sb);
        }
        if (node.right == null) {
            sb.append("#!");
        } else {
            postSerialize(node.right, sb);
        }
        sb.append(node.val).append("!");//如果是前序遍历 则放到最前
    }

}
