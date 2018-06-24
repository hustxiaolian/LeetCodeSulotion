package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ���ݶ��壬��ƽ������ÿ���ڵ�����������ĸ߶�֮�����1��
	 * ���ݽṹ���ϣ�ƽ��������ÿ�β����ɾ���ǣ��ڵ�ǰ·���µݹ����ϸ��¡�
	 * Ҳ��˵��������ҵ���һ���ݹ����²�ѯ���µ�Ұ·��.
	 * ���������ÿ�μ���max(two subtree height) + 1.
	 * 
	 * �����ж��Ϳ��ԣ��Ӹ��ڵ�����ֱ��Ҷ�ڵ㣬��ôƽ����������
	 * 
	 * �ѵ����ڣ��߶�����Ҫ��Ҷ�ڵ����ϲ��ܼ�������ġ�
	 * ��������һ����̬�ڲ���ʵ����ͬʱ���ݸ߶ȺͲ���ֵ�����������϶����������ý��붼֪����
	 * test1: 3ms, beats 34.17%��=��=��=��(�b��b;)��
	 * ���ҿ���discuss���У�ѧϰ�¡�
	 * 
	 * discuss���룺
	 * �ۣ����뵽�������ַ�ʽ����-1�����ݣ�����û��ô������������̫���ᡣ����ʹ���-1��Ϊ��־���ɣ���ȫ�����½�һ�����������ʾ��
	 * ��ʵ˼·��������ȫһ���Ķ
	 * test2: 2ms, beat 85.84%
	 * 
	 * tets
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		HeightAndBool hb = helper(root);
		return hb.isBalanced;
    }
	
	private static class HeightAndBool{
		int height;
		boolean isBalanced;
		HeightAndBool(int height, boolean isBalanced) {
			super();
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

	private HeightAndBool helper(TreeNode t) {
		if(t == null)
			return new HeightAndBool(0, true);
		else if(t.left == null && t.right == null) {
			return new HeightAndBool(1, true);
		}
		HeightAndBool left = helper(t.left);
		HeightAndBool right = helper(t.right);
		
		
		if(Math.abs(left.height - right.height) > 1 || !left.isBalanced || !right.isBalanced)
			return new HeightAndBool(-1, false);
		
		return new HeightAndBool(Math.max(left.height, right.height) + 1, true);
	}
	
	public boolean isBalanced2(TreeNode root) {
		return helper2(root) != -1;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	private int helper2(TreeNode t) {
		if(t == null)
			return 0;
		
		int left = helper2(t.left);
		int right = helper2(t.right);
		if(left == - 1|| right == -1 || Math.abs(left - right) > 1)
			return  -1;
		
		return Math.max(left, right) + 1;
	}

}
