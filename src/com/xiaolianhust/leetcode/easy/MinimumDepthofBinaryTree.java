package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 还是惯用的套路：从根节点递归向下，然后向上返回min(left,right) + 1;
	 * 
	 * 开始还产生了一个认知错误：认为树的最小深度为根节点能最近到null的路径长度（错误）
	 * 应该是根节点到最近树节点的路径长度，（正确），所以还是要正确读题
	 * 
	 * test1: 1ms, beats 99.67%ε=ε=ε=┏(゜ロ゜;)┛
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
