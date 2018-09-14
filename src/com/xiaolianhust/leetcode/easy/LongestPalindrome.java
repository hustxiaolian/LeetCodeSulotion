package com.xiaolianhust.leetcode.easy;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 区分大小写。
	 * 思路：
	 * 1. 遍历所有字符串，使用hashmap来记录每个字符在字符串中出现的次数。
	 * 2. 遍历map中的所有键，如果对应的值为偶数，那么全部加在result上，如果为奇数则-1 然后加在result
	 * 3. 最后判断是否有剩余字符，是的话，result+1，否则直接返回
	 * 
	 * test1:5ms, ε=ε=ε=┏(゜ロ゜;)┛
	 * @param s
	 * @return
	 */
	public int longestPalindrome(String s) {
		if(s == null) return 0;
        int n = s.length();
        if(n <= 1) return n;
        int[] lowchars = new int[26];
        int[] upchars = new int[26];
        
        for(char ch : s.toCharArray()) {
        	if(ch >= 'a') {
        		upchars[ch - 'a']++;
        	} else {
        		lowchars[ch - 'A']++;
        	}
        }
        int result = 0;
        for(int i = 0;i < 26;++i) {
        	int tmp = lowchars[i];
        	if(tmp > 1) {
        		if(tmp % 2 == 0)
        			result += tmp;
        		else
        			result += (tmp - 1);
        	}
        	tmp = upchars[i];
        	if(tmp > 1) {
        		if(tmp % 2 == 0)
        			result += tmp;
        		else
        			result += (tmp - 1);
        	}
        }
        return (n - result) == 0 ? result : result + 1;
    }
}
