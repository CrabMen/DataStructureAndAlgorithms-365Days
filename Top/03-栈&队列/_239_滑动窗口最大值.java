import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 *  
 * 
 * 进阶：
 * 
 * 你能在线性时间复杂度内解决此题吗？
 * 
 *  
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 
 * 输出: [3,3,5,5,6,7]
 * 
 * 解释:
 * 
 * 滑动窗口的位置 最大值
 * 
 * --------------- -----
 * 
 * [1 3 -1] -3 5 3 6 7 3
 * 
 * 1 [3 -1 -3] 5 3 6 7 3
 * 
 * 1 3 [-1 -3 5] 3 6 7 5
 * 
 * 1 3 -1 [-3 5 3] 6 7 5
 * 
 * 1 3 -1 -3 [5 3 6] 7 6
 * 
 * 1 3 -1 -3 5 [3 6 7] 7
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 提示：
 * 
 * 1 <= nums.length <= 10^5
 * 
 * -10^4 <= nums[i] <= 10^4
 * 
 * 1 <= k <= nums.length
 * 
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1)
            return new int[0];
        if (k == 1)
            return nums;
        return maxSlidingWindow_doublePointer(nums, k);
    }

    static int[] maxSlidingWindow_doublePointer(int[] nums, int k) {

        int[] maxes = new int[nums.length - k + 1];

        int maxIdx = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        int ri = 0;
        for (int li = 0; li < maxes.length; li++) {
            ri = li + k - 1;
            if (maxIdx < li) {
                maxIdx = li;
                for (int i = li; i <= ri; i++) {
                    if (nums[i] > nums[maxIdx])
                        maxIdx = i;
                }
            }
            if (nums[ri] >= nums[maxIdx])
                maxIdx = ri;
            maxes[li] = nums[maxIdx];
        }
        return maxes;
    }

    /**
     * 是用双端队列解决
     */

    static int[] maxSlidingWindow_deque(int[] nums, int k) {
        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        int li = 0;
        for (int ri = 0; ri < nums.length; ri++) {

            while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(ri);

            li = ri - k + 1;

            if (li < 0)
                continue;

            if (deque.peekFirst() < li)
                deque.pollFirst();

            maxes[li] = nums[deque.peekFirst()];
        }
        return maxes;

    }
}