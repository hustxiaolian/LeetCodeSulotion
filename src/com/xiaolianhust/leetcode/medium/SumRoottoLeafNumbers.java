package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * �ݹ��˼·������ÿ�ֿ��ܣ�����Ҷ�ڵ��ϣ�����ֵ�����ϲ㡣
	 * 
	 * ˼·���Ǻ������ģ�ûʲô�ܴ���Ѷȣ��ؼ�����Ҫ�������һ���򵥵�ʾ����Ȼ�������������
	 * test1:1ms, beats 80.50%��=��=��=��(�b��b;)��
	 * 
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
        if(root == null)
        	return 0;
        return helper(root, 0);
    }
	
	/**
	 * 
	 * @param left
	 * @param val
	 * @return
	 */
	private int helper(TreeNode t, int currSum) {
		if(t == null)
			return 0;
		else if(t.left == null && t.right == null)
			return currSum * 10 + t.val;
		int newSum = currSum * 10 + t.val;
		return helper(t.left, newSum) + helper(t.right, newSum);
	}
}
