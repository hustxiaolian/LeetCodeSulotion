package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(wordBreak2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
				new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
		System.out.println(wordBreak2("catsandog", 
				new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}
	
	/**
	 * ��һ��˼·��
	 * һ��dp����Ŀ���Ϲ�أ�����·��
	 * ��д�ݹ�˼·��
	 * 
	 * ���ȣ�ʵ�ֵݹ黹��ͦ�򵥵ģ����ǣ��Ǻǣ��Ҿ�֪��������ô�򵥡�
	 * test1:time limit exceeded
	 * 
	 * ��ģ��Ǹ�ȫ��a��̫���ˣ��ǵñƵ��ҳ�ɱ�С�������ҵġ�����ʹ��HashMap�Ⱦ���ʹ�ó����ֶγ��ԡ�
	 * 
	 * ׼������discuss�������·����ѡ��������
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public static boolean wordBreak(String s, List<String> wordDict) {
		if(s.length() == 0)
			return true;
		Set<String> set = new HashSet<>();
		int maxLength = 0;
		for(String w : wordDict) {
			set.add(w);
			maxLength = Math.max(maxLength, w.length());
		}
		return helper(s, set, maxLength);
    }
	
	private static boolean helper(String s, Set<String> wordDict, int maxLength) {
		if(s.length() == 0)
			return true;
		for(int i = Math.min(maxLength, s.length());i >= 1;--i) {
			String curr = s.substring(0, i);
			if(wordDict.contains(curr) && helper(s.substring(i), wordDict , maxLength))
				return true;
		}
		return false;
	}
	
	public static boolean wordBreak2(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) return false;
		  
		int n = s.length();
		  
		// dp[i] represents whether s[0...i] can be formed by dict
		boolean[] dp = new boolean[n];
		  
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);
		      
				if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
					dp[i] = true;
					break;
				}
			}
		}
		  
		return dp[n - 1];
	}
	
}
