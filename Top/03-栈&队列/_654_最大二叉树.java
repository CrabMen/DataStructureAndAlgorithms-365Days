
/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 
 * 二叉树的根是数组中的最大元素。 左子树是通过数组中最大值左边部分构造出的最大二叉树。 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：

给定的数组的大小在 [1, 1000] 之间。
 *  
 */
import java.util.Arrays;

class _654_最大二叉树 {

    public static void main(String[] args) {
        _654_最大二叉树 solution = new _654_最大二叉树();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        System.out.println(Arrays.toString(solution.parentIndexes(nums)));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null)
            return null;

        return findRoot(nums, 0, nums.length);

    }

    private TreeNode findRoot(int[] nums, int li, int ri) {
        if (li == ri)
            return null;
        int maxIdx = li;
        for (int i = li + 1; i < ri; i++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, li, maxIdx);
        root.right = findRoot(nums, maxIdx + 1, ri);
        return root;
    }

    /**
     * 最大二叉树变种
     */
    public int[] parentIndexes(int[] nums) {
        return new int[0];
    }

}
