import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？请你找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 *  
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 暴力法 枚举枚举每一对整数 时间复杂度O(n^3) 空间复杂度时间复杂度O(1)
         * 
         * 是否能存在更优解?
         * 
         * 如果数组是有序的呢?
         */

        if (nums == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        // 用来扫描三元数的第一个元素
        int lastIdx = nums.length - 3;
        for (int i = 0; i <= lastIdx; i++) {
            // 如果相等则跳过 去重 剪枝
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1, r = nums.length - 1, remain = -nums[i];
            while (l < r) {
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain) {
                    // 找到符合条件的三元组
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                  //跳过相同的值 去重剪枝
                  while(l<r && nums[l] == nums[l+1]) l++;
                  while(l<r && nums[r] == nums[r-1]) r++;
                    l++;
                    r--;
                } else if (sumLr < remain) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}