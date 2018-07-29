package com.xiaolianhust.leetcode.hard;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCutByDp2("aabbccbbaa"));
	}

	/**
	 * dp����˼·��
	 * ����·������dp˼·����ģ���������оͿ�����ʹ�õݹ�˼��������Ȼ���˼·ת����dp
	 * 
	 * �ܽ�dp��˼·��
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
		//��׼����
		if(index >= n)
			return -1;
		
		//һ������
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
	 * ��dp,��������ĵݹ�˼·ת����dp.
	 * 
	 * test1: 235ms, beats 12.06%��=��=��=��(�b��b;)��
	 * 
	 * Ҳ������⣬�Ͼ�ʱ�����Ϊ���η����Ͼ�����û����취������֤ѧϰ�����еĻ��ĵĶ�����Ϣ��
	 * ������������Ӧ���ǿ��Խ���ʱ����޼��ٵ����η���
	 * 
	 * ������discuss��˼·������������������ʹ��dp��˼�룬һ���ǻ��ķֶ�������棬һ�����ж��Ƿ��ǻ���������档
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
	 * �ο���discuss��dp˼·��
	 * ����ʹ��һ����ά���������������Ϣ
	 * h[i][j]��ʾs[i,j]�Ƿ��ǻ��ģ���ô���ݹ���ʽ��if s[i+1,j-1] �ǻ��ģ���s[i]=s[j]����
	 * if i + 1 > j - 1, ��ôs[i + 1,j-1]�Զ�Ϊtrue
	 * 
	 * �����dp���ǣ����s[i,j]�ǻ��ģ���ôdp[i] = dp[j + 1] + 1 �������������Ϊ��Ѱ����Сֵ������min����
	 * 
	 * �Ż����̵��ܽ��11ms->6ms, ��������ʡһ���ʱ�䡣
	 * 1. ���ø��ٻ��棬������֤�ֲ��ԣ�������֮�����dp[i]��������ʣ���ȫ�������þֲ��������棬Ȼ�����ֵ��
	 * 2. s.charAt()���罫s->char[] ֮��ʹ���������ʿ졣
	 * 
	 * test2:6ms, beats 92.xx%��=��=��=��(�b��b;)��
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
