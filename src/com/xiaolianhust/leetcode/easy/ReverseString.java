package com.xiaolianhust.leetcode.easy;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ����ʹ��˫ָ���˼·��
	 * 1. �Ƚ��ַ���ת�����ַ����飬Ȼ����������ָ�룬�����˴��м䣬�໥������
	 * 
	 * test: 3ms
	 * @param s
	 * @return
	 */
	public String reverseString(String s) {
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while(i < j) {
        	char tmp = arr[i];
        	arr[i++] = arr[j];
        	arr[j--] = tmp;
        }
        return String.valueOf(arr);
    }
}
