import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。 数字 x
 * 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,1] 输出: [2,-1,2]
 * 
 * 解释: 第一个 1 的下一个更大的数是 2； 数字 2 找不到下一个更大的数； 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 注意: 输入数组的长度不会超过 10000。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] array = new int[nums.length];
        int count = nums.length * 2 - 1;
        // 先给数组设置默认值为-1
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        /**
         * 因为是循环数组需要遍历2遍,通过栈找到最大值的index,然后并对输出的数组对饮index赋值
         * 一开始stack中我尝试报错数组对应的元素,但是发现无法准备的对array数组对应的index赋值,
         * 该题是 496. 下一个更大元素 I 的变种
         */

        for (int i = 0; i < count; i++) {
            int idx = i % nums.length;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                array[stack.pop()] = nums[idx];
            }
            stack.push(idx);
        }
        return array;
    }
}