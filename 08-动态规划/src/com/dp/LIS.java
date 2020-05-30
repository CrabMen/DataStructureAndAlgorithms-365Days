
/**
 * 最长上升子序列 给定一个无序的整数数组
 * 
 * 找到其中最长上升子序列的长度,子序列不需要连续
 */
public class LIS {
	//[1,3,6,7,9,4,10,5,6]

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 1,3,6,7,9,4,10,5,6 }));
	}

	/**
	 * 动态规划 
	 * 
	 * dp[i]表示以第i个元素结尾的最长子序列,计算该dp[i],需要遍历i之前的所有的元素,并与当前元素进行比较
	 * 
	 * 求出所有的情况的子序列以后,求出最大值 
	 */
	static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] <= nums[j])
					continue;
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			System.out.println("dp[" + i + "]:" + dp[i]);
			max = Math.max(dp[i], max);
		}
		return max;
	}

}
