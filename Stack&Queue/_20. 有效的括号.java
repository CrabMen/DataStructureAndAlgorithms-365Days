import java.util.Stack;

/**
 * 20. 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1: 输入: "()" 输出: true
 * 
 * 示例 2: 输入: "()[]{}" 输出: true
 * 
 * 示例 3: 输入: "(]" 输出: false
 * 
 * 示例 4: 输入: "([)]" 输出: false
 * 
 * 示例 5: 输入: "{[]}" 输出: true
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 执行结果： 通过 显示详情 
 * 执行用时 : 6 ms , 在所有 Java 提交中击败了 8.69% 的用户 
 * 内存消耗 : 38 MB , 在所有 Java提交中击败了 5.48% 的用户 
 */
class Solution {
    public boolean isValid(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String cs = String.valueOf(s.charAt(i));
            if (stack.isEmpty()) {
                stack.push(cs);
            } else if ((stack.peek().equals("(") && cs.equals(")")) || (stack.peek().equals("{") && cs.equals("}"))
                    || (stack.peek().equals("[") && cs.equals("]"))) {
                stack.pop();
            } else {
                stack.push(cs);
            }

        }
        return stack.isEmpty();
    }
}