import jdk.internal.jshell.tool.resources.version;

/**
 * 
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入: n = 5, m = 3 输出: 3 示例 2：
 * 
 * 输入: n = 10, m = 17 输出: 2  
 * 
 * 限制：
 * 
 * 1 <= n <= 10^5 1 <= m <= 10^6
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * 
 */

class Solution {
    public int lastRemaining(int n, int m) {
     return lastRemaining_notRecursion(n, m);
    }

    //将递归优化为非递归
    public int lastRemaining_notRecursion(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }


    public int lastRemaining_recursion(int n, int m) {
        /**
         * 当总人数只有1时,剩下的都是索引为0的值;
         * 每次删除掉一个数字以后,当前数值所在的都需要从index为0时开始;最后对该数值取余,是为了保证索引值不越界
         */
        return n == 1 ? 0 : (lastRemaining(n - 1, m) + m) % n;

    }
}