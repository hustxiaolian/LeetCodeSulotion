package com.xiaolianhust.leetcode.easy;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("loveleetcode"));
	}	
	/**
	 * 思路：
	 * 使用一个boolean[26]的数组来记录即可。
	 * 
	 * test1:16ms, beats 65.16% ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 总结：应该说在string中字符出现记录，使用int[26]来映射记录应该说是一种惯用思维了。
	 * 谢谢。以后也要多加练习和巩固。
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
        int[] note = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars) {
        	note[c - 'a']++;
        }
        for(int i = 0;i < chars.length; ++i) {
        	if(note[chars[i] - 'a'] == 1)
        		return i;
        }
        return -1;
    }

}
