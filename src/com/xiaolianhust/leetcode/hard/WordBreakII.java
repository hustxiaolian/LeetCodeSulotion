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
	 * ˼·��
	 * ������I�ǳ����ƣ������ϵ�˼·Ҳ����ͬ�ġ�
	 * dp˼����ʽ��
	 * 1. ������ֱ��f(0...i-1)����֮ǰ���е�f�Ľ����
	 * 2. ���ݻ�׼���Σ����ǵ�ǰ���Σ�������ʱ����������ַ�s[a],����f(a...i)�����ڵ����ڲ�
	 * 		��f(0...a-1)true�Ļ�������˵����Ϊ0�Ļ�
	 * 
	 * ��������Ҫ����һ����Ļ�������ȷ�����£����еĿ����ԣ���˲���break�ˣ�����Ҫ��סǰ��j�����꣬
	 * ����ʹ�û��ݷ���ʱ�򣬾Ϳ���ֱ��������Ӧ�Ķ���
	 * 
	 * test1:26ms, beats 12.49%��=��=��=��(�b��b;)��
	 * ����ֵ�ÿ϶����ǣ����Լ��ı���д������ֵ�ÿ϶���˵�����������ջ������ˡ�
	 * ���ڻ���ѧϰ�£����˸����ܵķ���
	 * 
	 * �����¸�Ʊ�𰸣�ʹ��DFS������������У��������п��ܵ��ڽӱ�Ȼ�����µݹ顣
	 * Ϊ�˻�ȡ�Ƚϸ�����ܣ�ʹ�ñ�������˼�룬��¼���Լ������Ѿ�������ɵ��Ӵ����ѧϰ�ˡ�
	 * �Լ���ߣһ�飬��������ӡ��
	 * 
	 * ����������Ʊdiscuss��aaaaaa������TLE���ðɣ��������Լ��ıȽ�6
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	static HashMap<String, List<String>> map = new HashMap<>();
	public static List<String> wordBreakDFS(String s, List<String> wordDict){
		map.clear();
		//����������¼���ִ�s��������ִ�s����Щ������ɡ�
		if(map.containsKey(s))
			return map.get(s);
		
		List<String> result = new ArrayList<>();
		if(s.length() == 0) {//�����ڵ��ִ�Ϊ��ʱ��û��Ҫ���ˣ�ֱ�ӷ��ؿմ�����ʾһ�����⡣
			result.add("");
			return result;
		}
		for(String word : wordDict) {
			if(s.startsWith(word)) {
				//��ȡ֮���ִ������п����ԣ�����ƴ�ӡ�
				List<String> subResult = wordBreakDFS(s.substring(word.length()), wordDict);
				for(String subString : subResult) {
					result.add(word + (subString.isEmpty() ? "" : " ") + subString);//����β�͵�ʱ��������Ǹ���Ͽ���ȥ��β���϶���Ŀո�
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
