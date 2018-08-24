package com.xiaolianhust.leetcode.easy;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(21));
	}
	
	/**
	 * ˼·��
	 * 1. �Ե�ǰ���ֳ��Զ�2��3��5ȡ����������һ�����㣬ֱ�ӳ�������ȡ��һ�ֵ�ʣ��ֵ��
	 * 
	 * test1: 2ms, beats 6.76%��=��=��=��(�b��b;)��
	 * ��������ǰ�ŵĴ���һģһ������ô������1ms, �������üƽ��ˡ�
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
