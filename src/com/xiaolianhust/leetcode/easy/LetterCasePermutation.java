package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCasePermutation("a1bc"));
	}

	/**
	 * ˼·��
	 * 1. ʹ��һ�����������ƶ�������ʣ����洢�м������
	 * 2. Ȼ����������ַ���S��Ȼ��ÿ�ҵ�һ��Ӣ���ַ��ͱ�����Ӧ�ķ������룬Ȼ����µ���ϲ��롣
	 * @param S
	 * @return
	 */
    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        for(int i = 0;i < S.length(); ++i) {
        	char ch = S.charAt(i);
        	char oppch = 0;;
        	//�ж��Ƿ�����ĸ�������ҵ���Ӧ�Ĵ�д����Сд�ַ�
        	if(ch >= 'a' && ch <= 'z') {
        		oppch = (char) (ch - ('a' - 'A'));
        	} else if(ch >= 'A' && ch <= 'Z')
        		oppch = (char) (ch + ('a' - 'A'));
        	//Ȼ��forѭ���������ֿ����Ըı䣬���뵽���������е�Ԫ����
        	if(oppch != 0) {
        		int n = result.size();
        		for(int j = 0;j < n;++j) {
        			String currS = result.get(j);
        			result.add(currS.substring(0, i) + oppch + currS.substring(i + 1));
        		}
        	}
        	
        }
        return result;
    }
}
