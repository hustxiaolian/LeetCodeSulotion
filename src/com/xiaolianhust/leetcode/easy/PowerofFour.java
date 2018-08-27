package com.xiaolianhust.leetcode.easy;

public class PowerofFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPowerOfFour(int num) {
        if(num <= 0)
        	return false;
        while(num % 4 == 0)
        	num >>>= 2;
        return num==1;
    }
	
	public boolean isPowerOfFour2(int num) {
		return num > 0 && ((num)&(num-1))==0 && (0x55555555 & num) != 0;
	}
}
