package com.xiaolianhust.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
	
	public static void main(String[] args) {
		System.out.println(wordBreakDFS("catsanddog", 
				new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}
	
	/**
	 * 思路：
	 * 这道题和I非常相似，基本上的思路也是相同的。
	 * dp思考方式：
	 * 1. 假设我直到f(0...i-1)及其之前所有的f的结果。
	 * 2. 根据基准情形，考虑当前情形，这个单词必须最后包含字符s[a],假设f(a...i)包含在单词内部
	 * 		且f(0...a-1)true的话，或者说它不为0的话
	 * 
	 * 这道题就是要在上一道题的基础，正确情形下，所有的可能性，因此不能break了，而是要记住前面j的坐标，
	 * 后面使用回溯法的时候，就可以直接生成相应的东西
	 * 
	 * test1:26ms, beats 12.49%ε=ε=ε=┏(゜ロ゜;)┛
	 * 首先值得肯定的是，靠自己的本事写出来，值得肯定。说明对它的掌握还可以了。
	 * 现在还得学习下，别人高性能的方法
	 * 
	 * 看了下高票答案，使用DFS，广度优先所有，遍历所有可能的邻接表，然后往下递归。
	 * 为了获取比较搞得性能，使用备忘法的思想，记录下自己增加已经计算完成的子串，妙，学习了。
	 * 自己手撸一遍，加深记忆和印象。
	 * 
	 * 额。。。这个高票discuss被aaaaaa这个搞得TLE，好吧，还是我自己的比较6
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	static HashMap<String, List<String>> map = new HashMap<>();
	public static List<String> wordBreakDFS(String s, List<String> wordDict){
		map.clear();
		//备忘法，记录下字串s的情况，字串s由那些单词组成。
		if(map.containsKey(s))
			return map.get(s);
		
		List<String> result = new ArrayList<>();
		if(s.length() == 0) {//当现在的字串为空时，没必要算了，直接返回空串，表示一个敬意。
			result.add("");
			return result;
		}
		for(String word : wordDict) {
			if(s.startsWith(word)) {
				//获取之后字串的所有可能性，并且拼接。
				List<String> subResult = wordBreakDFS(s.substring(word.length()), wordDict);
				for(String subString : subResult) {
					result.add(word + (subString.isEmpty() ? "" : " ") + subString);//当到尾巴的时候和上面那个配合可以去掉尾巴上多余的空格
				}
			}
		}
		map.put(s, result);
		return result;
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		int n = s.length();
        List<String> result = new ArrayList<>();
        List<List<Integer>> dp = new ArrayList<>(n);

        for(int i = 0;i < n;++i) {
        	boolean isFirst = true;
        	for(int j = 0; j <= i;++j) {
        		String sub = s.substring(j, i + 1);
        		if((j == 0 || dp.get(j - 1) != null) && wordDict.contains(sub)) {
        			if(isFirst) {
        				dp.add(new ArrayList<>());
        				isFirst = false;
        			}
        			dp.get(i).add(j - 1);
        		}
        	}
        	if(isFirst)
        		dp.add(null);
        }
        if(dp.get(s.length() - 1) != null) {
        	String oneAns = s;
        	helper(dp, result, oneAns, n - 1);
        }
        return result;
    }

	private static void helper(List<List<Integer>> dp, List<String> result, String oneAns, int i) {
		if(i < 0) {
			result.add(oneAns.trim());
			return;
		}
		for(int last : dp.get(i)) {
			String next = oneAns.substring(0, last + 1) + " " + oneAns.substring(last + 1);
			helper(dp, result, next, last);
		}
	}
}
