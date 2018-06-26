package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 还是递归那套思路。
	 * 在每个子树的根节点判断，判断t.val > left && t.val < right.val
	 * 然后递归到左右子树中。
	 * 
	 * bug 1：忘记树序性的某些性质。
	 * bug 2:当树是两个Integer.MIN_VALUE的节点时，我之前在left，right和midVal使用的时int类型，会发生负值溢出。
	 * 
	 * test1:1ms, beats 97.67%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	private boolean helper(TreeNode root, long left, long right) {
		if(root == null)
			return true;
		long midVal = root.val;
		if(left <= midVal && midVal <= right)
			return helper(root.left, left, midVal - 1) && helper(root.right, midVal + 1, right);
		else
			return false;
	}
	
	
}
