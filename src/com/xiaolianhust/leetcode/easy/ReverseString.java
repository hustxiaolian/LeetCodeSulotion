package com.xiaolianhust.leetcode.easy;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 还是使用双指针的思路。
	 * 1. 先将字符串转换成字符数组，然后利用两个指针，从两端从中间，相互交换。
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
