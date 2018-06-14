package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author 25040
 * 
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]


 */
public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum22(new int[] {10,1,2,7,6,1,5}, 8));
	}
	/**
	 * ˼·������ǳ����ƣ�
	 * 1.�����ڵݹ��б�����ǰ-1��Ȼ�����ڰ���i������
	 * 
	 * test1:beats 21% ��=��=��=��(�b��b;)����
	 * ���ַ����Ҿ�֪�����ã���Ϊ���漰�����ظ��Լ�⣬Ӧ�����ڵݹ�Ĺ����У���ȡĳ�ִ�ʩ��ֱ�ӱ��⡣
	 * ��ȥѧϰ��discuss�е�����𰸡�
	 * 
	 * ������д�������ҵ��Լ��ĵݹ�汾
	 * test2: ͵ʦ��discuss�еĵݹ��㷨�����ڵݹ�����м���һ��if(i > curr && cand[i - 1] == cand[i]) continue;
	 * �������ʵ��̫ɧ�ˣ�ֱ�ӽ���˴��ظ������⣬����ԭ�������������ڵ�ǰ�ڵ����һ�����֣����Ҹ����ֿ�����cache����һ�������ظ��������ڵ��ҵݹ��ִ��У�������2��������Ϊ�ȼۡ�
	 * 22ms ,beat 73% ��=��=��=��(�b��b;)��
	 * 
	 * test3: ѧϰ�ոյĲ�������LinkedList������ArrayList,�ٶ����������һ�ء��Ժ���������ȷ�ܹ�֪����������ĵط�������ֱ��ʹ��ArrayList���ٶ���ȷʵ�졣
	 * 18ms, beat 95% ��=��=��=��(�b��b;)��
	 * 
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum22(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> cache = new ArrayList<>();
		Arrays.sort(candidates);
		//int n = candidates.length;
		searchSum2(candidates, 0, target, cache, result);
		return result;
	}
	
	private static void searchSum2(int[] cand, int curr, int target, ArrayList<Integer> cache,
			List<List<Integer>> result) {
		if(target == 0) {
			result.add(new ArrayList<>(cache));
			return;
		}
		else if(target < 0) 
			return;
		else {
			for(int i = curr;i < cand.length;++i) {
				if(i > curr && cand[i - 1] == cand[i]) continue;
				if(cand[i] > target) break;
				cache.add(cand[i]);
				searchSum2(cand, i+1, target - cand[i], cache, result);
				cache.remove(cache.size() - 1);
			}
		}
		
	}
	public static List<List<Integer>> combinationSum21(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> cache = new LinkedList<>();
		Arrays.sort(candidates);
		int n = candidates.length;
		int min = candidates[0];
		
		for(int i = 0;i < n;++i) {
			int tempSum = target - candidates[i];
			if(tempSum == 0) {
				List<Integer> oneAns = new ArrayList<>(1);
				oneAns.add(candidates[i]);
				if(isSameAns(oneAns, result))
					result.add(oneAns);
			}
			else if(tempSum > 0 && i >= 1) {
				cache.addFirst(candidates[i]);
				if(tempSum > min) 
					searchSum(candidates, i - 1, tempSum, cache, result);
				else if(tempSum == min) {
					cache.addFirst(min);
					if(isSameAns(cache, result)) 
						result.add(new ArrayList<>(cache));
				}
				cache.clear();
			}
			else if(tempSum < 0)
				break;
		}
		return result;
    }
	
	/**
	 * ��ʵ���������б仯��������������ظ��ģ������Ǳ�������ĶԴ��������ܼ򵥵��ӹ���
	 * ����2 2 2 2 ֻ�����������2 4 6 8.
	 * ��ˣ�Ҫ���ľ��Ǽ�⵽�ظ����������ظ�����
	 * @param nums
	 * @param right
	 * @param target
	 * @param cache
	 * @param result
	 */
	private static void searchSum(int[] nums, int right, int target, LinkedList<Integer> cache, List<List<Integer>> result ) {
		if(target < nums[0])
			return;
		
		for(int i = right;i >= 0;--i) {
			int newTarget = target - nums[i];
			if(newTarget > 0) {
				cache.addFirst(nums[i]);
				searchSum(nums, i - 1, newTarget, cache, result);
			}
			else if(newTarget == 0) {
				cache.addFirst(nums[i]);
				if(isSameAns(cache, result)) 
					result.add(new ArrayList<>(cache));
			}
			else 
				continue;
			cache.removeFirst();
		}
	}
	private static boolean isSameAns(List<Integer> cache, List<List<Integer>> result) {
		for (List<Integer> list : result) {
			//�����ж�size
			if(cache.size() != list.size())
				continue;
			//�ٰ���Ԫ�رȽϣ����ڶ�������õģ����Ի��Ǻܿ�ġ�
			Iterator<Integer> index1 = cache.iterator();
			Iterator<Integer> index2 = list.iterator();
			//ֻ����һ������ȫ��ͬ����ô�Ͳ���
			while(index1.hasNext() && index1.next() == index2.next());
			if(!index1.hasNext())
				return false;
		}
		return true;
	}
	
}
