package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * 第一种思路：
	 * 这是基本的递归思路：
	 * 好久没做easy的题目了。感动啊。
	 * 
	 * test1:5ms, beats 94.31%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p == null && q == null)
			return true;
		else if(p != null && q != null && p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		else
			return false;
    }
    
    
    
}
