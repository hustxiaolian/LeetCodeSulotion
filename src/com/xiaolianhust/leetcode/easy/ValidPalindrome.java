package com.xiaolianhust.leetcode.easy;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("race a car"));
	}
	
	
	/**
	 * ˼·��
	 * ����ָ�롣
	 * �����ж�����ָ����ַ��Ƿ���a-zA-z֮�䡣������ڣ����ж������ַ��Ƿ���ȡ�
	 * ֻҪ����һ�β���ȣ�ֱ��return false
	 * 
	 * test1:10ms, beats 66%
	 * 
	 * ���ÿ⺯������tolowercase��һ�߱����ϲ���while�����У�һ����ɡ�
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
