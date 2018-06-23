package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 第一种思路：
	 * 定义两个指针，当a、b指针当前的值，然后当a向左，b就向右递归，判断当前值是否相同。
	 * 1. 当a,b == null时，直接返回true;
	 * 2. 当a,b != null 并且a.val == b.val时，按照上述方式递归到下一轮。
	 * 3. 否则都是false
	 * 
	 * test1:15ms, beats 82.16%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param root
	 * @return
	 */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        	return true;
    	return helper(root.left, root.right);
    }
    
    /**
     * 
     * @param left
     * @param right
     * @return
     */
	private boolean helper(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		else if(left != null && right != null && left.val == right.val) {
			return helper(left.left, right.right) && helper(left.right, right.left);
		}
		else {
			return false;
		}
	}
}
