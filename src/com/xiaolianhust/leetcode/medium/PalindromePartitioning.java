package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("efe"));
	}
	
	
	/**
	 * ˼·��
	 * �ݹ��˼·��
	 * ���ҵ��׸������Ӵ���Ȼ��ݹ鴫�ݵ�������ַ�����
	 * 
	 * test1:8ms, beats 81.33%��=��=��=��(�b��b;)��
	 * @param s
	 * @return
	 */
	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        List<String> cache = new ArrayList<>();
        helper(result, 0, n, s, cache);
        return result;
    }

	/**
	 * 
	 * @param result
	 * @param startIndex
	 * @param n
	 * @param s
	 * @param cache
	 */
	private static void helper(List<List<String>> result, int startIndex, int n, String s, List<String> cache) {
		//��׼����
		if(startIndex == n) {
			List<String> oneAns = new ArrayList<>(cache);
			result.add(oneAns);
			return;
		}
		
		//�ݹ�����
		//Ѱ����һ������
		for(int i = startIndex;i < n;++i) {
			int j = extandAroundCenter(s, i, i, startIndex);
			if(j != -1) {
				cache.add(s.substring(startIndex, j));
				helper(result, j, n, s, cache);
				cache.remove(cache.size() - 1);
			}
			int k = extandAroundCenter(s, i, i + 1, startIndex);
			if(k != -1) {
				cache.add(s.substring(startIndex, k));
				helper(result, k, n, s, cache);
				cache.remove(cache.size() - 1);
			}
		}
	}


	private static int extandAroundCenter(String s, int left, int right, int startIndex) {
		boolean flag = false;
		while(left >= startIndex && right < s.length() && s.charAt(left) == s.charAt(right)) {
			flag = true;
			--left;
			++right;
		}
		if(flag && left + 1 == startIndex) 
			return right;
		else
			return -1;
	}
}
