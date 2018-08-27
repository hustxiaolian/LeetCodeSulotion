package com.xiaolianhust.leetcode.easy;

public class PowerofThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ��򵥵�˼·��Ȼ����ǲ�ͣ��/3 ����%3
	 * �������˳�ѭ����ʱ�����1
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree(int n) {
        if(n <= 0)
        	return false;
        while(n % 3 == 0)
        	n /= 3;
        return n==1;
    }
	
	/**
	 * ����������㡣
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree2(int n) {
		//3^19=1162261467,3^20����ˣ�Ȼ��ֱ����%��Ҫ��%n==0,���뱣֤n��������û�г���3����ġ�
		//6666
        return n > 0 && 1162261467 % n == 0;
    }
	
}
