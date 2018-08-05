package com.xiaolianhust.leetcode.medium;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(0, Integer.MAX_VALUE));
	}
	
	/**
	 * ˼·:
	 * ��������˼����˵Ҫ ָ��������������ֶ�and�����£�������������
	 * 
	 * ����bit�����ʣ�
	 * 1. ��ÿ+1��ĩβ��bit��Ҫ+1����m - n >= 1 ,����ĩβand�󣬱ض�Ϊ0
	 * 2. ͬ��m-n >= 2 �����ڶ���bit�ض�Ϊ0
	 * 3. m-n >= 4 ����������bit�ض�Ϊ0
	 * 
	 * û���ܵ���������Ӱ���bit����and��״̬��m�ĳ�ʼ����һ�¼��ɡ�
	 * 
	 * bug1: ��0. Integer.MAX_VALUE�������£��������ѭ������Ϊtû�������ֵ�����������ֵ����λ�ͱ���˸�����
	 * ����������������ձ߽磬��ֹ��ѭ����
	 * 
	 * test1:5ms, beats 100.0%��=��=��=��(�b��b;)��
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
