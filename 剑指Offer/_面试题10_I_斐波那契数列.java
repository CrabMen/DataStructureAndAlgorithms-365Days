import sun.management.Sensor;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * 
 * F(0) = 0,   F(1) = 1 F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 斐波那契数列由 0 和 1
 * 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：n = 2 输出：1 示例 2：
 * 
 * 输入：n = 5 输出：5  
 * 
 * 提示：
 * 
 * 0 <= n <= 100 注意：本题与主站 509
 * 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

class Solution {
    public int fib(int n) {
      
        int first = 0, second = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (first + second)%1000000007;
            first = second;
            second = sum;
        }
        return first;
    }
}