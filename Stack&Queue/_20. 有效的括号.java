import java.util.HashMap;
import java.util.Map;
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
 * 执行结果： 通过 显示详情 执行用时 : 6 ms , 在所有 Java 提交中击败了 8.69% 的用户
 * 
 * 内存消耗 : 38 MB , 在所有Java提交中击败了 5.48% 的用户
 */
// class Solution {
//     public boolean isValid(String s) {

//         Stack<String> stack = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             String cs = String.valueOf(s.charAt(i));
//             if (stack.isEmpty()) {
//                 stack.push(cs);
//             } else if ((stack.peek().equals("(") && cs.equals(")")) || (stack.peek().equals("{") && cs.equals("}"))
//                     || (stack.peek().equals("[") && cs.equals("]"))) {
//                 stack.pop();
//             } else {
//                 stack.push(cs);
//             }

//         }
//         return stack.isEmpty();
//     }
// }

/**
 * 尝试优化: 
 * 
 * 执行用时 :4 ms, 在所有 Java 提交中击败了19.75%的用户 
 * 
 * 内存消耗 : 37.7 MB, 在所有 Java 提交中击败了5.48%的用户
 */
// class Solution {
//     public boolean isValid(String s) {

//         if (s.length() == 0)
//             return true;
//         if (s.length() > 0 && (s.length() & 1) > 0)
//             return false;

//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (stack.isEmpty()) {
//                 stack.push(c);
//             } else if ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}')
//                     || (stack.peek() == '[' && c == ']')) {
//                 stack.pop();
//             } else {
//                 stack.push(c);
//             }

//         }
//         return stack.isEmpty();
//     }
// }

/**
 * 官方解法:
 */
class Solution {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;
  
    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution() {
      this.mappings = new HashMap<Character, Character>();
      this.mappings.put(')', '(');
      this.mappings.put('}', '{');
      this.mappings.put(']', '[');
    }
  
    public boolean isValid(String s) {
  
      // Initialize a stack to be used in the algorithm.
      Stack<Character> stack = new Stack<Character>();
  
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
  
        // If the current character is a closing bracket.
        if (this.mappings.containsKey(c)) {
  
          // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
          char topElement = stack.empty() ? '#' : stack.pop();
  
          // If the mapping for this bracket doesn't match the stack's top element, return false.
          if (topElement != this.mappings.get(c)) {
            return false;
          }
        } else {
          // If it was an opening bracket, push to the stack.
          stack.push(c);
        }
      }
  
      // If the stack still contains elements, then it is an invalid expression.
      return stack.isEmpty();
    }
  }


  /**
   * 评论区取巧解法
   */
//   class Solution {
//         public boolean isValid(String s) {
//             if(s.length() == 0 ) return true;
//             if (s.contains("()")||s.contains("[]")||s.contains("{}")) {
//                 return isValid(s.replace("()", "").replace("[]", "").replace("{}", ""));
//             } else {
//                 return false;
//             }
//         }
//     }