import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 
 *  
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 暴力法 枚举枚举每一对整数 时间复杂度O(n^2) 空间复杂度时间复杂度O(1)
         * 
         * 是否能使用
         * 
         * O(n) 空间复杂度 时间复杂度O(n)实现呢?
         * 
         */

        if (nums == null)
            return null;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null)
                return new int[] { idx, i };
            map.put(nums[i], i);
        }
        return null;

    }
}