package com.xiaolianhust.leetcode.hard;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatchByDp("cb", "?b*"));
	}
	
	/**
	 * ��̬�滮�����ڼ��й��˶�̬�滮����Ŀ����Ϥdp��˼����ʽ�ͼ��ɡ�
	 * һ�����ʽ��ֽ�ϣ���ͷ�����ϡ�
	 * ����ɵݹ�汾���ٸ������dp
	 * 
	 * test1��time limit exceeded
	 * �������ݹ�İ汾��Ȼ��ʱ�ˣ��Ͼ�2^(m+n)ʵ��������
	 * 
	 * ����������д����dp��
	 * ���������Լ�����д����һ����dp�����ˣ����춯�ء�
	 * �����⼸�챻�����ˣ�����ˣ�̫�ѵ��ˡ�
	 * test2:50ms, beats 93.59%(*^_^*)
	 * 
	 * �ܽ����£�
	 * ���Ȼ�������˵�ģ�����˼����ʽ����Ҫ���Ժ��Ҫ��֡�
	 * 1. ������֪���ӽṹ�Ľ����Ҳ�����Ҽٶ��˻�׼����
	 * ��������У�����˵�Ҽٶ�f(s[i+1...sn], p[j+1...pn])��������true����false������֪�ġ�
	 * 2. ���ݼٶ����������������������ǵ�ǰ���Σ��ܽ�һ�����ʽ,���赱ǰresult = f(s[i...sn], p[j...pn])
	 * 	2a.���p[j] == '?' ��ôresult = f(s[i+1...sn], p[j+1...pn])
	 * 	2b.���p[j] == '*',�����Ϊ�������������һ���ܹ�ƥ���ϣ����У� һ���Ǻ��Ե�*����*ƥ��0���ֽڣ�����*ƥ�䵱ǰ�ַ�
	 * 		��ôresult = f(s[i+1...sn], p[j...pn]) || f(s[i...sn],[j+1...pn])
	 * 3. ȷ���߽������
	 * 	3a.��pΪ��ʱ���ж�s�Ƿ�Ϊ�գ�����true��������false
	 *  3b. ��sΪ��ʱ��p��Ϊ��ʱ���ж�p��ʣ���ַ��Ƿ�Ϊ*�š�������true����ȫ����false
	 *  
	 * �ɴ����ǾͿ���д�����ĵݹ����dp�ĺ�����ע�⿼������������ɡ�
	 * ��Ҫע������£�
	 * 1. ��������ʽ�����ǿ��Ե�������һ������ģ���ͬ������֮ǰ������ǰ��Ľ�������ں��棬�����Ǻ���Ľ��������ǰ�档
	 * 2. 3b�߽�Ĵ������Ҿ����ҵ�һ�����㡣��ֱ�ӵ��ж���*����β�����
	 * 3. �������˼·�Ǹ�����Ĺ��̣����Ҵ���˼·��RegularExpressionMatching����
	 * 
	 * ��лleetcode������������dp��лл��
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
        if(p.isEmpty())
        	return s.isEmpty();
        else if(s.isEmpty()) {//�������������Ϊһ�ֻ�׼���жϣ���ô�����Ҫ�������s.isEmpty()���ж�
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
	 * �����dp��
	 * 
	 * 
	 * ������߽����
	 * �ҷ���һ�����ص����⣬�Ҹ㷴�ˣ�Ӧ����֮ǰ���ǵ�ƥ����Ŀ����������
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
		//��׼����1������Ϊ���ˣ������պ����ƥ�䣬�Դ�ϲ
		dp[sn][pn] = true;
		//��׼����2����p�Ѿ�ƥ����ɺ�sû��ƥ����Ļ�����false
		//for(int i = 0;i < sn;++i)
		//	dp[i][pn] = false;
		//��׼����3����s�Ѿ�ƥ����ɺ����p����Ϊ�գ�����ķ���ֻ�ܶ���*
		for(int j = pn - 1;j >= 0;--j) 
			dp[sn][j] = dp[sn][j + 1] && p.charAt(j) == '*';
		
		//һ������
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
