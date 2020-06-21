/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
 * 
 * 输入: s = "rat", t = "car" 输出: false 说明: 你可以假设字符串只包含小写字母。
 * 
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */
// 字母异位词 每个字母出现的次数一致
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        if (schars.length != tchars.length)
            return false;

        int[] counts = new int[26];

        for (int i = 0; i < schars.length; i++) {
            counts[schars[i] - 'a']++;
        }

        for (int i = 0; i < tchars.length; i++) {
            if (--counts[tchars[i]  - 'a'] < 0)
                return false;
        }

        return true;
    }
}