package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ���������Ѿ�������˵ģ���ô��������Ϊƽ�����ķ�������
	 * ÿ����mid��ֵ��Ϊ��ǰ�����ĸ��ڵ㣬Ȼ�������£������µݹ顣ֱ��left==right�ˣ�˵������Ҷ�ڵ㡣
	 * 
	 * test1:1ms, beats 100% ��=��=��=��(�b��b;)��
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		int n = nums.length;
		if(n == 0) return null;
        TreeNode header = new TreeNode(0);
        header.right = helper(header.right, 0, n - 1, nums);
        return header.right;
    }
	
	/**
	 * 
	 * @param t
	 * @param left
	 * @param right
	 * @param nums 
	 * @return
	 */
	private TreeNode helper(TreeNode t, int left, int right, int[] nums) {
		if(left > right) {
			return null;
		}
		else if(left == right) {
			return new TreeNode(nums[left]);
		}
		int mid = (left + right) / 2;
		t = new TreeNode(nums[mid]);
		t.left = helper(t.left, left, mid - 1, nums);
		t.right = helper(t.right, mid + 1, right, nums);
		return t;
	}
}
