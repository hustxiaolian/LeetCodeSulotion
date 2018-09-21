package com.xiaolianhust.leetcode.easy;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedSubstringPattern("bb"));
	}
	
	/**
	 * ˼·��
	 * 1. ���ȳ��Խ��ַ����ֳ����룬֮�����ݣ�ֱ��ÿ���ַ���ֻ�������ַ���
	 * 2. �����жϡ�
	 * 
	 * test1: 32ms
	 * 
	 * ˼·�������ˣ�����˼·�����и�����鷳�ͱ�������
	 * 1. ��һ����������ȣ�countÿ���ַ����ֵĴ�����
	 * 2. ���count[]���жϷ����Ԫ���Ƿ�ȫ����ȡ�
	 * @param s
	 * @return
	 */
	public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i = 2;i <= n; ++i) {
        	if(n % i == 0) {
        		int j = n / i;
        		int p = 0, q = j;
        		while(q < n) {
        			if(arr[p] != arr[q])
        				break;
        			p = (++p) % j;
        			++q;
        		}
        		if(q == n)
        			return true;
        	}
        }
        return false;
    }
}
