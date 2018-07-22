package com.xiaolianhust.leetcode.easy;

public class ImplementStrStrFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("a", ""));
	}
	
	/**
	 * 第一种思路：
	 * 使用很straight的思路，那就是指定双指针，一个个的判断，慢慢判断。
	 * 
	 * test1:4ms, beats 91.83%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
        int hn = haystack.length();
        int nn = needle.length();
        for(int i = 0;i <= hn - nn; ++i) {
        	int j = 0;
        	while(j < nn && needle.charAt(j) == haystack.charAt(i + j))
        		++j;
        	if(j == nn)
        		return i;
        }
        return -1;
    }
}
