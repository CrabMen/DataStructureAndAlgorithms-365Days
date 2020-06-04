import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 
 * 示例:
 * 
 * s = "abaccdeff" 返回 "b"
 * 
 * s = "" 返回 " "  
 * 
 * 限制：
 * 
 * 0 <= s 的长度 <= 50000
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * 
 */
class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';

    }

    static char firstUniqChar_map(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars)
            map.put(c, !map.containsKey(c));
        for (char c : chars)
            if (map.get(c))
                return c;
        return ' ';
    }

    static char firstUniqChar_linkedMap(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars)
            map.put(c, !map.containsKey(c));
        for (Map.Entry<Character, Boolean> e : map.entrySet())
            if (e.getValue().booleanValue())
                return e.getKey();

        return ' ';
    }
}