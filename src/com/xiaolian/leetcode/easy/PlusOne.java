package com.xiaolian.leetcode.easy;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(plusOne(new int[] {9})));
	}
	
	/**
	 * 思路：
	 * 假设可以直接改变本地数据。
	 * 
	 * test1:1ms ,beats 68.51%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param digits
	 * @return
	 */
    public static int[] plusOne(int[] digits) {
    	int n = digits.length;
    	int flag = 0;
    	digits[n - 1]++;
    	for(int i = n - 1;i >= 0;--i) {
    		int tempSum = flag + digits[i];
    		digits[i] = tempSum % 10;
    		flag = tempSum / 10;
    		if(tempSum < 10)
    			break;
    	}
    	//出现了9999这种情况
    	if(flag != 0) {
    		int[] newArr = new int[n + 1];
    		newArr[0] = 1;
    		return newArr;
    	}
    	else 
    		return digits;
    }
}
