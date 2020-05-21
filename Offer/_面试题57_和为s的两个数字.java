

import sun.security.util.ArrayUtil;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        if (nums.length < 2)
            return result;
        for (int i = 0; i < nums.length; i++) {
            if (ArrayUtil.contains(nums, target - i)) {
                result[0] = i;
                result[1] = target - i;
            }
        }
        return result;
    }
}