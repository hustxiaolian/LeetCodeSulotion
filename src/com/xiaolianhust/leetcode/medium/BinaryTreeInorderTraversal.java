package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * 第一种思路：
	 * 这道题还是很简单的。就是最基本的递归书写。
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
        traver(root, result);
        return result;
    }

	private void traver(TreeNode t, List<Integer> result) {
		if(t == null) {
			return;
		}
		
		traver(t.left, result);
		result.add(t.val);
		traver(t.right, result);
	}
	
	
}
