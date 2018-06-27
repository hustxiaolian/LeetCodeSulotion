package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 这里全部思路在草稿纸上，回头，我在码上去。
	 *
	 * test1:17ms, beats 76.34%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 总结：这道题我整整花了一小时，思路只花了15min，但是后续编码花费了非常大量的编码和调试时间。
	 * 主要原因是：在纸上上想的太简单，方向有点偏差，还有一点，总是单单在脑海中推演。
	 * 下一次，针对这种树的不同的递归，如果存在不同的情况，那么先不考虑简洁优雅的代码，先分情况把各种特殊情况和边界想清楚，
	 * 通过之后，再考虑归一化，更优雅。
	 * @param root
	 */
	public void flatten(TreeNode root) {
		if(root == null) return;
		helper(root);
    }
	
	/**
	 * 思路：
	 * 递归对每个子树应用拉平的思想。
	 * 主要是要注意区分不同形状子树情况下，必须得采用不同的代码以处理不同的情况
	 * 
	 * 之前，我妄想一步登天，将大量的情况归一化。导致代码针对各种特殊情况，无法做到正确处理。
	 * 仔细分析后：我们可以发现分为四种情况
	 * 1. 有两个儿子，左右都得递归拉平，之后，将他们拼接上，然后返回尾节点（也就是右子树返回得tail）
	 * 2. 只有左儿子，那么只对左儿子递归拉平，然后将它转移到右边，返回tail
	 * 3. 只有右儿子，那么直接对右儿子递归拉平就行，不需要其他动作。
	 * 4. 没有儿子，叶节点，直接返回。
	 * 
	 * 
	 * 
	 * 
	 * @param t
	 * @return 各子树拉平后的尾节点
	 */
	private TreeNode helper(TreeNode t) {
		if(t.left != null) {
			if(t.right != null) {
				TreeNode leftTreeTail = helper(t.left);
				TreeNode rightTreeTail = helper(t.right);
				leftTreeTail.right = t.right;
				t.right = t.left;
				t.left = null;
				return rightTreeTail;
			}
			else {
				TreeNode treeTail = helper(t.left);
				t.right = t.left;
				t.left = null;
				return treeTail;
			}
		}
		else {
			if(t.right != null) 
				return helper(t.right);
			else 
				return t;
		}
	}

}
