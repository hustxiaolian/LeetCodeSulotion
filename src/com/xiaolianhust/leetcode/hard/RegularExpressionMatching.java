package com.xiaolianhust.leetcode.hard;

public class RegularExpressionMatching {
	
	public static void main(String[] args) {
		//System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
		System.out.println(isMatchdp2("abc", "ac*bc*c"));
	}
	
	/**
	 * ����ָ�룬��̬�滮�����ģ��жϵ�ǰ����ָ��������Ƿ�ƥ��
	 * 1. p���ַ����������
	 *    a-z����ôƥ��s�е�ǰλ���ϲ�������ַ���������ֱ�ӱ����ǣ�����ָ��ȫ����ǰ�ƶ�
	 *    . ƥ������a-z��Ȼ������ָ����ǰ�ƶ�
	 *    * ����ǰ����ַ������壬Ȼ���������0���������ɸ���һֱ�ƶ�s��ָ��ֱ����ƥ��Ϊֹ��
	 *    
	 * �����ԭ��
	 * �����ַ����м�ĳ���ַ���ƥ�䣻s�ַ��������ַ�ûƥ���ϣ�p�л����ַ�ûƥ����
	 * 
	 * ���ڿ�������֮ǰ��˼·�ǼٵĶ�̬�滮���ҹ�����֮ǰ����������ȷ��������Ϲ˵��
	 * ����˼·û����˶��������ʧ�ܡ�
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
			if(pi + 1 < pn && p.charAt(pi + 1) == '*') {//�ж��Ƿ�������ɧ����
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
	 * �ݹ�˼·��
	 * 
	 * ���˼·��ȻҲ����ʹ��һ����ά����+���������������Ǹ�ֱ�Ӹ�Ч���ǣ��涯̬�滮��
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 */
	public boolean isMatchdp1(String text, String pattern) {
		if(pattern.isEmpty()) //���ƥ���ַ���ɣ��������ֻ�û�꣬�Ǿ���������������ˣ��Ǿ�true
			return text.isEmpty();
		boolean first_match = !text.isEmpty() &&//��ͼ�Σ��ж���text���滹��û�У�ͬʱ����Ҳ��ֹ�����жϵ�Խ�����
				(text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
		
		if(pattern.length() >= 2 && pattern.charAt(1) == '*') {//�ж��Ƿ�����*�����
			return isMatchdp1(text, pattern.substring(2)) || (first_match && isMatchdp1(text.substring(1), pattern));
		}
		else
			return first_match && isMatchdp1(text.substring(1), pattern.substring(1));
			
	}
	
	/**
	 * ѧϰ�´��еķ������涯̬�滮��
	 * 
	 * �᷽ܽ����
	 * ���ȶ�̬�滮����ĵľ����ҵ�optimal structure��
	 * 
	 * ����⣬���е�˼·����ǿ����ˣ�������һЩϸ���ϣ��һ�δ��ȫ��ᣬֻ���ڸ����ʵ���з����ܽ��ˡ�
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
    public static boolean isMatchdp2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;//�������Ҫ�������ǣ���Ȼ��ô��Ķ��ᳶ������

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
