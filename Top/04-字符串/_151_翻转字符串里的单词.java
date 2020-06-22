/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入: "the sky is blue" 输出: "blue is sky the" 示例 2：
 * 
 * 输入: "  hello world!  " 输出: "world! hello" 解释:
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 示例 3：
 * 
 * 输入: "a good   example" 输出: "example good a" 解释:
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。  
 * 
 * 说明：
 * 
 * 无空格字符构成一个单词。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。  
 * 
 * 进阶：
 * 
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

/**
 * 说明: 无空格字符构成一个单词
 * 
 * 输入字符串可以在前面或者后面包含多余的空格,但是反转后的字符不能包括
 * 
 * 如果单词间有多余的空格,将反转后单词间的空格减少到只含一个
 * 
 */

class Solution {
    public String reverseWords(String s) {

        if (s == null)
            return "";
        /**
         * 消除多余的空格
         */
        char[] chars = s.toCharArray();
        // 字符串的最终有效长度;当前存放字符的位置
        int len = 0, cur = 0;
        // 前一个字符是否为空格,默认为true代表默认使-1的位置为空格,则字符默认从0开始
        boolean space = true;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? (cur - 1) : cur;
        if (len <= 0)
            return "";

        // 对整一个有效字符串进行逆序
        reverse(chars, 0, len);

        int prevSapceIdx = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ')
                continue;
            // i是空格字符的位置
            reverse(chars, prevSapceIdx + 1, i);
            prevSapceIdx = i;
        }
        // 翻转最后一个单词
        reverse(chars, prevSapceIdx + 1, len);
        return new String(chars, 0, len);

    }

    /**
     * 将[li, ri)范围内的字符串进行逆序
     */
    private static void reverse(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }
    }
}