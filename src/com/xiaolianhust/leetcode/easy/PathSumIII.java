package com.xiaolianhust.leetcode.easy;

import java.util.HashMap;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class PathSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 我得大体思路没错，但是错在没有想到大佬的currSum-target = prefix sum这个等式上，
	 * 由此，导致每轮都必须完全更新一遍map，这是不可接受的。
	 * 而大佬这种思路就没有这种问题。
	 * 
	 * 看了discuss，总结如下：
	 * 1. 使用一个map来存储，key为prefix sum,value为有几种路径可以得到这个prefix sum
	 * 2. 使用一个currSum来存储目前从顶到下的路径和，那么currSum - target如果有prefix sum, 那么说明有节选路径
	 * 
	 * 
	 * 学习了，谢谢。
	 * @param root
	 * @param sum
	 * @return
	 */
	private int result = 0;
	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, sum, 0, map);
        return result;
    }
	/**
	 * 
	 * @param t
	 * @param sum
	 * @param i
	 * @param map
	 */
	private void helper(TreeNode t, int target, int currAllSum, HashMap<Integer, Integer> map) {
		//基准情形
		if(t == null)
			return;
		//将当前节点加入到总sum中
		currAllSum += t.val;
		//判断当前节点及其以上，有没有符合条件的路径
		if(map.containsKey(currAllSum - target))
			result += map.get(currAllSum - target);
		
		//将当前currAllSum存入map
		if(!map.containsKey(currAllSum))
			map.put(currAllSum, 1);
		else
			map.put(currAllSum, map.get(currAllSum) + 1);
		
		//向左右两个子节点递归
		helper(t.left, target, currAllSum, map);
		helper(t.right, target, currAllSum, map);
		map.put(currAllSum, map.get(currAllSum) - 1);
	}
}
