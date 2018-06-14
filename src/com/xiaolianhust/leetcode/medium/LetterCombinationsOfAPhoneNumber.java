package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * @author 25040
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations2("23"));
	}
	
	/**
	 * ��һ��˼·��
	 * 1. ʹ��HashMap<Integer, List<String>>���洢���ֶ�Ӧ����ĸ
	 * 2. ���������ַ�����ʶ������Ȼ���෴�����������������ϡ�
	 * 
	 * �������������Ҫ��map��
	 * 1. ����һ��charΪa,Ȼ������a + ""����ת��Ϊ�ַ�����ͬʱ����ͨ��++a����ȡ��һ���ַ���
	 * 2. �ٹ۲��ֻ�2-8���ֶ�Ӧ�������֣����9��Ӧ�ĸ����֣����˫��ѭ�������������9�����z����
	 *
	 * 
	 * �о�����һ�����ɵ�������Ȧͼ��ʹ�ù����������������
	 * 
	 * test1:5ms��beat 25%����ԭ�򣺳�ʼ������̫���ˡ�������ʵ����Ҫʹ�ù�ϣ����ȫ�������������������븴���ˡ�
	 * 
	 * 
	 * ʱ����ޣ�3^N(��������2-9�ĸ���)
	 * �ռ�������
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations1(String digits) {
		//�����������,��ʼ������
		int inLength = digits.length();
		List<String> result = new ArrayList<>();
		List<String> oldResult, temp;
		if(inLength == 0) return result;
        HashMap<Character, List<String>> map = new HashMap<>();
        
        //������Ӧ��map
        for(char i = '2',j = 'a'; i <= '9' ;++i) {
        	List<String> lst = new ArrayList<>(3);
        	map.put(i, lst);
        	int n = i == '7' || i == '9'? 4 : 3;
        	for(int k = 0;k < n;++k) {
        		lst.add((j++) + "");
        	}
        }
        
        //��ʼ��result
        result.addAll(map.get(digits.charAt(0)));
        //�������ɽ��
        for(int i = 1; i < inLength;++i) {
        	oldResult = result;
        	temp = map.get(digits.charAt(i));
        	result = new ArrayList<>();
        	for (String preString : oldResult) {
        		for (String addChar : temp) {
					result.add(preString + addChar);
				}
			}
        }
        
		return result;
    }
	
	public static List<String> letterCombinations2(String digits) {
		List<String> result = new ArrayList<>();
		int inLength = digits.length();
		if(inLength == 0) return result;
		String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		String[] temp;
		List<String> oldResult;
		
		//�ӹ�ǰ����1�Ŀ�����
		int digitsIndex;
		for(digitsIndex = 0; digitsIndex < inLength;++digitsIndex) {
			char ch = digits.charAt(digitsIndex);
			if(ch != '1') {
				result.addAll(Arrays.asList(map[ch - '2'].split("")));
				break;
			}
		}
		
		for(++digitsIndex;digitsIndex < inLength; ++digitsIndex) {
			char ch = digits.charAt(digitsIndex);
			if(ch == '1') continue;
			temp = map[ch - '2'].split("");
			oldResult = result;
			result = new ArrayList<>();
			for (String prefix : oldResult) {
				for (String addChar : temp) {
					result.add(prefix + addChar);
				}
			}
		}
		
		return result;
	}
}
