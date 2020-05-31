public class MaxSubArray {
	public static void main(String[] args) {
		System.out.println(maxSubArray2(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	static int maxSubArray1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
			max = Math.max(max, dp[i]);
		}
		return max;
	}
//中间值计算值没有用,使用一个变量代替数组
	static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int dp = nums[0], max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp = dp > 0 ? dp + nums[i] : nums[i];
			max = Math.max(max, dp);
		}
		return max;
	}

}
