/**
 * 
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]
 * 。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 
 * 示例 1：
 * 
 * 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 
 * 
 * 提示：
 * 
 * 2 <= n <= 58 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[j], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];

    }
}