package com.xiaolianhust.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class BinaryTreePostorderTraversal {
	/**
	 * 这道题。。。
	 * 我实在没啥好说，这道hard有点。。。
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
	
	/**
	 * 
	 * @param root
	 * @param result
	 */
	private final void helper(TreeNode t, List<Integer> result) {
		if(t == null)
			return;
		
		helper(t.left, result);
		helper(t.right, result);
		result.add(t.val);
	}
}
