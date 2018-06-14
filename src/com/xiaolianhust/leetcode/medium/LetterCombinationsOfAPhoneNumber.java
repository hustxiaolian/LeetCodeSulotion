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
	 * 第一眼思路：
	 * 1. 使用HashMap<Integer, List<String>>来存储数字对应的字母
	 * 2. 遍历输入字符串，识别数字然后，相反依次像后面做排列组合。
	 * 
	 * 如何生成我所想要的map：
	 * 1. 定义一个char为a,然后利用a + ""将他转换为字符串。同时可以通过++a来获取下一个字符。
	 * 2. 再观察手机2-8数字对应三个数字，最后9对应四个数字，因此双重循环。最后再数字9上添加z即可
	 *
	 * 
	 * 感觉好像一个构成的有向无圈图，使用广度优先优先搜索。
	 * 
	 * test1:5ms，beat 25%分析原因：初始化花了太久了。而且其实不需要使用哈希表，完全可以用数组解决，是我想复杂了。
	 * 
	 * 
	 * 时间界限：3^N(输入数字2-9的个数)
	 * 空间利用率
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations1(String digits) {
		//处理特殊情况,初始化变量
		int inLength = digits.length();
		List<String> result = new ArrayList<>();
		List<String> oldResult, temp;
		if(inLength == 0) return result;
        HashMap<Character, List<String>> map = new HashMap<>();
        
        //生成相应的map
        for(char i = '2',j = 'a'; i <= '9' ;++i) {
        	List<String> lst = new ArrayList<>(3);
        	map.put(i, lst);
        	int n = i == '7' || i == '9'? 4 : 3;
        	for(int k = 0;k < n;++k) {
        		lst.add((j++) + "");
        	}
        }
        
        //初始化result
        result.addAll(map.get(digits.charAt(0)));
        //遍历生成结果
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
		
		//掠过前面是1的可能性
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
