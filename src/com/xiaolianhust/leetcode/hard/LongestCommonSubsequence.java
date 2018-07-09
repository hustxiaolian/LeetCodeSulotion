package com.xiaolianhust.leetcode.hard;

/**
 * 算法导论动态规划经典例题
 * 最长公共子序列问题。
 * 
 * 动态规划的几个性质：
 * 1. 最有子结构问题
 * 2. 递归求解时，大量重复计算的子问题。
 * 
 * 利用cut&paste来证明一般归纳式。
 * c[i, j] = c[i - 1, j - 1] + 1 ifx[i] = y[j]
 * c[i,j] = max(c[i-1,j], c[i,j-1]) otherwise
 * 
 * 相当于反证法。
 * 当x[i] = y[j]时，该式子成立，那么c[i-1,j-1]就是x[i-1],y[j-1]的最长子序列，如果|w| > k - 1
 * 如果有比他更长的，那么我们把最后一个字符贴在它的最后面，那么它一定比k更大。所以得证。
 * c[i,j] > k,矛盾。因此说|w| = k - 1.
 * 
 * @author 25040
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dp3("ABCBDAB", "BDCABA"));
	}
	
	
	/**
	 * 第一种方法：递归执行，思路是对的，但是存在着大量的重复子问题的。我们可以画出它在最差情形时的决策树。
	 * 时间复杂度：2^(m + n)
	 * 空间复杂度：如果递归使用的栈空间不算的话，就是O（1）
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int dp1(String x, String y) {
		int i = x.length();
		int j = y.length();
		return dp1helper(x, y, i - 1, j - 1);
	}

	private static int dp1helper(String x, String y, int i, int j) {
		if(i < 0 || j < 0)
			return 0;
		
		if(x.charAt(i) == y.charAt(j))
			return dp1helper(x, y, i - 1, j - 1) + 1;
		else
			return Math.max(dp1helper(x, y, i - 1, j), dp1helper(x, y, i, j - 1));
	}
	
	/**
	 * 使用一个二维数组来记住之前已经计算过的子问题。避免重复计算.
	 * 这种方法在算法导论上叫做备忘法。
	 * 时间复杂度：mn
	 * 空间复杂度：mn
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int dp2(String x, String y) {
		int i = x.length();
		int j = y.length();
		if(i < 1 || j < 1) return 0;
		Integer[][] arr = new Integer[i + 1][j + 1];
		for(int k = 0;k <= i;++k) {
			arr[k][0] = 0;
		}
		for(int k = 0;k <= j;++k) {
			arr[0][k] = 0;
		}
		dp2helper(x, y, i, j, arr);
		return arr[i][j];
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param i
	 * @param j
	 * @param arr
	 * @return
	 */
	private static int dp2helper(String x, String y, int i, int j, Integer[][] arr) {
		if(arr[i][j] == null) {
			if(x.charAt(i - 1) == y.charAt(j - 1))
				arr[i][j] = dp2helper(x, y, i - 1, j - 1, arr) + 1;
			else
				arr[i][j] =  Math.max(dp2helper(x, y, i, j - 1, arr), dp2helper(x, y, i, j - 1, arr));
		} 
		return arr[i][j];
	}
	
	/**
	 * 第三种非递归的方式，就是真正的动态规划。与其向递归那样根据决策树的路径计算，
	 * 不如我按照规律来计算，而且这种对数组有规律的访问，明显好好利用了高速缓存。有利于进一步提高计算速度。
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int dp3(String x, String y) {
		int xn = x.length();
		int yn = y.length();
		if(xn < 1 || yn < 1) return 0;
		int[][] arr = new int[xn + 1][yn + 1];
		for(int i = 1;i <= xn;++i) {
			char chx = x.charAt(i - 1);
			for(int j = 1;j <= yn;++j) {
				char chy = y.charAt(j - 1);
				if(chx == chy)
					arr[i][j] = arr[i - 1][j - 1] + 1;
				else
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
			}
		}
		return arr[xn][yn];
	}
}
