package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
	}
	
	/**
	 * ˼·��
	 * ���Ƚ��ugly number��˼·��ȷ��ʹ��dp/
	 * ��������·����
	 * 1. ȷ��dp�Ķ���Ҳ����iΪith number, f(i)��i��ugly number
	 * 2. ������֪ǰ���ȫ����ȷ���f(i - 1)֮ǰ�ģ����ݵ�ǰ�������жϡ�
	 * ��f(i) = f(k)*primes[j],����k<i, 0<j<primes.length
	 * ͬʱf(i) = i*primes[0] * j*primes[1] * ...
	 * 
	 * �������Ҫ���ľ��ǣ����մ�С�����˳����������ɡ�
	 * 
	 * test1:32ms,��=��=��=��(�b��b;)��
	 * @param n
	 * @param primes
	 * @return
	 */
	public static int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] dp = new int[n];
        int[] indexs = new int[len]; 
        dp[0] = 1;
        
        for(int i = 1;i < n;++i) {
        	int currMin = Integer.MAX_VALUE;
        	for(int j = 0;j < len;++j) {
        		currMin = Math.min(currMin, primes[j] * (dp[indexs[j]]));
        	}
        	dp[i] = currMin;
        	for(int j = 0;j < len;++j) {
        		if(currMin ==  primes[j] * (dp[indexs[j]]))
        			indexs[j]++;
        	}
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
