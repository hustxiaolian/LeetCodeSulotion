package com.xiaolianhust.leetcode.medium;

public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：递归求解，这是数据结构那本书上，第一个递归递归的例子
	 * 不用啥特别思路，已经非常熟悉了。
	 * test1:21ms, beats 85.40%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
        if(n < 0)
        	return myPowHelper(1/x, -n);
        else if(n > 0)
        	return myPowHelper(x, n);
		
		return 1.0;
    }
	
	private double myPowHelper(double x, int n) {
		if(n == 0)
        	return 1.0;
        if(n == 1)
        	return x;
        
        if(n % 2 == 0)
        	return myPowHelper(x * x, n / 2);
        else 
        	return x * myPowHelper(x * x, n / 2);
	}
}
