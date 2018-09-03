package com.xiaolianhust.leetcode.easy;

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(38));
	}
	
	/**
	 * ˼·��
	 * 
	 * ��ʱ���뷨���Ȱ������⣬���һ�¡�
	 * 
	 * test1:1ms, beats 100% ��=��=��=��(�b��b;)��
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
        int[] tmp = new int[32];
        while(num >= 10) {
        	//����λ���ֽ�
        	int idx = 0;
        	while(num != 0) {
        		tmp[++idx] = num % 10;
        		num /= 10;
        	}
        	for(;idx >= 0;--idx)
        		num += tmp[idx];
        }
        return num;
    }
	
	/**
	 * https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
	 * @param num
	 * @return
	 */
	public static int addDigits2(int num) {
		return 1 + (num - 1) % 9;
	}
}
