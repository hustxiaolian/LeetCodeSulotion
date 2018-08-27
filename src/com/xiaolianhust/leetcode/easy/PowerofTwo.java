package com.xiaolianhust.leetcode.easy;

public class PowerofTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路：
	 * 判断n的32位bit是否只有一个1
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) return false;
        while((n & 1) == 0) 
        	n >>>= 1;
        return n == 1;
    }
	
	public boolean isPowerOfTwo2(int n) {
		if(n <= 0) 
			return false;
		else
			return (n&(n-1)) == 0;
    }
	
	public boolean isPowerOfTwo3(int n) {
		return n > 0 && Integer.MAX_VALUE % n == 0;
	}
}
