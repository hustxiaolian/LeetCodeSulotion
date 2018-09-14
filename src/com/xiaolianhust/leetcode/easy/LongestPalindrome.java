package com.xiaolianhust.leetcode.easy;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ���ִ�Сд��
	 * ˼·��
	 * 1. ���������ַ�����ʹ��hashmap����¼ÿ���ַ����ַ����г��ֵĴ�����
	 * 2. ����map�е����м��������Ӧ��ֵΪż������ôȫ������result�ϣ����Ϊ������-1 Ȼ�����result
	 * 3. ����ж��Ƿ���ʣ���ַ����ǵĻ���result+1������ֱ�ӷ���
	 * 
	 * test1:5ms, ��=��=��=��(�b��b;)��
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
