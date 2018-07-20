package com.xiaolianhust.leetcode.hard;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinctByRealDP("rabbbit", "rabbbit"));
	}
	
	/**
	 * 第一种思路：
	 * 设定两个指针，分别指向两个字符串的头位置a,b，向后迭代/
	 * 当两个指针相等时，a++,b++
	 * 当两个指针不相等时，a++,
	 * 
	 * 任何一方先到了尾部，停止迭代。
	 * 上面这个思路使用于快速寻找一个可能的解，但是不适合找到所有的情况 
	 * 
	 * 第二种思路：
	 * for+递归的思路。每轮找到一个字母，然后for循环递归到下一轮次，知道t字符串完结。
	 * test1:Time limit exceeded超时了，我就说这道题不可能这么简单。应该是正确的，但是速度确实是捉鸡。
	 * 
	 * 第三种思路：
	 * dp思路。还是老套路，按照dp的思考方式来。
	 * 1. 假设基准情形已知，这次还是得倒着来，假设已知
	 * f(s[i+1...sn], t[j+1...tn])及其以后的所有情形的结果，
	 * 
	 * 2. 根据基准情形，考虑当前结果。
	 * 当s[i]=t[j]时，f(s[i...sn],t[j...tn])=f(s[i+1...sn],t[j+1...tn]) + f(s[i+2....sn],t[j+1...tn])+....
	 * 
	 * 3.考虑边界情形，当i=sn,表示s种已经没有值了，但是t中还有字符，不满足条件，置0，
	 * 同理，当j=tn时，表示t中没有字符了，但是s还有，不满足条件，置0
	 * 当i=sn,t=tn,置1
	 * 
	 * 后来验证了下，正着来也是一样的，只是我受到我前面那个TLE递归的影响，导致我先入为主的先用了倒着的
	 * 正着的的递归式就是把它倒过来
	 * 假设我知道f(s[0...i-1],t[0...j-1])及其之前所有的结果
	 * 考虑当前情形f(s[0...i],[0...j]) = f(s[0...i-1],t[0...j-1]) + f(s[0...i - 2] + t[0...j-1])
	 * 
	 * test1:5ms, beats 88.13%ε=ε=ε=┏(゜ロ゜;)┛
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public static int numDistinct(String s, String t) {
		int sn = s.length();
		int tn = t.length();
        return helper(s, 0, sn, t, 0, tn);
    }
	
	/**
	 * 递归例程。
	 * 基准情形：
	 * 1. 如果tIndex==t.length(),说明前面的递归层次中已经找到了所有的字母。
	 * 2. 如果1不成立，则说明t的字母还是没完成找到，继续递归下一轮层次，利用for循环防止越界访问。
	 * @param s
	 * @param t
	 * @param i
	 * @param n
	 * @return
	 */
	private static int helper(String s, int sIndex, int sn, String t, int tIndex, int tn) {
		//基准情形,
		if(tIndex == tn) 
			return 1;
		
		int result = 0;
		for(int i = sIndex;i < sn;++i) {
			if(s.charAt(i) == t.charAt(tIndex))
				result += helper(s, i + 1, sn, t, tIndex + 1, tn);
		}
		return result;
	}
	
	public static int numDistinctByRealDP(String s, String t) {
		int sn = s.length();
		int tn = t.length();
		if(tn == 0 || sn == 0 || tn > sn) return 0;
		int[][] dp = new int[tn + 1][sn + 1];
		dp[tn][sn] = 1;
		for(int i = tn;i >= 1;--i) {
			int currSum = 0;
			for(int j = sn;j >= 1;--j) {
				currSum += dp[i][j];
				if(t.charAt(i - 1) == s.charAt(j - 1))
					dp[i - 1][j - 1] = currSum;
			}
		}
		int result = 0;
		for(int j = sn;j >= 0;--j) {
			result += dp[0][j];
		}
		return result;
	}
}
