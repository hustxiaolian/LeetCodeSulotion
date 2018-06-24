package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 由于它是已经排序好了的，那么将它构建为平衡树的方法就是
	 * 每次以mid的值作为当前子树的根节点，然后向左下，和右下递归。直到left==right了，说明到了叶节点。
	 * 
	 * test1:1ms, beats 100% ε=ε=ε=┏(゜ロ゜;)┛
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
