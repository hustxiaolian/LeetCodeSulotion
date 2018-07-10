package com.xiaolianhust.leetcode.hard;

import java.util.LinkedList;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParenthesesdp(")()()("));
	}
	
	/**
	 * һ�����͵�dp����Ŀ���ú������¡�
	 * 
	 * ���ȶ�����˵��Ѱ����������ӽṹ��Ȼ���õݹ�˼·��һ�顣
	 * 
	 * test1: 1317ms,beats 0.0%Ц��
	 * ÿ������̬�滮����Ŀ��������˵ĵ�
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
	 * ��������ĵݹ��㷨�����ⲻ��Ҫ���ظ����㡣
	 * ���ڸо��������Ǹ��㷨��ֱ�Ĳ���Ц�ޡ�
	 * 
	 * ���������������dp�ĺ���˼�롣�ö����ϵ�����ʵ����˼��
	 * �ο���solution��˼·����дһ�顣
	 * 
	 * ׼��һ�����飺
	 * if s[i] = ')' && s[i-1] = '('  dp[i] = dp[i - 1] + 2;
	 * if s[i] = ')' && s[i - 1] = ')' dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
	 * 
	 * ��������ʱ����ֻ����˲���ֻ�����˹���ʽ�ĵ�һ������û�п��ǵڶ��������ö�ѧϰѧϰ
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
