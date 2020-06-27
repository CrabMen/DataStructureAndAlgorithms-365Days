import java.util.ArrayList;

/**
 * 
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 
 * 示例:
 * 
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class Solution {

    private char[][] lettersArray = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
    private char[] chars;
    /** 用来存储每一层选择的字母 */
    private char[] string;
    private List<String> list;

    public List<String> letterCombinations(String digits) {
        if (digits == null)
            return null;
        chars = digits.toCharArray();
        list = new ArrayList<>();
        if (chars.length == 0)
            return list;
        string = new char[chars.length];
        dfs(0);
        return list;
    }

    /**
     * @param idx 正在搜索第idx层
     */
    private void dfs(int idx) {
        //递归设置退出条件;已经进入到最后一层了，不能再往下搜索
        if (idx == chars.length) {
            // 得到了一个正确的解
            list.add(new String(string));
            return;
        }
        char[] letters = lettersArray[chars[idx] - '2'];
        for (char letter : letters) {
            string[idx] = letter;
            dfs(idx + 1);
        }
    }
}