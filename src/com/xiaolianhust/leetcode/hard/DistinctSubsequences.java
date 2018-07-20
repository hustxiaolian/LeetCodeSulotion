package com.xiaolianhust.leetcode.hard;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinctByRealDP("rabbbit", "rabbbit"));
	}
	
	/**
	 * ��һ��˼·��
	 * �趨����ָ�룬�ֱ�ָ�������ַ�����ͷλ��a,b��������/
	 * ������ָ�����ʱ��a++,b++
	 * ������ָ�벻���ʱ��a++,
	 * 
	 * �κ�һ���ȵ���β����ֹͣ������
	 * �������˼·ʹ���ڿ���Ѱ��һ�����ܵĽ⣬���ǲ��ʺ��ҵ����е���� 
	 * 
	 * �ڶ���˼·��
	 * for+�ݹ��˼·��ÿ���ҵ�һ����ĸ��Ȼ��forѭ���ݹ鵽��һ�ִΣ�֪��t�ַ�����ᡣ
	 * test1:Time limit exceeded��ʱ�ˣ��Ҿ�˵����ⲻ������ô�򵥡�Ӧ������ȷ�ģ������ٶ�ȷʵ��׽����
	 * 
	 * ������˼·��
	 * dp˼·����������·������dp��˼����ʽ����
	 * 1. �����׼������֪����λ��ǵõ�������������֪
	 * f(s[i+1...sn], t[j+1...tn])�����Ժ���������εĽ����
	 * 
	 * 2. ���ݻ�׼���Σ����ǵ�ǰ�����
	 * ��s[i]=t[j]ʱ��f(s[i...sn],t[j...tn])=f(s[i+1...sn],t[j+1...tn]) + f(s[i+2....sn],t[j+1...tn])+....
	 * 
	 * 3.���Ǳ߽����Σ���i=sn,��ʾs���Ѿ�û��ֵ�ˣ�����t�л����ַ�����������������0��
	 * ͬ����j=tnʱ����ʾt��û���ַ��ˣ�����s���У���������������0
	 * ��i=sn,t=tn,��1
	 * 
	 * ������֤���£�������Ҳ��һ���ģ�ֻ�����ܵ���ǰ���Ǹ�TLE�ݹ��Ӱ�죬����������Ϊ���������˵��ŵ�
	 * ���ŵĵĵݹ�ʽ���ǰ���������
	 * ������֪��f(s[0...i-1],t[0...j-1])����֮ǰ���еĽ��
	 * ���ǵ�ǰ����f(s[0...i],[0...j]) = f(s[0...i-1],t[0...j-1]) + f(s[0...i - 2] + t[0...j-1])
	 * 
	 * test1:5ms, beats 88.13%��=��=��=��(�b��b;)��
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
	 * �ݹ����̡�
	 * ��׼���Σ�
	 * 1. ���tIndex==t.length(),˵��ǰ��ĵݹ������Ѿ��ҵ������е���ĸ��
	 * 2. ���1����������˵��t����ĸ����û����ҵ��������ݹ���һ�ֲ�Σ�����forѭ����ֹԽ����ʡ�
	 * @param s
	 * @param t
	 * @param i
	 * @param n
	 * @return
	 */
	private static int helper(String s, int sIndex, int sn, String t, int tIndex, int tn) {
		//��׼����,
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
