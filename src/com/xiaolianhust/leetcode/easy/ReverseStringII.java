package com.xiaolianhust.leetcode.easy;

public class ReverseStringII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ˼·��࣬����ʹ��˫ָ�롣
	 * 1. ���Ƚ��ַ���ת��Ϊ�ַ����飬Ȼ��ʹ��˫ָ����������
	 * 2. �����˫��ѭ����
	 * 
	 * test:4ms
	 * @param s
	 * @param k
	 * @return
	 */
	public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for(int i = 0;i < n ;i += 2*k) {
        	int q = Math.min(i + k - 1, n - 1);
        	int p = i;
        	while(p < q) {
        		char temp = arr[p];
        		arr[p++] = arr[q];
        		arr[q--] = temp;
        	}
        }
        return String.valueOf(arr);
    }
}
