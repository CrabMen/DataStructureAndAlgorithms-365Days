
/**
 * 最长上升子序列 给定一个无序的整数数组
 * 
 * 找到其中最长上升子序列的长度,子序列不需要连续
 */
public class LIS {
	// [1,3,6,7,9,4,10,5,6]

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
		System.out.println(lengthOfLIS_pile0(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
		System.out.println(lengthOfLIS_pile1(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));

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
			// System.out.println("dp[" + i + "]:" + dp[i]);
			max = Math.max(dp[i], max);
		}
		return max;
	}

	/**
	 * 把每个数字看做是一张扑克牌，从左到右按顺序处理每一个扑克牌
	 * 
	 * 将它压在(从左边数过来)第一个牌顶 ≥ 它的牌堆上面
	 * 
	 * 如果找不到牌顶 ≥ 它的牌堆，就在最右边新建一个牌堆，将它放入这个新牌堆中
	 * 
	 * 当处理完所有牌，最终牌堆的数量就是最长上升子序列的长度
	 */
	static int lengthOfLIS_pile0(int[] nums) {
		int len = 0; // 牌堆的数量
		int[] top = new int[nums.length]; // 牌顶数组
		int idx; // 当前所遍历的牌堆的索引
		for (int num : nums) {
			idx = 0;
			while (idx < len) {
				if (top[idx] >= num) {
					// 当找到当前数值所在位置,退出循环
					top[idx] = num;
					break;
				}
				// 没有新建一个牌堆,需要将idx往后挪一位
				idx++;
			}
			//
			if (idx == len) {
				len++;
				top[idx] = num;
			}

		}
		return len;
	}

	/**
	 * 对牌顶数组的操作(遍历数组并查找合适的位置)可以是用二分法优化
	 */
	static int lengthOfLIS_pile1(int[] nums) {
		int len = 0; // 牌堆的数量
		int[] top = new int[nums.length]; // 牌顶数组
		for (int num : nums) {
			int begin = 0 ,end = len;
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
