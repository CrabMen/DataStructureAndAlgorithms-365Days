
import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * 给定两个 没有重复元素 的数组 nums1
 * 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * 
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2]. 输出: [-1,3,-1]
 * 
 * 解释: 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 
 * 输出: [3,-1]
 * 
 * 解释:   对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。 对于 num1 中的数字 4
 * ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

/**
 * 
 * 刚看到题目确实是有无从下手的感觉,后来是通过观看官方解答的动图理解的.
 * 
 * 题目分析,num1位num2的子集,找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * 其实求的就是num2中的每个元素,在当前数组中比自己大的下一个元素,如果没有的话,则为-1(暴力破解的话,时间复杂度为n²)
 * num1其实是迷惑行为,只要找到上方的要求,再遍历num1就可以
 */



// (栈的经典用法)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        /**
         * 通过stack和map结合,找出比当前元素下一个更大的元素 O(N)
         * 
         */
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // 遍历num1(为num2的子集),求出比当前元素在num2中的位置,大的下一个元素
        int[] array = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            array[i] = map.get(nums1[i]);
        }
        return array;
    }
}