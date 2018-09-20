package com.xiaolianhust.leetcode.easy;

public class ReverseStringII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 思路差不多，还是使用双指针。
	 * 1. 首先将字符串转换为字符数组，然后使用双指针来交换。
	 * 2. 这次是双重循环。
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
