package com.xiaolianhust.leetcode.easy;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(21));
	}
	
	/**
	 * 思路：
	 * 1. 对当前数字尝试对2，3，5取余数，任意一个满足，直接除它，获取下一轮的剩余值。
	 * 
	 * test1: 2ms, beats 6.76%ε=ε=ε=┏(゜ロ゜;)┛
	 * 我明明和前排的代码一模一样，怎么就是慢1ms, 算了懒得计较了。
	 * @param num
	 * @return
	 */
	public static boolean isUgly(int num) {
		if(num == 0) return false;
        while(num % 2 == 0) 
        	num >>= 1;
        while(num % 3 == 0) 
        	num /= 3;
        while(num % 5 == 0) 
        	num /= 5;
        return num == 1;
    }
}
