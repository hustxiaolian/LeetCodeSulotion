package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares(15));
	}
	
	/**
	 * ˼·��
	 * �������˼·���ݹ�˼·��
	 * 1. �������<= N������perfect squares
	 * 2. Ȼ��ʹ�õݹ飬�ɹ�������еĽ���Ƚϡ���������ٵĴ�����
	 * 
	 * test1: 60ms, beats 25.45% ��=��=��=��(�b��b;)��
	 * 
	 * ��Ȼ����ʹ��dp���������ӿ졣
	 * @param n
	 * @return
	 */
	private int result = Integer.MAX_VALUE;
	public int numSquares(int n) {
        int[] psNums = new int[(int)Math.sqrt(n)];
        for(int i = 0;i < psNums.length ;++i)
        	psNums[i] = (i + 1) * (i + 1);
        helper(psNums, n, 0, psNums.length - 1);
        return result;
    }
	
	/**
	 * 
	 * @param psNums
	 * @param remain
	 * @param count
	 * @param startIndex
	 */
	private void helper(int[] psNums, int remain, int count, int startIndex) {
		if(remain == 0) {
			result = Math.min(result, count);
			return;
		}
		
		for(int i = startIndex;i >= 0;--i) {
			if(remain >= psNums[i]) {
				for(int j = remain / psNums[i];j > 0; --j) {
					int newRemian = remain - psNums[i] * j;
					if(count + j > result) 
						break;
					helper(psNums, newRemian, count + j, i - 1);
				}
			}
		}
	}
	
	/**
	 * ˼·��
	 * dp˼·������˼·��
	 * 1. ��������֪f(i - 1)֮�����е���ȷ�����
	 * 2. ���ݵ�ǰ������� f(i) = f(i - perfectNum[j]) + 1;
	 * 3. �߽����f(0) = 0, f(1) = f(1 - 1) + 1 = 1
	 * 
	 * @param n
	 * @return
	 */
	public int numSquares2(int n) {
        int[] psNums = new int[(int)Math.sqrt(n)];
        int[] dp = new int[n + 1];
        for(int i = 0;i < psNums.length ;++i)
        	psNums[i] = (i + 1) * (i + 1);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= n;++i) {
        	int tmp = (int)Math.sqrt(i);
        	for(int j = 0;j < tmp; ++j) {
        		dp[i] = Math.min(dp[i], dp[i - psNums[j]] + 1);
        	}
        }
        return dp[n];
    }
}
