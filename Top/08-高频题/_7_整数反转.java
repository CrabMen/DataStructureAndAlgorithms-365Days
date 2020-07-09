/**
 * 
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123 输出: 321  
 * 
 * 示例 2:
 * 
 * 输入: -123 输出: -321
 * 
 * 示例 3:
 * 
 * 输入: 120 输出: 21
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class Solution {
    public int reverse(int x) {
        return reverse_1(x);
    }

    // 当前解题符合该题干要求;但是不适合所有情况: 输入的数值如果为long类型
    public int reverse_0(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;

            // 可能存在数字翻转以后越界的问题
            if (result > Integer.MAX_VALUE)
                return 0;
            if (result < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int) result;
    }

    public int reverse_1(int x) {
        int result = 0, prevResult = result;
        while (x != 0) {
            prevResult = result;
            int mod = x % 10;
            result = prevResult * 10 + mod;
            if ((result - mod) / 10 != prevResult)
                return 0;
            x /= 10;
        }
        return (int) result;
    }
}