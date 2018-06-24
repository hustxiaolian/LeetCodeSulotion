package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ���ǹ��õ���·���Ӹ��ڵ�ݹ����£�Ȼ�����Ϸ���min(left,right) + 1;
	 * 
	 * ��ʼ��������һ����֪������Ϊ������С���Ϊ���ڵ��������null��·�����ȣ�����
	 * Ӧ���Ǹ��ڵ㵽������ڵ��·�����ȣ�����ȷ�������Ի���Ҫ��ȷ����
	 * 
	 * test1: 1ms, beats 99.67%��=��=��=��(�b��b;)��
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        if(root.left == null) {
        	if(root.right ==null)
        		return 1;
        	else 
        		return minDepth(root.right) + 1;
        }
        else {
        	if(root.right == null)
        		return minDepth(root.left) + 1;
        	else
        		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
