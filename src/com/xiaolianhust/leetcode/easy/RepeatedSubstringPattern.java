package com.xiaolianhust.leetcode.easy;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatedSubstringPattern("bb"));
	}
	
	/**
	 * 思路：
	 * 1. 首先尝试将字符串分成两半，之后，三份，直到每个字符串只有两个字符。
	 * 2. 依次判断。
	 * 
	 * test1: 32ms
	 * 
	 * 思路：（算了，这种思路反而有更多的麻烦和变数。）
	 * 1. 第一遍遍历，首先，count每个字符出现的次数。
	 * 2. 检查count[]来判断非零的元素是否全部相等。
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
