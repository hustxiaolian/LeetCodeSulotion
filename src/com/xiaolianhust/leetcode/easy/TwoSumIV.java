package com.xiaolianhust.leetcode.easy;

import java.util.HashSet;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class TwoSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 暂时的思路：
	 * 按照two sum 1的思想，two-pass，第一遍，遍历所有的节点存储在set中，第二遍检查。
	 * test1： 35ms, beats 5.89% ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 卧槽，犯傻了，明明可以one-pass,边检查边记录即可，二了。
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<>();
		helper1(set, root);
        return helper2(root, set, k);
    }
	
	private boolean helper2(TreeNode t, HashSet<Integer> set, int k) {
		if(t == null)
			return false;
		
		return (k != 2 * t.val && set.contains(k - t.val))
				|| helper2(t.left, set, k) 
				|| helper2(t.right, set, k);
	}

	/**
	 * 
	 * @param set
	 * @param t
	 */
	private void helper1(HashSet<Integer> set, TreeNode t) {
		if(t == null) {
			return;
		}
		set.add(t.val);
		helper1(set, t.left);
		helper1(set, t.right);
	}
	
	/**
	 * 思路：
	 * one-pass，明明可以一遍做到的事情，为什么要过两边。
	 * 
	 * test1: 27ms, beats 15.17%  ε=ε=ε=┏(゜ロ゜;)┛
	 * 和大佬代码一样，就是要慢这么多，也是很无奈。但是没办法，论文要紧。毕业要紧。
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget2(TreeNode root, int k) {
		return helper3(root, k , new HashSet<>());
	}
	
	/**
	 * 
	 * @param t
	 * @param k
	 * @param set2
	 * @return
	 */
	private final boolean helper3(TreeNode t, int k, HashSet<Integer> set) {
		if(t == null)
			return false;
		if(set.contains(k - t.val))
			return true;
		set.add(t.val);
		return helper3(t.left, k, set) || helper3(t.right, k, set);
	}
}
