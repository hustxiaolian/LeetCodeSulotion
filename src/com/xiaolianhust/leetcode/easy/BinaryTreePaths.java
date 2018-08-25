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
	 * 思路：
	 * 一个比较经典的递归过程。直接用list当成cache来记录即可。到底了就生成一个新的结果。
	 * 
	 * test1:19ms, beast 2.22% ε=ε=ε=┏(゜ロ゜;)┛
	 * 是不是以后我做leetcode都要把其他程序关掉，尼玛，程序差不多，速度怎么就是慢一些。随意把。
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
