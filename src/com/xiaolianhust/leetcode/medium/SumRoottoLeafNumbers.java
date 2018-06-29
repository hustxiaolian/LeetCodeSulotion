package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 递归的思路，遍历每种可能，到了叶节点上，返回值传回上层。
	 * 
	 * 思路还是很清晰的，没什么很大的难度，关键就是要新想清楚一个简单的示例，然后考虑特殊情况。
	 * test1:1ms, beats 80.50%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
        if(root == null)
        	return 0;
        return helper(root, 0);
    }
	
	/**
	 * 
	 * @param left
	 * @param val
	 * @return
	 */
	private int helper(TreeNode t, int currSum) {
		if(t == null)
			return 0;
		else if(t.left == null && t.right == null)
			return currSum * 10 + t.val;
		int newSum = currSum * 10 + t.val;
		return helper(t.left, newSum) + helper(t.right, newSum);
	}
}
