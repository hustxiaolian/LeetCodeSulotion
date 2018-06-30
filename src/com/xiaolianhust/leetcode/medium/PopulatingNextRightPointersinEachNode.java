package com.xiaolianhust.leetcode.medium;

public class PopulatingNextRightPointersinEachNode {
	
	public static class TreeLinkNode{
		public int val;
		public TreeLinkNode left, right, next;
		public TreeLinkNode(int x) { val = x; }
	}
	/**
	 * 第一种思路：
	 * 看清楚题意，暗示要用递归，并且树是完美二叉树，即所有叶节点都在同一层，而且每个父节点都有两个儿子
	 * 核心思路：递归思路，先完成左边，再完成右边，而后再做融合
	 * 
	 * test1:1ms, beats 77.75%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 看了discuss的思路，前排基本都不是递归思路，我也学习下迭代的思路。
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
        if(root == null)
        	return;
        helper(root);
    }
	
	/**
	 * 
	 * @param root
	 */
	private void helper(TreeLinkNode t) {
		//基准条件,判断到达叶节点
		if(t.left == null && t.right == null) {
			return;
		}
		helper(t.left);
		helper(t.right);
		connectWithTwoSubTree(t.left, t.right);
	}
	
	/**
	 * 连接左右子树的next
	 * @param left
	 * @param right
	 */
	private void connectWithTwoSubTree(TreeLinkNode left, TreeLinkNode right) {
		while(left != null && right != null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
	}
	
	/**
	 * 核心思路：
	 * 从上至下，层层搭建起next，这样搭建下一层的时候，可以利用上一层搭建的next指针，遍历上一层。
	 * @param root
	 */
	public void connect2(TreeLinkNode root) {
		TreeLinkNode currLevelStart = root;
		while(currLevelStart != null) {
			TreeLinkNode p = currLevelStart;
			while(p != null) {
				if(p.left != null)
					p.left.next = p.right;
				if(p.right != null && p.next != null) 
					p.right.next = p.next.left;
				p = p.next;
			}
			currLevelStart = currLevelStart.left;
		}
	}
}
