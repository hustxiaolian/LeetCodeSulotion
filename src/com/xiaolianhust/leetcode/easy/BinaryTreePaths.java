package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("xiaolian");
		sb.delete(5, sb.length());
		System.out.println(sb.toString());
	}
	
	/**
	 * ˼·��
	 * һ���ȽϾ���ĵݹ���̡�ֱ����list����cache����¼���ɡ������˾�����һ���µĽ����
	 * 
	 * test1:19ms, beast 2.22% ��=��=��=��(�b��b;)��
	 * �ǲ����Ժ�����leetcode��Ҫ����������ص������꣬�����࣬�ٶ���ô������һЩ������ѡ�
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        StringBuffer cache = new StringBuffer();
        helper(root, cache, result);
        return result;
    }
	
	/**
	 * 
	 * @param t
	 * @param cache
	 * @param result
	 */
	private void helper(TreeNode t, StringBuffer cache, List<String> result) {
		if(t.left == null && t.right == null) {
			result.add(cache.toString() + t.val);
		} else {
			int n = cache.length();
			cache.append(t.val).append("->");
			if(t.left != null) {
				helper(t.left, cache, result);
			}
			if(t.right != null) {
				helper(t.right, cache, result);
			}
			cache.delete(n, cache.length());
		}
	}
}
