
/**
 * 
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
 * 
 * 。如果有多对数字的和等于s，则输出任意一对即可。
 * 
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || target < 3)
            return new int[0];
        return twoSum_doublePointer(nums, target);
    }

    static int[] twoSum_doublePointer(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target)
                j--;
            else if (sum < target)
                i++;
            else
                return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }

    static int[] twoSum_map(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result))
                return new int[] { result, nums[i] };
            map.put(nums[i], i);
        }
        return new int[0];
    }
}