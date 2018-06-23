package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class SymmetricTree {
	public static void main(String[] args) {
		
	}
	
	/**
	 * ��һ��˼·��
	 * ��������ָ�룬��a��bָ�뵱ǰ��ֵ��Ȼ��a����b�����ҵݹ飬�жϵ�ǰֵ�Ƿ���ͬ��
	 * 1. ��a,b == nullʱ��ֱ�ӷ���true;
	 * 2. ��a,b != null ����a.val == b.valʱ������������ʽ�ݹ鵽��һ�֡�
	 * 3. ������false
	 * 
	 * test1:15ms, beats 82.16%��=��=��=��(�b��b;)��
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
