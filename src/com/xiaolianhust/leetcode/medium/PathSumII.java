package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class PathSumII {
	/**
	 * 思路：
	 * 树的递归思路，在递归向下的过程中，计算当前路径和与sum的差值，如果当前节点是叶节点并且差值刚好等于当前叶节点的val，
	 * 那么把cache缓冲中的数字复制一遍，添加到result中
	 * 基本思路和PathSum一样
	 * 
	 * test1:3ms, beats 89.34%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        helper(root, result, cache, sum);
        return result;
    }

	private void helper(TreeNode t, List<List<Integer>> result, List<Integer> cache, int sum) {
		if(t == null) {
			return;
		}
		else if(t.left == null && t.right == null && t.val == sum) {
			List<Integer> oneAns = new ArrayList<>(cache);
			oneAns.add(t.val);
			result.add(oneAns);
			return;
		}
		cache.add(t.val);
		helper(t.left, result, cache, sum - t.val);
		helper(t.right, result, cache, sum - t.val);
		cache.remove(cache.size() - 1);
	}
}
