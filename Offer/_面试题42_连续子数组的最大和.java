/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 
 * 要求时间复杂度为O(n)。
 * 
 * 示例1:
 * 
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4] 
 * 
 * 输出: 6 
 * 
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。  
 * 
 * 提示：
 * 
 * 1 <= arr.length <= 10^5 -100 <= arr[i] <= 100 
 * 
 * 注意：本题与主站 53
 * 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 这道题也属于最大切片问题 (最大区段 Greatest Slice)
 * 
 */

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        return maxSubArray(nums, 0, nums.length);
    }

    /**
     * 
     * 【分治】
     * 
     * 假设问题的解是 S[i,j],那么问题的解有3种可能
     * 
     * 1. [i,j)存在于[begin,mid)中
     * 
     * 2. [i,j)存在于[mid,end)中
     * 
     * 3. [i,j)一部分存在于[begin,mid)中,另一部分存在于[mid,end)中
     * 
     * 3.1 [i,j) = [i,mid) + [mid,j)
     * 
     * S[i,mid) = max{S[K,mid)}, begin <= k < mid
     * 
     * T(n)=T(n/2)+T(n/2)+O(n)
     * 
     * 与归并排序的时间复杂度一致 :T(n)=2T(n/2)+O(n)
     * 
     * 空间复杂度: O(logn)
     * 
     * 时间复杂度: O(nlogn)
     * 
     */
    static int maxSubArray(int[] nums, int begin, int end) {

        if (end - begin < 2)
            return nums[begin];

        int mid = (begin + end) >> 1;

        // 计算情况3 跨区间的情况
        int leftMax = Integer.MIN_VALUE, leftSum = 0;

        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE, rightSum = 0;

        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        // 情况3 和情况1 和情况2 三者取最大值
        return Math.max(leftMax + rightMax, Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)));

    }

    /**
     * 暴力破解
     * 
     * 超出时间限制 200/202
     * 
     * 空间复杂度: O(1)
     * 
     * 时间复杂度: O(n^3)
     * 
     */
    static int maxSubArrayVolience0(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                // [begin,end] 左闭右闭
                int sum = 0;
                // 缺点:重复遍历并计算 优化
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /*
     * 空间复杂度: O(1)
     * 
     * 时间复杂度: O(n^2)
     */
    static int maxSubArrayVolience1(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                // [begin,end] 左闭右闭
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
