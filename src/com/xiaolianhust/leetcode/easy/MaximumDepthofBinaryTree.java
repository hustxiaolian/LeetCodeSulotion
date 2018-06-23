package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 用一个指针向下递归，每当向下递归时，+1，当指针到达null时，记录到结果
	 * 错误1；还是值引用的问题：基本数据类型的传递，时采用返回值传递，不要习惯性地使用指针引用传递的那套
	 * test1:1ms, beat 84.77%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		int result = 0;
		result = notePathDepth(root, 0);
		return result;
    }

	private int  notePathDepth(TreeNode t, int currDepth) {
		if(t == null) {
			return currDepth;
		}
		return Math.max(notePathDepth(t.left, currDepth + 1), notePathDepth(t.right, currDepth + 1));
	}

}
