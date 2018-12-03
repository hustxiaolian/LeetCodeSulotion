package com.xiaolianhust.leetcode.easy;

public class NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findComplement(5));
	}
	
	/**
	 * 
	 * 
	 * 思路：
	 * 1. 首先向左移位
	 * 2. 使用~运算符反转所有为
	 * 3. 然后逻辑右移相同的位数，得到结果
	 * 
	 * test: 6ms, beats 84.36% ε=ε=ε=┏(゜ロ゜;)┛
	 * 可以，好久都没写过程序了。还是写程序快乐
	 * 
	 * @param num
	 * @return
	 */
	public static int findComplement(int num) {
		int moveBit = 0, mask = 0x80000000;
		while((num & mask) == 0) {
			 mask >>>= 1;
			 moveBit++;
		}
        num <<= moveBit;
        num = ~num;
        return num >>> moveBit;
    }
}
