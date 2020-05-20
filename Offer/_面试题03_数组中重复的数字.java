import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * 
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 
 * 示例 1：
 * 
 * 输入： [2, 3, 1, 0, 2, 5, 3]
 * 
 * 输出：2 或 3  
 * 
 * 限制：
 * 
 * 2 <= n <= 100000
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    public int findRepeatNumber(int[] nums) {
        return method_sort(nums);
        // return method_set(nums);
    }

    private int method_sort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        return -1;
    }

    private int method_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }

    // 原地置换 ?

}