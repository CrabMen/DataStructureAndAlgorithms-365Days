/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb"
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */

// 动态规划将n^3的暴力法优化为n^2
class Solution {
    public String longestPalindrome_dp(String s) {
        if (s == null)
            return null;
        char[] chars = s.toCharArray();
        if (chars.length == 0)
            return s;

        int maxLen = 0, begin = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];
        // 根据状态转移方程,明确计算规则,从左到右,从下到上计算
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                int len = j - i + 1;
                dp[i][j] = chars[i] == chars[j] && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(chars, begin, maxLen);
    }

    /**
     * 扩展中心法 n+(n-1)个扩展中心,但是相对动态规划的好处就是,不需要额外的空间
     */
    public String longestPalindrome_center0(String s) {
        if (s == null)
            return null;
        char[] chars = s.toCharArray();
        if (chars.length <= 1)
            return s;
        // 最长回文子串的长度至少是1
        int maxLen = 1, begin = 0;
        for (int i = chars.length - 2; i > 0; i--) {
            int len1 = palindromeLength(chars, i - 1, i + 1);
            int len2 = palindromeLength(chars, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > maxLen) {
                maxLen = max;
                begin = i - ((maxLen - 1) >> 1);
            }
        }

        // 首位
        if (chars[0] == chars[1] && maxLen < 2) {
            begin = 0;
            maxLen = 2;
        }

        return new String(chars, begin, maxLen);
    }

    /**
     * 从 li开始向左,从ri开始向右,获得的最长回文子串的长度
     * 
     * @param chars
     * @param li
     * @param ri
     */
    private int palindromeLength(char[] chars, int li, int ri) {
        while (li >= 0 && ri < chars.length && chars[li] == chars[ri]) {
            li--;
            ri++;
        }
        return ri - li - 1;
    }

    /**
     * 扩展中心优化 时间复杂度依旧为n^2 但是有一些扫描是可以过滤掉的
     * 
     * 以一些相同字符为固定的扩展中心进行扩展,可以有效减少一些重复的扫描
     * 
     * 找到邮编第一个不等于s[i]的字符,记为位置r,i左边位置为l
     * 
     * 有l开始向左,r开始向右扩展,找到最长的回文子串
     * 
     * 找到最长的回文子串后,r作为下一次的i
     */

    public String longestPalindrome_center1(String s) {
        if (s == null)
            return null;
        char[] chars = s.toCharArray();
        if (chars.length <= 1)
            return s;
        // 最长回文子串的长度至少是1
        int maxLen = 1, begin = 0;
        while (i < chars.length) {
            int r = i,l = i -1;
            while (++r < chars.length && chars[r] == chars[i]);
            //r会成为新的i
            i = r;
            while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            //扩展结束后,chars[l+1,r) 就是找到的回文子串
            //++1后,l就是刚找到的回文子串的索引
            int len = r - ++l;
            if (len > maxLen) {
                begin = l;
                maxLen = len;
            }
        }

        // 首位
        if (chars[0] == chars[1] && maxLen < 2) {
            begin = 0;
            maxLen = 2;
        }

        return new String(chars, begin, maxLen);
    }

}