
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
import java.util.Stack;

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
     * 
     * 返回一个数组，数组里面存着最大二叉树中每个节点的父节点的索引(如果没有父节点，就存 -1 )
     * 
     * 当前元素第一个比他大的元素 就为当前元素的父节点 使用一个单调递减的栈,对元素左侧第一个比他大的数和右侧第一个比他大的数,然后去二者中最小值
     * 
     * 该代码必须可以默写出来,最高温度的题 与该题干思想类似,利用栈可求出左侧或右侧第一个比他大的值
     */

    public int[] parentIndexes(int[] nums) {
        /*
         * 1.扫描一遍所有的元素
         * 
         * 2.保持栈从栈底到栈顶是单调递减的
         */

        if (nums == null || nums.length == 0)
            return null;

        int[] lis = new int[nums.length];// 左侧元素下标数组
        int[] ris = new int[nums.length];// 右侧元素下标数组
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < nums.length; i++) {
            lis[i] = -1;
            ris[i] = -1;
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty())
                lis[i] = stack.peek();

            stack.push(i);
        }

        int[] pis = new int[nums.length];
        for (int i = 0; i < pis.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                // i位置的是根节点
                pis[i] = -1;
                continue;
            }
            if (lis[i] == -1 || nums[lis[i]] > nums[ris[i]]) {
                pis[i] = ris[i];
            }

            if (ris[i] == -1 || nums[lis[i]] < nums[ris[i]]) {
                pis[i] = lis[i];
            }

        }
        return new int[0];
    }

}
