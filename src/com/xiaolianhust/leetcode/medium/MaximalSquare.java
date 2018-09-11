package com.xiaolianhust.leetcode.medium;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 这道题没有想出来。参考了discuss的思路，总结下：
	 * 1. 首先要确定dp的对象，这里dp的是当前节点及其左上所有区域，正方形的边长。假设我们已知前面的情况
	 * 2. 根据当前情形来判断.
	 * 		首先当前位置必须为1， 然后这个方形要继续扩张，那么务必要保证其上，其下，其左上起码都是‘1’
	 *      而且是正方形，因此边长等值，因此取三者的最小值。
	 *      f(i,j) = f(i-1,j) + f(i,j-1) + f(i-1,j-1)
	 * 
	 * 这是一种不错的思路，再看下其他大佬的思路。多学习，多总结。很有意思。
	 *      
	 * 其他大佬的思路也跟这个差不多，大佬思路值得好好学习，同时和我之前套路可以相结合的是：
	 * 1. 首先确定dp公式中的对象是什么，这道就是“包含右下角(i,j)节点的最大的正方形的边长”
	 * 2. 假设前面的结果都已知。根据当前情形来书写递归式。这里大佬值得好好学习的就是，先用小的示例来摸索总结规律，然后验证更一般的大的情形。
	 * 3. 考虑边界情形等特性情况。
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;++i) {
        	for(int j = 1;j <= n;++j) {
        		if(matrix[i - 1][j - 1] == '1') {
        			dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        return max * max;
    }
}
