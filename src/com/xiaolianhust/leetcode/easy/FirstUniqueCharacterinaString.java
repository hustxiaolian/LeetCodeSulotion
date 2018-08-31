package com.xiaolianhust.leetcode.easy;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("loveleetcode"));
	}	
	/**
	 * ˼·��
	 * ʹ��һ��boolean[26]����������¼���ɡ�
	 * 
	 * test1:16ms, beats 65.16% ��=��=��=��(�b��b;)��
	 * 
	 * �ܽ᣺Ӧ��˵��string���ַ����ּ�¼��ʹ��int[26]��ӳ���¼Ӧ��˵��һ�ֹ���˼ά�ˡ�
	 * лл���Ժ�ҲҪ�����ϰ�͹��̡�
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
