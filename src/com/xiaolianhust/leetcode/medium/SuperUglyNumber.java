package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
	}
	
	/**
	 * 思路：
	 * 首先借鉴ugly number得思路。确定使用dp/
	 * 根据老套路来：
	 * 1. 确定dp的对象，也就是i为ith number, f(i)第i个ugly number
	 * 2. 假设已知前面的全部正确结果f(i - 1)之前的，根据当前情形来判断。
	 * 则f(i) = f(k)*primes[j],其中k<i, 0<j<primes.length
	 * 同时f(i) = i*primes[0] * j*primes[1] * ...
	 * 
	 * 因此我们要做的就是，按照从小到大的顺序来输出即可。
	 * 
	 * test1:32ms,ε=ε=ε=┏(゜ロ゜;)┛
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
