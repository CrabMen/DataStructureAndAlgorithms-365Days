import java.util.Stack;

import javax.print.StreamPrintService;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 
 *  
 * 
 * 示例：
 * 
 * 输入："abbaca" 输出："ca" 解释： 例如，在 "abbaca" 中，我们可以删除 "bb"
 * 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa"
 * 可以执行重复项删除操作，所以最后的字符串为 "ca"。  
 * 
 * 提示：
 * 
 * 1 <= S.length <= 20000 S 仅由小写英文字母组成。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

/**
 * 
 * 并没有想着使用栈,看到题目的第一个想法就是直接遍历,qaq
 * 
 * 执行用时 : 15 ms , 在所有 Java 提交中击败了 80.24% 的用户
 * 
 * 内存消耗 : 40.3 MB , 在所有 Java提交中击败了7.69% 的用户
 * 
 */

class Solution {
    public String removeDuplicates(String S) {
        char[] array = S.toCharArray();
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (string.length() == 0 || string.charAt(string.length() - 1) != c) {
                string.append(c);
            } else {
                string.deleteCharAt(string.length() - 1);
            }
        }
        return string.toString();
    }

}

/**
 * 官方使用栈的解法
 * 
 * 使用栈去解决这个问题 执行用时 : 29 ms , 在所有 Java 提交中击败了 62.54% 的用户
 * 
 * 内存消耗 : 40.8 MB , 在所有Java 提交中击败了 7.69% 的用户
 */

class Solution {
    public String removeDuplicates(String S) {
        char[] array = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || array[i] != stack.peek()) {
                stack.push(array[i]);
            } else {
                stack.pop();
            }
        }
        StringBuffer str = new StringBuffer();
        for (Character character : stack) {
            str.append(character);
        }
        return str.toString();
    }

}
