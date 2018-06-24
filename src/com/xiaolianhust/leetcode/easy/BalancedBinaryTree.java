package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 根据定义，即平衡树的每个节点的两个子树的高度之差不超过1；
	 * 数据结构书上，平衡树是在每次插入和删除是，在当前路径下递归向上更新。
	 * 也就说：这道题我得想一个递归向下查询更新的野路子.
	 * 插入更新是每次计算max(two subtree height) + 1.
	 * 
	 * 那我判定就可以，从根节点向下直到叶节点，那么平衡树（错误）
	 * 
	 * 难点在于：高度是需要从叶节点向上才能计算出来的。
	 * 我是用了一个静态内部类实现了同时传递高度和布尔值，但是这样肯定会慢，我用脚想都知道。
	 * test1: 3ms, beats 34.17%ε=ε=ε=┏(゜ロ゜;)┛
	 * 让我看下discuss大佬，学习下。
	 * 
	 * discuss感想：
	 * 噗，我想到过用这种方式，即-1来传递，但是没这么做。哎，还是太年轻。错误就传递-1作为标志即可，完全不必新建一个类对象来表示。
	 * 其实思路方面是完全一样的额。
	 * test2: 2ms, beat 85.84%
	 * 
	 * tets
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		HeightAndBool hb = helper(root);
		return hb.isBalanced;
    }
	
	private static class HeightAndBool{
		int height;
		boolean isBalanced;
		HeightAndBool(int height, boolean isBalanced) {
			super();
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

	private HeightAndBool helper(TreeNode t) {
		if(t == null)
			return new HeightAndBool(0, true);
		else if(t.left == null && t.right == null) {
			return new HeightAndBool(1, true);
		}
		HeightAndBool left = helper(t.left);
		HeightAndBool right = helper(t.right);
		
		
		if(Math.abs(left.height - right.height) > 1 || !left.isBalanced || !right.isBalanced)
			return new HeightAndBool(-1, false);
		
		return new HeightAndBool(Math.max(left.height, right.height) + 1, true);
	}
	
	public boolean isBalanced2(TreeNode root) {
		return helper2(root) != -1;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	private int helper2(TreeNode t) {
		if(t == null)
			return 0;
		
		int left = helper2(t.left);
		int right = helper2(t.right);
		if(left == - 1|| right == -1 || Math.abs(left - right) > 1)
			return  -1;
		
		return Math.max(left, right) + 1;
	}

}
