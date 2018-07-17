package com.xiaolianhust.leetcode.medium;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees2(3));
	}
	
	/**
	 * ��һ��˼·��
	 * ��dp����·���ݹ�������
	 * ���δ�����(1-n)ѡȡһ��������Ϊ���ڵ㣬Ȼ��ݹ鵽���ߣ���ȡ�����������ֶ����п����ԡ�
	 * ��׼���Σ���left > right�ǣ���������Ϊ�գ�����������ֻ��һ�����μ�Ϊnull����left = rightʱ��������ֻ��һ�����ڵ㣬Ҳ�ǵ�һ���Ρ�
	 * 
	 * ������ļ������У����ǿ��Է��ִ��ڴ������ظ����㡣
	 * ��һ��ʼѰ��dp��˼·������ƫ������optimal structure��
	 * 
	 * test1: 0ms, beats 100%��=��=��=��(�b��b;)��
	 * һ�����飬���һ��ʼ��dpû�ҵ������Ļ������԰���ֱ����д�ݹ飬Ȼ���������������У��ͻᷢ��dp�İ��
	 * 
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
        return helper(1, n);
    }

	private static int helper(int left, int right) {
		if(left >= right)
			return 1;

		int result = 0;
		for(int i = left;i <= right;++i) {
			result += ( helper(left, i - 1) * helper(i + 1, right) );
		} 
		return result;
	}
	
	/**
	 * �������������ظ����㡣
	 * ʱ�临�ӶȽ��͵�N^2.
	 * @param n
	 * @return
	 */
	public static int numTrees2(int n) {
		if(n <= 1) return 1;
		int[][] dp = new int[n][n];
		return helper2(1, n, dp);
	}

	private static int helper2(int left, int right, int[][] dp) {
		if(left - 1 < 0 || left - 1 >= dp.length || right - 1 < 0 || right - 1 >= dp.length)
			return 1;
		if(dp[left - 1][right - 1] == 0) {
			if(left >= right) {
				dp[left - 1][right -1] = 1;
				return 1;
			}
			int result = 0;
			for(int i = left;i <= right;++i) {
				result += ( helper2(left, i - 1, dp) * helper2(i + 1, right, dp) );
			} 
			dp[left - 1][right - 1] = result;
			return result;
		}
		else
			return dp[left - 1][right - 1];
	}
	
	
}
