package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(new int[] {4,1,2,3}, new int[] {1,2,3,4});
	}
	
	/**
	 * 第一种思路：
	 * 首先拿到题目，观察寻找规律，根据先序遍历和中序遍历的性质，来摸索。
	 * 发现的规律：
	 * 1. 先序遍历下，子树root节点位于一段subArray的pre数组的头部元素。
	 * 2. in数组中，根节点的元素的左边即为左子树的所有元素，根结点的右边即为右子树的所有元素。
	 * 3. 两种遍历下，子树尾节点的位置和元素都相等。
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootValIndex = searchInPre(inorder, 0, n ,preorder[0]);
        root.left = helper(root.left, inorder, 0, rootValIndex - 1, preorder, 1, n);
        root.right = helper(root.right, inorder, rootValIndex + 1, n - 1, preorder, rootValIndex + 1, n);
        return root;
    }

	private TreeNode helper(TreeNode t, int[] inorder, int leftIn, int rightIn, int[] preorder, int preRootIndex, int n) {
		if(leftIn == rightIn) {
			return new TreeNode(inorder[leftIn]);
		}
		else if(leftIn > rightIn || leftIn < 0 || rightIn >= preorder.length)
			return null;
			
		t = new TreeNode(preorder[preRootIndex]);
		int rootValIndex = searchInPre(inorder, leftIn, n, preorder[preRootIndex]);
		t.left = helper(t.left, inorder, leftIn, rootValIndex - 1, preorder, preRootIndex + 1, n);
		t.right = helper(t.right, inorder, rootValIndex + 1, rightIn, preorder, preRootIndex + (rootValIndex - leftIn + 1), n);
		return t;
	}

	/**
	 * 
	 * @param inorder
	 * @param startIndex
	 * @param target
	 * @param target 
	 * @return
	 */
	private int searchInPre(int[] inorder, int startIndex, int n, int target) {
		for(int i = startIndex; i < n; ++i) {
			if(inorder[i] == target)
				return i;
		}
		throw new RuntimeException("input error");
	}
	
	
	
}
