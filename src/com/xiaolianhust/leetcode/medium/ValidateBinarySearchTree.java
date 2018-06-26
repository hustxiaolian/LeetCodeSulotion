package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ���ǵݹ�����˼·��
	 * ��ÿ�������ĸ��ڵ��жϣ��ж�t.val > left && t.val < right.val
	 * Ȼ��ݹ鵽���������С�
	 * 
	 * bug 1�����������Ե�ĳЩ���ʡ�
	 * bug 2:����������Integer.MIN_VALUE�Ľڵ�ʱ����֮ǰ��left��right��midValʹ�õ�ʱint���ͣ��ᷢ����ֵ�����
	 * 
	 * test1:1ms, beats 97.67%��=��=��=��(�b��b;)��
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	private boolean helper(TreeNode root, long left, long right) {
		if(root == null)
			return true;
		long midVal = root.val;
		if(left <= midVal && midVal <= right)
			return helper(root.left, left, midVal - 1) && helper(root.right, midVal + 1, right);
		else
			return false;
	}
	
	
}
