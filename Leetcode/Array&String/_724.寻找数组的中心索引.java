/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1, 7, 3, 6, 5, 6] 输出: 3 解释: 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 =
 * 11)，与右侧数之和(5 + 6 = 11)相等。 同时, 3 也是第一个符合要求的中心索引。 示例 2:
 * 
 * 输入: nums = [1, 2, 3] 输出: -1 解释: 数组中不存在满足此条件的中心索引。 说明:
 * 
 * nums 的长度范围为 [0, 10000]。 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 
 * 
 * 
 */

/**
 * 官方题解
 * 
 * 前缀和
 * 
 * S 是数组的和，当索引 i 是中心索引时，位于 i 左边数组元素的和 leftsum 满足 S - nums[i] - leftsum。
 * 我们只需要判断当前索引 i 是否满足 leftsum==S-nums[i]-leftsum 并动态计算 leftsum 的值。
 * 
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/find-pivot-index/solution/xun-zhao-shu-zu-de-zhong-xin-suo-yin-by-leetcode/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftsum = 0;
        for (int i : nums)
            sum += i;
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - nums[i] - leftsum)
                return i;
            leftsum += nums[i];
        }
        return -1;
    }
}