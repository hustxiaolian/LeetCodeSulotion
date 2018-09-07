package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 使用两个26长度的数组来分别记录两个字符串中每个字符出现的字符。
	 * 最后比对两个数组即可。
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
        int[] sarr = new int[26];
        int[] tarr = new int[26];
        int n = s.length();
        if(t.length() != n) return false;
        for(int i = 0;i < n;++i) {
        	sarr[s.charAt(i) - 'a']++;
        	tarr[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(sarr, tarr);
    }
}
