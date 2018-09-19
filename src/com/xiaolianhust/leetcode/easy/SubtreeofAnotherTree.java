package com.xiaolianhust.leetcode.easy;

import java.util.HashMap;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class SubtreeofAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer s = null, t = null;
		System.out.println(s == t);
	}
	
	/**
	 * ˼·��
	 * 1. ���ȹ���������s��ÿ���ڵ����ߵ�����Ȼ������t���ĸ߶ȡ�
	 * 2. ���±ȶԵĹ����У����ȱȶ����ߡ������ǰ���£��ȶ�ÿ���ڵ��Ƿ���ͬ��
	 * 
	 * test1: 18ms
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        helper(s, map);
        int tHeight = helper2(t);
        return helper3(s, t, map, tHeight);
    }
	
	private boolean helper3(TreeNode s, TreeNode t, HashMap<TreeNode, Integer> map, int tHeight) {
		if(s == null)
			return false;
		
		int currH = map.get(s);
		if(currH < tHeight)
			return false;
		else if(currH > tHeight) {
			return helper3(s.left, t, map, tHeight) || helper3(s.right, t, map, tHeight);
		} else {
			return helper4(s, t);
		}
		
	}

	private boolean helper4(TreeNode s, TreeNode t) {
		if(s == null) {
			if(t == null)
				return true;
			else
				return false;
		} else {
			if(t == null || t.val != s.val)
				return false;
			return helper4(s.left, t.left) && helper4(s.right, t.right);
		}
	}

	private int helper2(TreeNode t) {
		if(t == null)
			return 0;
		return Math.max(helper2(t.left), helper2(t.right)) + 1;
	}

	/**
	 * �������������map
	 * @param s
	 * @param map
	 */
	private int helper(TreeNode s, HashMap<TreeNode, Integer> map) {
		if(s == null)
			return 0;
		int left = helper(s.left, map);
		int right = helper(s.right, map);
		int currVal = Math.max(left, right) + 1;
		map.put(s, currVal);
		return currVal;
	}
	
	/**
	 * ˼·���ǳ�ֱ�ӵĵݹ�˼·��
	 * ���t����ÿ���ڵ㶼�Ƚ�����t���Ƿ���ȫ��ͬ�������Ķ�������ȫ��ͬ
	 * 
	 * test:29ms, Ҳ��˵�������ʹ�������˼·�����ܸ��졣
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubtree2(TreeNode s, TreeNode t) {
		if(s == null) return false;//ע�⣬���ﲻ��ʡ�ԣ������ʱ�ݹ鵽sΪnull����ô����s.left�ͻ�����⡣
		if(isSameTree(t, s)) return true;
		return isSubtree2(s.left, t) || isSubtree2(s.right, t);
	}

	private boolean isSameTree(TreeNode t, TreeNode s) {
		if(t == null && s == null)
			return true;
		if(t == null || s == null)
			return false;
		if(t.val != s.val)
			return false;
		return isSameTree(t.left, s.left) && isSameTree(t.right, s.right);
	}
}
