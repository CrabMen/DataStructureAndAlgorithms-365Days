import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> preIdxs = new Map();
        preIdxs.put(chars[0], 0);

        int li = 0, max = 0;
        Integer pi;

        for (int i = 1; i < chars.length; i++) {
            // pi = preIdxs.getOrDefault(chars[i],-1);
            pi = preIdxs.get(chars[i]);
            if (pi != null && li <= pi) {
                li = pi + 1;
            }
            preIdxs.put(chars[i], i);
            max = Math.max(max, i - li + 1);
        }
        return max;
    }

    /**
     * 大佬的题解 使用滑动窗口结合max函数. 更容易理解,相似题目
     * 
     * 3. 无重复字符的最长子串
     * 
     * 30. 串联所有单词的子串
     * 
     * 76. 最小覆盖子串
     * 
     * 159. 至多包含两个不同字符的最长子串
     * 
     * 209. 长度最小的子数组
     * 
     * 239. 滑动窗口最大值
     * 
     * 340. 至多包含 K 个不同字符的最长子串
     * 
     * 567. 字符串的排列
     * 
     * 632. 最小区间
     * 
     * 727. 最小窗口子序列
     * 
     * 作者：powcai
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     */
    public int lengthOfLongestSubstring_slidingWindow(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int li = 0, max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i]))
                li = Math.max(li, map.get(chars[i]) + 1);
            map.put(chars[i], i);
            max = Math.max(max, i - li + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring_sl(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int li = 0, max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i]))
                li = Math.max(li, map.get(chars[i]) + 1);
            map.put(chars[i], i);
            max = Math.max(max, i - li + 1);
        }
        return max;

    }

}