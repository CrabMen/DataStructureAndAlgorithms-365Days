/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 
 * 
 * 说明:
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
 * nums2 中的元素。  
 * 
 * 示例:
 * 
 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1, idx2 = n - 1, cur = nums1.length - 1;
        while (idx2 >= 0) {
            if (idx1 >= 0 && nums1[idx1] > nums2[idx2]) {
                nums1[cur--] = nums1[idx1--];
            } else {
                nums1[cur--] = nums2[idx2--];
            }

        }
    }
}