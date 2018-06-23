package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ��һ��ָ�����µݹ飬ÿ�����µݹ�ʱ��+1����ָ�뵽��nullʱ����¼�����
	 * ����1������ֵ���õ����⣺�����������͵Ĵ��ݣ�ʱ���÷���ֵ���ݣ���Ҫϰ���Ե�ʹ��ָ�����ô��ݵ�����
	 * test1:1ms, beat 84.77%��=��=��=��(�b��b;)��
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
