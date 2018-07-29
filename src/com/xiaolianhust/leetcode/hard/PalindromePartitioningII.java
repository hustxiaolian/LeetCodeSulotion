package com.xiaolianhust.leetcode.hard;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCutByDp2("aabbccbbaa"));
	}

	/**
	 * dp核心思路：
	 * 老套路，按照dp思路那套模板来，不行就考虑先使用递归思想来做，然后把思路转换成dp
	 * 
	 * 总结dp的思路。
	 * 
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public static int minCut(String s) {
        return helper(s, 0, s.length());
    }

	private static int helper(String s, int index, int n) {
		//基准情形
		if(index >= n)
			return -1;
		
		//一般情形
		int result = n - index;
		for(int i = index;i < n;++i) {
			if(check(s, index, i)) {
				int oneAns = helper(s, i + 1, n) + 1;
				result = Math.min(oneAns, result);
			}
		}
		return result;
	}

	private static boolean check(String onePalindrome, int i, int j) {
		while(i < j && onePalindrome.charAt(i) == onePalindrome.charAt(j)) {
			++i;
			--j;
		}
		if(i >= j)
			return true;
		else
			return false;
	}
	
	/**
	 * 真dp,即将上面的递归思路转换成dp.
	 * 
	 * test1: 235ms, beats 12.06%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 也可以理解，毕竟时间界限为三次方。毕竟我们没有想办法尽量保证学习过程中的回文的额外信息。
	 * 利用其他方法应该是可以将其时间界限减少到二次方。
	 * 
	 * 看了下discuss的思路，它们在两个层面上使用dp的思想，一个是回文分段这个层面，一个是判断是否是回文这个层面。
	 * 
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public static int minCutByDp1(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[n] = -1;
		
		for(int i = n - 1;i >= 0; --i) {
			dp[i] = n - 1 - i;
			for(int j = n - 1;j >= i;--j) {
				if(check(s, i, j)) {
					dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
				}
			}
		}
		return dp[0];
	}
	
	/**
	 * 参考了discuss的dp思路。
	 * 我们使用一个二维数组来保存回文信息
	 * h[i][j]表示s[i,j]是否是回文，那么根据归纳式，if s[i+1,j-1] 是回文，且s[i]=s[j]即可
	 * if i + 1 > j - 1, 那么s[i + 1,j-1]自动为true
	 * 
	 * 后面的dp就是，如果s[i,j]是回文，那么dp[i] = dp[j + 1] + 1 或者其他结果，为了寻找最小值，调用min方法
	 * 
	 * 优化过程的总结从11ms->6ms, 活生生节省一半的时间。
	 * 1. 利用高速缓存，尽量保证局部性，比如我之间大量dp[i]的数组访问，完全可以先用局部变量代替，然后最后赋值。
	 * 2. s.charAt()不如将s->char[] 之后使用索引访问快。
	 * 
	 * test2:6ms, beats 92.xx%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param s
	 * @return
	 */
	public static int minCutByDp2(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		int[] dp = new int[n + 1];
		boolean[][] b = new boolean[n][n];
		dp[n] = -1;
		
		for(int i = n - 1;i >= 0; --i) {
			int currMin = n - 1 - i;
			for(int j = n - 1;j >= i;--j) {
				if(arr[i] == arr[j] && (i + 1 > j - 1 || b[i + 1][j - 1])) {
					b[i][j] = true;
					currMin = Math.min(currMin, dp[j + 1] + 1);
				}
			}
			dp[i] = currMin;
		}
		return dp[0];
	}
}
