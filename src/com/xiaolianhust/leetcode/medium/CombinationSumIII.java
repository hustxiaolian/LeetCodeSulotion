package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(3, 9));
	}
	
	/**
	 * ˼·��
	 * һ���ǳ�����Ļ��ݷ�����Ŀ��
	 * ���϶��õݹ��������漰�����ݣ���Ȼ��һ��cache��
	 * ��׼������Ǵﵽ�����󣬽�cache��ӵ�result�С�
	 * 
	 * Ϊ�˱����ظ�������start���ý�������б�֤�����ԣ������ظ���ͬʱ���Ա�֤ÿ������ֻ����һ�Ρ�
	 * ����curr��������ݹ������������������ʹ�����cache�����˼�������curr==k���Ǳ߽硣
	 * ����tempSum��������cache�е�ǰ�ĺ�ֵ�������жϱ߽�ʱ�Ƿ����������ͬʱ�����������������ⲻ��Ҫ�ļ��㡣
	 * 
	 * ���ݷ���˼�룬���ǳ������-����Ӻ����ٴ�������ж�-����ɺ�ɾ����
	 * �ڱ����У�˼������־�����cache������Ӻ��жϡ�
	 * @param k
	 * @param n
	 * @return
	 */
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        helper(result, cache, k, n, 0, 1, 0);
        return result;
    }

	private static void helper(List<List<Integer>> result, List<Integer> cache, int k, int target, int curr, int start, int tempSum) {
		if(curr == k) {
			if(tempSum == target) {
				List<Integer> oneAns = new ArrayList<>(cache);
				result.add(oneAns);
			}
			return;
		}
		
		for(int i = start;i < 10;++i) {
			if(tempSum + i > target)
				break;
			cache.add(i);
			helper(result, cache, k, target, curr + 1, i + 1, tempSum + i);
			cache.remove(cache.size() - 1);
		}
	}
}
