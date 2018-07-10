package com.xiaolianhust.leetcode.hard;

public class RegularExpressionMatching {
	
	public static void main(String[] args) {
		//System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
		System.out.println(isMatchdp2("abc", "ac*bc*c"));
	}
	
	/**
	 * 两个指针，动态规划，核心：判断当前两个指针的内容是否匹配
	 * 1. p中字符的三种情况
	 *    a-z，那么匹配s中当前位置上不是这个字符，不是则直接报错，是：两个指针全部往前移动
	 *    . 匹配所有a-z，然后两个指针向前移动
	 *    * 复制前面的字符的意义，然后它会出现0个或者若干个。一直移动s中指针直到不匹配为止。
	 *    
	 * 报错的原因：
	 * 两个字符串中间某个字符不匹配；s字符串还有字符没匹配上；p中还有字符没匹配上
	 * 
	 * 现在看来，我之前的思路是假的动态规划，我估计我之前这个概念都不明确就在那里瞎说。
	 * 这里思路没法兼顾多种情况，失败。
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		int sn = s.length();
		int pn = p.length();
		
		int xingNum = 0;
		
		for(int i = 0;i < pn;++i) {
			if(p.charAt(i) == '*')
				++xingNum;
		}
		int pi = 0,si = 0;
		while(pi < pn && si < sn) {
			if(pi + 1 < pn && p.charAt(pi + 1) == '*') {//判断是否是这种骚东西
				char pre = p.charAt(pi);
				pi = pi + 2;
				int temp = (pn - pi - 2 * --xingNum);
				int end = sn - temp;
				if(end < 0) return false;
				if(pre == '.') 
					si = end - 1;
				else {
					while(si < end && s.charAt(si) == pre) 
						si++;
				}
				
			}
			else if(p.charAt(pi) == '.') {
				pi++;si++;
			}
			else if(p.charAt(pi++) != s.charAt(si++)) {
				System.out.println("p: " + p.charAt(pi - 1));
				System.out.println("s: " + s.charAt(si - 1));
				return false;
			}
		}
		
		while(pi + 1 < pn && p.charAt(pi + 1) == '*')
			pi = pi + 2;
		if(si != sn || pi != pn)
			return false;
        return true;
    }
	
	/**
	 * 递归思路。
	 * 
	 * 这个思路当然也可以使用一个二维数组+备忘法改良。但是更直接高效的是，真动态规划。
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 */
	public boolean isMatchdp1(String text, String pattern) {
		if(pattern.isEmpty()) //如果匹配字符完成，但是文字还没完，那就凉；两个都完成了，那就true
			return text.isEmpty();
		boolean first_match = !text.isEmpty() &&//有图形，判断下text里面还有没有，同时这里也防止后面判断的越界访问
				(text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
		
		if(pattern.length() >= 2 && pattern.charAt(1) == '*') {//判断是否是有*的情况
			return isMatchdp1(text, pattern.substring(2)) || (first_match && isMatchdp1(text.substring(1), pattern));
		}
		else
			return first_match && isMatchdp1(text.substring(1), pattern.substring(1));
			
	}
	
	/**
	 * 学习下大佬的方法。真动态规划。
	 * 
	 * 总结方法：
	 * 首先动态规划最核心的就是找到optimal structure。
	 * 
	 * 这道题，大佬的思路我勉强理解了，但是在一些细节上，我还未完全体会，只能在更多的实践中反复总结了。
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatchdp2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;//这里很重要，别忘记，不然怎么算的都会扯到蛋。

        for (int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean first_match = (i < s.length() &&
                                       (p.charAt(j) == s.charAt(i) ||
                                        p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
    

}
