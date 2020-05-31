/**
 * 最长公共子序列的长度
 * 
 */

public class LCS {
    public static void main(String[] args) {
        LCS lcs = new LCS();

        String text1 = "ezupkr";
        String text2 = "ubmrapg";

        System.out.println("************************");
        System.out.println(lcs.longestCommonSubsequence_dp2(text1, text2));

    }

    /**
     * dp[i,j]代表 以text1 的前i个元素(下标为i-1) 和text2的前j个(j-1)元素公共子序列的个数
     */
    public int longestCommonSubsequence_dp0(String text1, String text2) {
        if (text1 == null || text2 == null)
            return 0;
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int[][] dp = new int[char1.length + 1][char2.length + 1];
        for (int i = 1; i <= char1.length; i++) {
            for (int j = 1; j <= char2.length; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[char1.length][char2.length];
    }

    /**
     * 对二维数组进行优化
     * 
     * 每次的计算都跟上一行的计算结果有关系 可以使用固定行数的二维数组进行优化
     */
    public int longestCommonSubsequence_dp1(String text1, String text2) {
        if (text1 == null || text2 == null)
            return 0;
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int[][] dp = new int[2][char2.length + 1];
        for (int i = 1; i <= char1.length; i++) {
            for (int j = 1; j <= char2.length; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                } else {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        return dp[char1.length % 2][char2.length];
    }

    /**
     * % 对性能消耗比较大, 可以使用 & 1代替
     * 
     * 
     */
    public int longestCommonSubsequence_dp2(String text1, String text2) {
        if (text1 == null || text2 == null)
            return 0;
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int[][] dp = new int[2][char2.length + 1];
        for (int i = 1; i <= char1.length; i++) {
            int row = i & 1;
            int preRow = (i - 1) & 1;
            for (int j = 1; j <= char2.length; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[row][j] = dp[preRow][j - 1] + 1;
                } else {
                    dp[row][j] = Math.max(dp[preRow][j], dp[row][j - 1]);
                }
                System.out.println("dp2的方法 --- dp["+row+"]["+j+"]"+ dp[row][j]);

            }
        }
        return dp[char1.length & 1][char2.length];
    }

    // public int longestCommonSubsequence_dp3(String text1, String text2){
    //     if (text1 == null || text2 == null)
    //         return 0;
    //     if (text1.length() == 0 || text2.length() == 0)
    //         return 0;
    //     char[] char1 = text1.toCharArray();
    //     char[] char2 = text2.toCharArray();

    //     int[][] dp = new int[2][2];
    //     for (int i = 1; i <= char1.length; i++) {
    //         for (int j = 1; j <= char2.length; j++) {
    //             if (char1[i - 1] == char2[j - 1]) {
    //                 dp[i & 1][j & 1] = dp[(i  - 1) & 1][(j - 1) & 1] + 1;
    //             } else {
    //                 dp[i & 1][j & 1] = Math.max(dp[(i - 1) & 1][j& 1], dp[i & 1][(j - 1) & 1]);
    //             }
    //         }
    //     }
    //     return dp[char1.length & 1][char2.length & 1];
    // }

     /**
     * 使用数组优化二维数组,计算完成以后替换数组对应的元素
     * 
     * 当前元素与表格中的前一个,上一个,左上角的 三个元素相关
     * 
     * 只需一个 与二维数组列数一样的数组即可
     * 
     */
    public int longestCommonSubsequence_dp4(String text1, String text2) {
        if (text1 == null || text2 == null)
            return 0;
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int[] dp = new int[char2.length + 1];
        for (int i = 1; i <= char1.length; i++) {
            int row = i & 1;
            int preRow = (i - 1) & 1;
            for (int j = 1; j <= char2.length; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[row][j] = dp[preRow][j - 1] + 1;
                } else {
                    dp[row][j] = Math.max(dp[preRow][j], dp[row][j - 1]);
                }
                System.out.println("dp2的方法 --- dp["+row+"]["+j+"]"+ dp[row][j]);

            }
        }
        return dp[char1.length & 1][char2.length];
    }

}