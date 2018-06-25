package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ���ǵݹ�����˼·��������������������һ��·���ϵ�sum - ��ǰ����root.val��Ȼ����µ�ֵ�ݹ鵽
	 * ���������ϡ�
	 * 
	 * bug 1:ע�⵽һ��Ҫ��Ҷ�ڵ㣬node.val == sum�����ж��ɹ�������true
	 * 
	 * test1: 1ms, beat 99.09%��=��=��=��(�b��b;)��
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
