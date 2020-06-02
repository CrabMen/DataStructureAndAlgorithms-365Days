/**
 * 300. 最长上升子序列 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18]
 * 
 * 输出: 4
 * 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 
 * 说明:
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 你算法的时间复杂度应该为 O(n2) 。
 * 
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */

class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        return lengthOfLIS_dp(nums);
    }

    /**
     * 动态规划解法
     * 
     * 查看动态规划文件夹下方法的LIS.java
     * 
     */
    static int lengthOfLIS_dp(int[] nums) {

        int[] dp = new int[nums.length];
        int max = dp[0] = 1; // 递归基
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1; // 初始值为1
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j])
                    continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }


    /**
     * 
     * 时间复杂度为 O( nlogn(n) ) 
     * 
	 * 对牌顶数组的操作(遍历数组并查找合适的位置)可以是用二分法优化
	 */
	static int lengthOfLIS_pile(int[] nums) {
		int len = 0; // 牌堆的数量
        int[] top = new int[nums.length]; // 牌顶数组
        int begin,end;    //将变量提出来,节省空间
		for (int num : nums) {
             begin = 0 ;
             end = len;
			while (begin < end) {
				int mid = (begin + end) >> 1;
				if (num <= top[mid]) {
					end = mid;
				} else {
					begin = mid + 1;
				}
			}
			// 覆盖牌顶
			top[begin] = num;
			if(begin == len) len++; 
		}
		return len;
	}


}