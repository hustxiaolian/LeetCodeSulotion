package com.xiaolianhust.leetcode.hard;

/**
 * �㷨���۶�̬�滮��������
 * ��������������⡣
 * 
 * ��̬�滮�ļ������ʣ�
 * 1. �����ӽṹ����
 * 2. �ݹ����ʱ�������ظ�����������⡣
 * 
 * ����cut&paste��֤��һ�����ʽ��
 * c[i, j] = c[i - 1, j - 1] + 1 ifx[i] = y[j]
 * c[i,j] = max(c[i-1,j], c[i,j-1]) otherwise
 * 
 * �൱�ڷ�֤����
 * ��x[i] = y[j]ʱ����ʽ�ӳ�������ôc[i-1,j-1]����x[i-1],y[j-1]��������У����|w| > k - 1
 * ����б��������ģ���ô���ǰ����һ���ַ�������������棬��ô��һ����k�������Ե�֤��
 * c[i,j] > k,ì�ܡ����˵|w| = k - 1.
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
	 * ��һ�ַ������ݹ�ִ�У�˼·�ǶԵģ����Ǵ����Ŵ������ظ�������ġ����ǿ��Ի��������������ʱ�ľ�������
	 * ʱ�临�Ӷȣ�2^(m + n)
	 * �ռ临�Ӷȣ�����ݹ�ʹ�õ�ջ�ռ䲻��Ļ�������O��1��
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
	 * ʹ��һ����ά��������ס֮ǰ�Ѿ�������������⡣�����ظ�����.
	 * ���ַ������㷨�����Ͻ�����������
	 * ʱ�临�Ӷȣ�mn
	 * �ռ临�Ӷȣ�mn
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
	 * �����ַǵݹ�ķ�ʽ�����������Ķ�̬�滮��������ݹ��������ݾ�������·�����㣬
	 * �����Ұ��չ��������㣬�������ֶ������й��ɵķ��ʣ����Ժú������˸��ٻ��档�����ڽ�һ����߼����ٶȡ�
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
