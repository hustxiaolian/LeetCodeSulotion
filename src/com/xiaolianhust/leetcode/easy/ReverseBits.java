package com.xiaolianhust.leetcode.easy;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(1));
		System.out.println(reverseBits(Integer.MIN_VALUE));
		
		System.out.println(reverseBits(651512384));
		System.out.println(reverseBits(38972260));
	}
	
	/**
	 * 思路:
	 * 双指针从两端开始，比较，如果相同，就不做任何操作，否则就要交换下。
	 * 其他的就是正常的bit操作
	 * 
	 * test1:2ms, beasts 18.59%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 前排的思路：
	 * 重建一个呗，而我的想法是在原有的基础上改造。
	 * 
	 * @param n
	 * @return
	 */
	public static int reverseBits(int n) {
        int masklow = 1, maskhigh = Integer.MIN_VALUE;
        for(int i = 0;i < 16;++i) {
        	int temph = (n & maskhigh) >>> (31 - i);
        	int templ = (n & masklow) >>> (i);
        	
        	if(temph != templ) 
        		n = n ^ maskhigh ^ masklow;
        	maskhigh = maskhigh >>> 1;
        	masklow = masklow << 1;
        }
        return n;
    }
	
	public static int reverseBits2(int n) {
		long result = 0;
		for(int i = 0;i < 32;++i) {
			result += n & 1;
			n = n >>> 1;
        	result = result << 1;
		}
		result = result >>> 1;
		return (int)result;
	}
}
