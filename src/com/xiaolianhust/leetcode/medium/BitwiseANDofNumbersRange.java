package com.xiaolianhust.leetcode.medium;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(0, Integer.MAX_VALUE));
	}
	
	/**
	 * 思路:
	 * 这道题的意思就是说要 指定区间的所有数字都and操作下，返回这个结果。
	 * 
	 * 根据bit的性质：
	 * 1. 它每+1，末尾的bit就要+1，即m - n >= 1 ,它的末尾and后，必定为0
	 * 2. 同理m-n >= 2 倒数第二个bit必定为0
	 * 3. m-n >= 4 倒数第三个bit必定为0
	 * 
	 * 没有受到上述规则，影响的bit，其and的状态与m的初始保持一致即可。
	 * 
	 * bug1: 在0. Integer.MAX_VALUE的输入下，会造成死循环，因为t没法比最大值还大，它在最大值在移位就变成了负数，
	 * 利用这点来划定最终边界，防止死循环。
	 * 
	 * test1:5ms, beats 100.0%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param m
	 * @param n
	 * @return
	 */
	public static int rangeBitwiseAnd(int m, int n) {
        int mask1 = -1;
        int t = 1;
        int sub = n - m;
        while(t > 0 && sub >= t) {
        	mask1 = mask1 << 1;
        	t = t << 1;
        }
        return m & mask1 & n;
    }
}
