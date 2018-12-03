package com.xiaolianhust.leetcode.easy;

public class NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findComplement(5));
	}
	
	/**
	 * 
	 * 
	 * ˼·��
	 * 1. ����������λ
	 * 2. ʹ��~�������ת����Ϊ
	 * 3. Ȼ���߼�������ͬ��λ�����õ����
	 * 
	 * test: 6ms, beats 84.36% ��=��=��=��(�b��b;)��
	 * ���ԣ��þö�ûд�������ˡ�����д�������
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
