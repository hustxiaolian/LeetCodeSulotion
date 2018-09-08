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
	 * 思路：
	 * 这道题没想出来。
	 * 
	 * 总结下discuss的思路：
	 * 1. 首先这道题的递归思路肯定是针对运算符而言，而不是针对数字。
	 * 2. 我一开始的for+递归的思路，遍历所有运算符的可能性，这种思路表达出的意思是，我先选择第一个运算符，依次下次。
	 * 		但是没法很好的解决的重复的问题。
	 * 3. 而discuss的思路，递归把整个式子分成两半，表达的意思相当于先选择最后一个运算符，
	 * 		然后把式子分成两半，各自在递归，相比于之前，这种分解式的就没有重复的问题。
	 * 
	 * 我改进了它一下。将整个字符串直接化为一个字符数组，然后让递归在数组上进行，而不是每次生成新的字符子串。
	 * 改进了空间利用效率。
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
