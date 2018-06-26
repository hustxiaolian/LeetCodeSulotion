package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(new int[] {4,1,2,3}, new int[] {1,2,3,4});
	}
	
	/**
	 * ��һ��˼·��
	 * �����õ���Ŀ���۲�Ѱ�ҹ��ɣ��������������������������ʣ���������
	 * ���ֵĹ��ɣ�
	 * 1. ��������£�����root�ڵ�λ��һ��subArray��pre�����ͷ��Ԫ�ء�
	 * 2. in�����У����ڵ��Ԫ�ص���߼�Ϊ������������Ԫ�أ��������ұ߼�Ϊ������������Ԫ�ء�
	 * 3. ���ֱ����£�����β�ڵ��λ�ú�Ԫ�ض���ȡ�
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
