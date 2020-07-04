/**
 * 
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10 输出: 1024.00000 示例 2:
 * 
 * 输入: 2.10000, 3 输出: 9.26100 示例 3:
 * 
 * 输入: 2.00000, -2 输出: 0.25000 解释: 2-2 = 1/22 = 1/4 = 0.25 说明:
 * 
 * -100.0 < x < 100.0 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    public double myPow(double x, int n) {

    }

    // 递归 时间和空间复杂度 O(nlogn)
    public double myPow_recursion(double x, int n) {
        /**
         * 快速幂 分治思想
         */
        // 是否为负数
        if (n == 0)
            return 1;
        if (n == -1)
            return 1 / x;
        boolean odd = (n & 1) == 1;
        // 因为右移运算符的问题 -1 右移多少位都是-1
        double half = myPow(x, n >> 1);
        half *= half;
        // x = (n<0)?(1/x):x;
        return odd ? (half * x) : half;
    }

    // 非递归
    public double myPow_notRecursion(double x, int n) {
        boolean neg = n < 0;
        long y = neg ? -(long) n : n;
        double result = 1.0;

        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进制是1 的累乘
                result *= x;
            }
            x *= x;
            y >>= 1;
        }
        return neg ? (1 / result) : result;
    }

    // 取值范围有坑 负数的绝对值 溢出

}