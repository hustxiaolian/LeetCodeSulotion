package com.xiaolianhust.leetcode.hard;

import java.util.LinkedList;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParenthesesdp(")()()("));
	}
	
	/**
	 * 一道典型的dp的题目，好好熟练下。
	 * 
	 * 首先二话不说，寻找它的最佳子结构。然后用递归思路做一遍。
	 * 
	 * test1: 1317ms,beats 0.0%笑死
	 * 每次做动态规划的题目总是能如此的叼。
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		int n = s.length();
        if(n == 0) return 0;
        LinkedList<Character> stack = new LinkedList<>();
        int i = 0,j = 0;
        while(i < n) {
        	char ch = s.charAt(i++);
        	if(ch == '(')
        		stack.addLast(ch);
        	else if(ch == ')') {
        		if(stack.size() > 0) 
        			stack.removeLast();
        		else
        			break;
        	}
        	if(stack.isEmpty())
        		j = i;
        }
        if(j == 0)
        	return longestValidParentheses(s.substring(1));
        else
        	return Math.max(j, longestValidParentheses(s.substring(j)));
    }
	
	/**
	 * 改造上面的递归算法，避免不必要的重复计算。
	 * 现在感觉，上面那个算法简直四不像。笑哭。
	 * 
	 * 看来还是真正理解dp的核心思想。得多多联系，多多实践和思考
	 * 参考了solution得思路，再写一遍。
	 * 
	 * 准备一个数组：
	 * if s[i] = ')' && s[i-1] = '('  dp[i] = dp[i - 1] + 2;
	 * if s[i] = ')' && s[i - 1] = ')' dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
	 * 
	 * 而我做得时候，我只想出了并且只考虑了归纳式的第一条，而没有考虑第二条。还得多学习学习
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public static int longestValidParenthesesdp(String s) {
		int n = s.length();
		if(n < 1) return 0;
		int[] arr = new int[n + 1];
		arr[0] = 0;
		int result = 0;
		for(int i = 1;i < n;++i) {
			if(s.charAt(i) == ')') {
				if(s.charAt(i - 1) == '(') {
					arr[i + 1] = arr[i - 1] + 2;
				}
				else if(i - arr[i] - 1 >= 0 && s.charAt(i - arr[i] - 1) == '(')
					arr[i + 1] = arr[i] + arr[i + 1 - arr[i] - 2] + 2;
			}
			result = Math.max(result, arr[i + 1]);
		}
		return result;
	}

}
