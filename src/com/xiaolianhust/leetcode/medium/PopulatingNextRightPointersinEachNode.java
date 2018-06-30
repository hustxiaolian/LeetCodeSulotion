package com.xiaolianhust.leetcode.medium;

public class PopulatingNextRightPointersinEachNode {
	
	public static class TreeLinkNode{
		public int val;
		public TreeLinkNode left, right, next;
		public TreeLinkNode(int x) { val = x; }
	}
	/**
	 * ��һ��˼·��
	 * ��������⣬��ʾҪ�õݹ飬��������������������������Ҷ�ڵ㶼��ͬһ�㣬����ÿ�����ڵ㶼����������
	 * ����˼·���ݹ�˼·���������ߣ�������ұߣ����������ں�
	 * 
	 * test1:1ms, beats 77.75%��=��=��=��(�b��b;)��
	 * 
	 * ����discuss��˼·��ǰ�Ż��������ǵݹ�˼·����Ҳѧϰ�µ�����˼·��
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
        if(root == null)
        	return;
        helper(root);
    }
	
	/**
	 * 
	 * @param root
	 */
	private void helper(TreeLinkNode t) {
		//��׼����,�жϵ���Ҷ�ڵ�
		if(t.left == null && t.right == null) {
			return;
		}
		helper(t.left);
		helper(t.right);
		connectWithTwoSubTree(t.left, t.right);
	}
	
	/**
	 * ��������������next
	 * @param left
	 * @param right
	 */
	private void connectWithTwoSubTree(TreeLinkNode left, TreeLinkNode right) {
		while(left != null && right != null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
	}
	
	/**
	 * ����˼·��
	 * �������£������next���������һ���ʱ�򣬿���������һ����nextָ�룬������һ�㡣
	 * @param root
	 */
	public void connect2(TreeLinkNode root) {
		TreeLinkNode currLevelStart = root;
		while(currLevelStart != null) {
			TreeLinkNode p = currLevelStart;
			while(p != null) {
				if(p.left != null)
					p.left.next = p.right;
				if(p.right != null && p.next != null) 
					p.right.next = p.next.left;
				p = p.next;
			}
			currLevelStart = currLevelStart.left;
		}
	}
}
