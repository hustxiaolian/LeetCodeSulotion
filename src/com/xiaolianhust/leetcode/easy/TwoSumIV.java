package com.xiaolianhust.leetcode.easy;

import java.util.HashSet;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class TwoSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��ʱ��˼·��
	 * ����two sum 1��˼�룬two-pass����һ�飬�������еĽڵ�洢��set�У��ڶ����顣
	 * test1�� 35ms, beats 5.89% ��=��=��=��(�b��b;)��
	 * 
	 * �Բۣ���ɵ�ˣ���������one-pass,�߼��߼�¼���ɣ����ˡ�
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<>();
		helper1(set, root);
        return helper2(root, set, k);
    }
	
	private boolean helper2(TreeNode t, HashSet<Integer> set, int k) {
		if(t == null)
			return false;
		
		return (k != 2 * t.val && set.contains(k - t.val))
				|| helper2(t.left, set, k) 
				|| helper2(t.right, set, k);
	}

	/**
	 * 
	 * @param set
	 * @param t
	 */
	private void helper1(HashSet<Integer> set, TreeNode t) {
		if(t == null) {
			return;
		}
		set.add(t.val);
		helper1(set, t.left);
		helper1(set, t.right);
	}
	
	/**
	 * ˼·��
	 * one-pass����������һ�����������飬ΪʲôҪ�����ߡ�
	 * 
	 * test1: 27ms, beats 15.17%  ��=��=��=��(�b��b;)��
	 * �ʹ��д���һ��������Ҫ����ô�࣬Ҳ�Ǻ����Ρ�����û�취������Ҫ������ҵҪ����
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget2(TreeNode root, int k) {
		return helper3(root, k , new HashSet<>());
	}
	
	/**
	 * 
	 * @param t
	 * @param k
	 * @param set2
	 * @return
	 */
	private final boolean helper3(TreeNode t, int k, HashSet<Integer> set) {
		if(t == null)
			return false;
		if(set.contains(k - t.val))
			return true;
		set.add(t.val);
		return helper3(t.left, k, set) || helper3(t.right, k, set);
	}
}
