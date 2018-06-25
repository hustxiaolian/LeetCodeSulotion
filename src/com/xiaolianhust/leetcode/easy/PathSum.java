package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 还是递归那套思路，下面两个子树的任意一条路径上的sum - 当前树的root.val。然后把新的值递归到
	 * 两个子树上。
	 * 
	 * bug 1:注意到一定要到叶节点，node.val == sum才能判定成功，返回true
	 * 
	 * test1: 1ms, beat 99.09%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        else if(root.left == null && root.right == null && root.val == sum)
        	return true;
        int newSum = sum - root.val;
        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }

}
