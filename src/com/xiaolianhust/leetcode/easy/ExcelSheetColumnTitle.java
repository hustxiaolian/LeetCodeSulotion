package com.xiaolianhust.leetcode.easy;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(26));
	}
	
	/**
	 * ˼·��
	 * �൱��һ��26���Ƶ�ת����
	 * ���������ÿ�ֵ�ֵ��Ҫ�ƶ�
	 * 
	 * �����ľ��������ÿ�ֵ�--n, ʵ�����㡣
	 * ��������Ϊ������0û�о���Ķ�Ӧ��������Ҳ���ò�����̣���ʱ��ס��
	 * @param n
	 * @return
	 */
	public static String convertToTitle(int n) {
        String result = "";
        while(n != 0) {
        	--n;
        	result = Character.valueOf((char) (n % 26 + 'A')) + result;
        	n /= 26;
        }
        return result;
    }
}
