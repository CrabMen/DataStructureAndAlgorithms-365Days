/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 
 * 示例：
 * 
 * 输入：nums = [1,2,3,4] 输出：[1,3,2,4] 注：[3,1,2,4] 也是正确的答案之一。  
 * 
 * 提示：
 * 
 * 1 <= nums.length <= 50000 1 <= nums[i] <= 10000
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
class Solution {
    public int[] exchange(int[] nums) {

        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1)
                i++;
            while (i < j && (nums[j] & 1) == 0)
                j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;

    }
}