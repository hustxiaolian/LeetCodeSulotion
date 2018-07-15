package com.xiaolianhust.leetcode.hard;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatchByDp("cb", "?b*"));
	}
	
	/**
	 * 动态规划，现在集中攻克动态规划的题目，熟悉dp的思考方式和技巧。
	 * 一般归纳式在纸上，回头再码上。
	 * 先完成递归版本，再改造成真dp
	 * 
	 * test1：time limit exceeded
	 * 哈哈，递归的版本果然超时了，毕竟2^(m+n)实在是慢。
	 * 
	 * 现在来尝试写出真dp。
	 * 哈哈，我自己独立写出第一个真dp出来了，感天动地。
	 * 尼玛这几天被教做人，搞惨了，太难得了。
	 * test2:50ms, beats 93.59%(*^_^*)
	 * 
	 * 总结以下：
	 * 首先还是昨天说的，这种思考方式很重要，以后更要坚持。
	 * 1. 假设我知道子结构的结果，也就是我假定了基准情形
	 * 在这道题中，就是说我假定f(s[i+1...sn], p[j+1...pn])这个结果是true还是false，是已知的。
	 * 2. 根据假定条件，根据题意分情况考虑当前情形，总结一般归纳式,假设当前result = f(s[i...sn], p[j...pn])
	 * 	2a.如果p[j] == '?' 那么result = f(s[i+1...sn], p[j+1...pn])
	 * 	2b.如果p[j] == '*',这里分为两种情况，任意一种能够匹配上，都行， 一种是忽略到*，即*匹配0个字节，或者*匹配当前字符
	 * 		那么result = f(s[i+1...sn], p[j...pn]) || f(s[i...sn],[j+1...pn])
	 * 3. 确定边界情况：
	 * 	3a.当p为空时，判断s是否为空，空则true，不空则false
	 *  3b. 在s为空时且p不为空时，判断p的剩余字符是否都为*号。都是则true，不全是则false
	 *  
	 * 由此我们就可以写出它的递归和真dp的函数，注意考虑特殊情况即可。
	 * 需要注意点如下：
	 * 1. 根据上述式子我们可以到，它是一个反向的，不同于我们之前的正向，前面的结果依赖于后面，而不是后面的结果依赖于前面。
	 * 2. 3b边界的处理，是我觉得我的一个亮点。简单直接的判断了*号拖尾的情况
	 * 3. 整个这个思路是个反向的过程，而且大致思路和RegularExpressionMatching很像。
	 * 
	 * 感谢leetcode，让我入门了dp。谢谢。
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
        if(p.isEmpty())
        	return s.isEmpty();
        else if(s.isEmpty()) {//如果不把这里设为一种基准来判断，那么后面就要大量添加s.isEmpty()的判断
        	boolean flag = true;
        	for(int i = 0;i < p.length();++i)
        		if(p.charAt(i) != '*') {
        			flag = false;
        			break;
        		}
        	return flag;
        }
        	
        if(p.charAt(0) == '?')
        	return isMatch(s.substring(1), p.substring(1));
        else if(p.charAt(0) == '*') 
        	return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
        else 
        	return p.charAt(0) == s.charAt(0) && isMatch(s.substring(1), p.substring(1));
    }
	
	/**
	 * 真迭代dp。
	 * 
	 * 
	 * 搞清楚边界情况
	 * 我发现一个严重的问题，我搞反了，应该向之前的那道匹配题目那样，反向。
	 * 
	 * 
	 * 
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatchByDp(String s, String p) {
		int sn = s.length();
		int pn = p.length();
		boolean[][] dp = new boolean[sn + 1][pn + 1];
		//基准情形1，都是为空了，即都刚好完成匹配，皆大欢喜
		dp[sn][pn] = true;
		//基准情形2，当p已经匹配完成后，s没有匹配完的话都是false
		//for(int i = 0;i < sn;++i)
		//	dp[i][pn] = false;
		//基准情形3，当s已经匹配完成后，如果p还不为空，后面的符号只能都是*
		for(int j = pn - 1;j >= 0;--j) 
			dp[sn][j] = dp[sn][j + 1] && p.charAt(j) == '*';
		
		//一般情形
		for(int i = sn - 1;i >= 0;--i) {
			char chs = s.charAt(i);
			for(int j = pn - 1;j >= 0;--j) {
				char chp = p.charAt(j);
				if(chp == '?')
					dp[i][j] = dp[i + 1][j + 1];
				else if(chp == '*')
					dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
				else 
					dp[i][j] = chs == chp && dp[i + 1][j + 1];
			}
		}	
		return dp[0][0];
		
	}
}
