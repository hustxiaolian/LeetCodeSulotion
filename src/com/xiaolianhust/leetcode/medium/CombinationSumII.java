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
	 * 思路和上面非常类似：
	 * 1.但是在递归中必须向前-1，然后不能在包含i自身了
	 * 
	 * test1:beats 21% ε=ε=ε=┏(゜ロ゜;)┛。
	 * 这种方法我就知道不好，因为它涉及到了重复性检测，应该是在递归的过程中，采取某种措施，直接避免。
	 * 我去学习下discuss中的优秀答案。
	 * 
	 * 借助答案写出属于我的自己的递归版本
	 * test2: 偷师了discuss中的递归算法，它在递归过程中加入一个if(i > curr && cand[i - 1] == cand[i]) continue;
	 * 这个动作实在太骚了，直接解决了答案重复的问题，它的原理是我允许你在当前节点添加一次数字，并且该数字可以于cache的上一个数字重复，但是在当且递归轮次中，其他的2，跟他视为等价。
	 * 22ms ,beat 73% ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * test3: 学习刚刚的操作，将LinkedList换成了ArrayList,速度立马提高了一截。以后在这种明确能够知道访问坐标的地方，还是直接使用ArrayList，速度上确实快。
	 * 18ms, beat 95% ε=ε=ε=┏(゜ロ゜;)┛
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
	 * 其实这里条件有变化，如果接下来有重复的，那我们必须特殊的对待，而不能简单的掠过。
	 * 比如2 2 2 2 只有四种输出：2 4 6 8.
	 * 因此，要做的就是检测到重复，并且做重复处理。
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
			//首先判断size
			if(cache.size() != list.size())
				continue;
			//再挨个元素比较，由于都是排序好的，所以还是很快的。
			Iterator<Integer> index1 = cache.iterator();
			Iterator<Integer> index2 = list.iterator();
			//只有有一个组完全相同，那么就不行
			while(index1.hasNext() && index1.next() == index2.next());
			if(!index1.hasNext())
				return false;
		}
		return true;
	}
	
}
