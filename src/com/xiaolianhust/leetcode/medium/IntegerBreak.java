package com.xiaolianhust.leetcode.medium;

public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerBreak2(8));
	}
	
	/**
	 * ˼·��
	 * ����·��dp����˼·�����ڲݸ�ֽ�ϣ�����д��������ͷ�ܽᣩ
	 * 1. ������֪֮ǰ���е����������֪f(i-1)����֮ǰ���е������
	 * 2. �������⿼�ǵ�ǰ�����
	 * 		i = x1+...+xj
	 * 		f(i) = Math(f(x1)*...*f(xj))
	 * �ڱ����У����ǿ��Է����õ���x1+x2=y����f(y)������֪�����ԣ�������Ŀ��˼����ֻ��Ҫ�ֽ��������
	 * ����x1,x2Ҫ��Ҫ�����ֽ⣬��ȡ����ĳ˻�ֵ������Ѿ���֮ǰ������ˡ�
	 * ͬʱ,ע�⵽2,3���������ֲ��ֽ�����������Ƚ����⣬�����Ķ��Ƿֽ�Ƚϴ�
	 * 
	 * test1:1ms, beats 53.12%��=��=��=��(�b��b;)��
	 * 
	 * �Ľ���
	 * @param n
	 * @return
	 */
	public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2;i <= n;++i) {
        	int left = 1, right = i - 1;
        	int currMax = 0;
        	while(left <= right) {
        		int max1 = Math.max(left * right, left * dp[right]);
        		int max2 = Math.max(dp[left] * right, dp[left] * dp[right]);
        		currMax = Math.max(Math.max(max1, max2), currMax);
        		left++;right--;
        	}
        	dp[i] = currMax;
        }
        return dp[n];
    }
	
	public static int integerBreak2(int n) {
		if(n <= 3)
			return n - 1;
		int[] dp = new int[n + 1];
		dp[1] = 1; dp[2] = 2;dp[3] = 3;
		for(int i = 4;i <= n;++i) {
			int left = 1, right = i - 1;
			int currMax = 0;
			while(left <= right) {
				currMax = Math.max(currMax, dp[left++]*dp[right--]);
			}
			dp[i] = currMax;
		}
		return dp[n];
	}
}
