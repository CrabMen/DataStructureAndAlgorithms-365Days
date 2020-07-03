import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

/**
 * 




 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 0)
            return result;
        dfs(0, n, n, new char[n << 1], result);
        return result;
    }

    private void dfs(int idx, int leftRemain, int rightRemain, char[] chars, List<String> result) {
         // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
      
        if (idx == chars.length) {
            result.add(new String(chars));
            return;
        }

         // 枚举这一层所有可能的选择
        // 选择一种可能之后，进入下一层搜索

        // 什么情况可以选择左括号？左括号的数量 > 0
        // 选择左括号，然后进入下一层搜索
        if (leftRemain > 0) {
            chars[idx] = '(';
            dfs(idx + 1, leftRemain - 1, rightRemain, chars, result);
        }

          // 当左括号、右括号的数量一样时，只能选择左括号
        // 什么情况可以选择右括号？(右括号的数量 > 0) && (右括号的数量 != 左括号的数量)
        // 选择右括号，然后进入下一层搜索
        if (rightRemain > 0 && leftRemain != rightRemain) {
            chars[idx] = ')';
            dfs(idx + 1, leftRemain, rightRemain-1, chars, result);
        }
    }
}