package com.xiaolianhust.leetcode.easy;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("race a car"));
	}
	
	
	/**
	 * 思路：
	 * 两个指针。
	 * 首先判断两个指针的字符是否在a-zA-z之间。如果都在，再判断两个字符是否相等。
	 * 只要碰到一次不相等，直接return false
	 * 
	 * test1:10ms, beats 66%
	 * 
	 * 利用库函数，将tolowercase这一边遍历合并到while遍历中，一次完成。
	 * 
	 * test2:8ms, beats 91.54%
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        String lowerS = s.toLowerCase();
        while(i < j) {
        	char chi = lowerS.charAt(i);
        	if(chi < '0' || (chi > '9' && chi < 'a'||chi >'z')) {
        		i++;
        		continue;
        	}
        	char chj = lowerS.charAt(j);
        	if(chj < '0' || (chj > '9' && chj < 'a')||chj >'z') {
        		--j;
        		continue;
        	}
        	
        	if(chi != chj)
        		return false;
        	else {
        		++i;
        		--j;
        	}
        }
		
		return true;
    }
	
	public static boolean isPalindrome2(String s) {
		int i = 0, j = s.length() - 1;
		while(i < j) {
			char chi = s.charAt(i);
			char chj = s.charAt(j);
			if(!Character.isLetterOrDigit(chi)) {
				++i;
			}
			else if(!Character.isLetterOrDigit(chj)) {
				--j;
			}
			else if(Character.toLowerCase(chi) != Character.toLowerCase(chj))
				return false;
			else {
				++i;--j;
			}
		}
		
		return true;
	}

}
