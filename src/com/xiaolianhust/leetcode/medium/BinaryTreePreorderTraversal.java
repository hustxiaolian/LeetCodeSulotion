package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Ȩ������״̬����ϰ����ʼ�úø���С�
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

	private void helper(TreeNode t, List<Integer> result) {
		if(t == null)
			return;
		
		result.add(t.val);
		helper(t.left, result);
		helper(t.right, result);
	}
}
