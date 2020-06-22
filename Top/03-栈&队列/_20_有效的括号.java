import java.util.Stack;

/**
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()" 输出: true 示例 2:
 * 
 * 输入: "()[]{}" 输出: true
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

class Solution {
    public boolean isValid(String s) {
        if (s == null)
            return false;

        char[] chars = s.toCharArray();
        if ((chars.length & 1) > 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : chars) {
            if (stack.isEmpty())
                stack.push(c);
            else if (isPair(stack.peek(), c))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }

    private boolean isPair(Character c1, Character c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'))
            return true;
        else
            return false;
    }
}