package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DifferentWaystoAddParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(diffWaysToCompute2("2-1-1"));
	}
	
	/**
	 * ˼·��
	 * �����û�������
	 * 
	 * �ܽ���discuss��˼·��
	 * 1. ���������ĵݹ�˼·�϶��������������ԣ�������������֡�
	 * 2. ��һ��ʼ��for+�ݹ��˼·����������������Ŀ����ԣ�����˼·��������˼�ǣ�����ѡ���һ��������������´Ρ�
	 * 		����û���ܺõĽ�����ظ������⡣
	 * 3. ��discuss��˼·���ݹ������ʽ�ӷֳ����룬������˼�൱����ѡ�����һ���������
	 * 		Ȼ���ʽ�ӷֳ����룬�����ڵݹ飬�����֮ǰ�����ַֽ�ʽ�ľ�û���ظ������⡣
	 * 
	 * �ҸĽ�����һ�¡��������ַ���ֱ�ӻ�Ϊһ���ַ����飬Ȼ���õݹ��������Ͻ��У�������ÿ�������µ��ַ��Ӵ���
	 * �Ľ��˿ռ�����Ч�ʡ�
	 * 
	 * @param input
	 * @return
	 */
	final static HashSet<Character> set = new HashSet<>();
	static {
		set.add('+');
		set.add('-');
		set.add('*');
		set.add('/');
	}
	public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<>();
        int n = input.length();
        for(int i = 0;i < n;++i) {
        	char ch = input.charAt(i);
        	if(set.contains(ch)) {
        		List<Integer> leftRet = diffWaysToCompute(input.substring(0, i));
        		List<Integer> rightRet = diffWaysToCompute(input.substring(i + 1));
        		for(int left : leftRet) {
        			for(int right : rightRet) {
        				int tmp = 0;
        				switch (ch) {
        				case '+' : tmp = left + right;break;
        				case '-' : tmp = left - right;break;
        				case '*' : tmp = left * right;break;
        				case '/' : tmp = left / right;break;
						}
        				ret.add(tmp);
        			}
        		}
        	}
        }
        if(ret.size() == 0) {
        	ret.add(Integer.valueOf(input));
        }
        return ret;
    }
	
	public static List<Integer> diffWaysToCompute2(String input){
		return helper2(input.toCharArray(), 0, input.length() - 1);
	}

	private static List<Integer> helper2(char[] arr, int left, int right) {
		List<Integer> ret = new ArrayList<>();
		for(int i = left;i <= right;++i) {
			char ch = arr[i];
			if(set.contains(ch)) {
				List<Integer> leftRet = helper2(arr, left, i - 1);
				List<Integer> rightRet = helper2(arr, i + 1, right);
				for(int num1 : leftRet) {
					for(int num2 : rightRet) {
						int tmp = 0;
        				switch (ch) {
        				case '+' : tmp = num1 + num2;break;
        				case '-' : tmp = num1 - num2;break;
        				case '*' : tmp = num1 * num2;break;
        				case '/' : tmp = num1 / num2;break;
						}
        				ret.add(tmp);
					}
				}
			}
		}
		if(ret.size() == 0) {
        	ret.add(Integer.valueOf(String.valueOf(arr, left, right - left + 1)));
        }
        return ret;
	}

	
}
