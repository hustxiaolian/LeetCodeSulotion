package com.xiaolianhust.leetcode.medium;

public class Numberof1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(-1));
	}
	
	/**
	 * 思路：
	 * 从左到右，因此检查所有32个bit，一个简单的计数问题
	 * 
	 * test1:1ms, beats 99.44%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for(int i = 0;i < 32;++i) {
        	int curr = mask & n;
        	if(curr != 0)
        		++result;
        	/*
        	else if(curr > n)这里不能加，否则在某些地方，会造成误判。
        		break;
        		*/
        	mask <<= 1;
        }
        return result;
    }

}
