package com.xiaolianhust.leetcode.easy;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(26));
	}
	
	/**
	 * 思路：
	 * 相当于一个26进制的转换。
	 * 计算出来的每轮的值都要移动
	 * 
	 * 这道题的精髓就在于每轮的--n, 实在是秀。
	 * 具体是因为，由于0没有具体的对应。这里我也理解得不够深刻，暂时记住。
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
