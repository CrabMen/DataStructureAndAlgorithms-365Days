/**
 * 
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 
 * 示例 1：
 * 
 * 输入：nums = [4,1,4,6] 输出：[1,6] 或 [6,1]
 * 
 * 示例 2：
 * 
 * 输入：nums = [1,2,10,4,1,4,3,3] 输出：[2,10] 或 [10,2]  
 * 
 * 限制：
 * 
 * 2 <= nums.length <= 10000
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

// 本题和主站 260 是一样的. 除了这个，主站还有 136 和 137，645。
// 首先题干对空间和时间复杂度都有要求 又是直奔题解的一天
class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        // 将数组所有元素进行异或，最后的结果一定是那两个单一数字的异或结果。
        // 用示例[4,4,6,1]最后的抑或结果就是 6和1异或的结果 7
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        int first = 1;
        // 通过与运算找到result第一个不为0的首位，7=>0111，也就是第一位
        while ((sum & first) == 0) {
            first = first << 1;
        }
        // first为1，所以我们可以根据数组元素的二进制低位第一位是否为1，将数组分为2类，
        // 示例数组可以分为 低位第一位为0：[4,4,6] 低位第一位为1：[1]
        // 此时再将两个数组两两异或就可以得到最终结果。
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 将数组分类。
            if ((nums[i] & first) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    public int[] singleNumbers_diy(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum ^= num;

        int first = 1;
        while ((sum & first) == 0)
            first = first << 1;

        int[] result = new int[2];
        for (int num : nums) {
            if ((num & first) == 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        return result;

    }

}
// 作者：SuperCarry
// 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/liang-liao-wei-yun-suan-yi-huo-shuang-bai-guo-by-1/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。