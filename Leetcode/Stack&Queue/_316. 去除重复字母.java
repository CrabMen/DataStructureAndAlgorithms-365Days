import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * _316. 去除重复字母
 * 
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *  示例 1:
 * 输入: "bcabc" 输出: "abc" 示例 2:
 * 输入: "cbacdcbc" 输出: "acdb"  
 * 
 * 注意：该题与 1081
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 相同
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

/**
 * 
 * 按照官方使用stack的方式撸了一遍
 * 
 * 代码可以理解,但是自己想不到使用这种方式,对于所谓的贪心算法还是有点迷
 * 
 *  TODO:官方给的两种方法都是贪心算法,看完贪心算法以后,还需要回来把另外一种方法看下
 * 
 */


class Solution {
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        // this lets us keep track of what's in our solution in O(1) time
        HashSet<Character> set = new HashSet<>();

        // this will let us know if there are any more instances of s[i] left in s
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!set.contains(c)) {
                // if the last letter in our solution:
                // 1. exists
                // 2. is greater than c so removing it will make the string smaller
                // 3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
                    set.remove(stack.pop());
                }
                set.add(c);
                stack.push(c);
            }
        }

        StringBuffer string = new StringBuffer();
        for (Character character : stack) {
            string.append(character);
        }

        return string.toString();

    }
}
