package com.xiaolianhust.leetcode.easy;

public class PowerofThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 最简单的思路：然后就是不停的/3 ，和%3
	 * 如果最后退出循环的时候等于1
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree(int n) {
        if(n <= 0)
        	return false;
        while(n % 3 == 0)
        	n /= 3;
        return n==1;
    }
	
	/**
	 * 这种是真的秀。
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree2(int n) {
		//3^19=1162261467,3^20溢出了，然后直接求%，要想%n==0,必须保证n的因子中没有除了3以外的。
		//6666
        return n > 0 && 1162261467 % n == 0;
    }
	
}
