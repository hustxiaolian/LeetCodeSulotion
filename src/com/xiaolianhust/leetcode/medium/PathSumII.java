package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class PathSumII {
	/**
	 * ˼·��
	 * ���ĵݹ�˼·���ڵݹ����µĹ����У����㵱ǰ·������sum�Ĳ�ֵ�������ǰ�ڵ���Ҷ�ڵ㲢�Ҳ�ֵ�պõ��ڵ�ǰҶ�ڵ��val��
	 * ��ô��cache�����е����ָ���һ�飬��ӵ�result��
	 * ����˼·��PathSumһ��
	 * 
	 * test1:3ms, beats 89.34%��=��=��=��(�b��b;)��
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        helper(root, result, cache, sum);
        return result;
    }

	private void helper(TreeNode t, List<List<Integer>> result, List<Integer> cache, int sum) {
		if(t == null) {
			return;
		}
		else if(t.left == null && t.right == null && t.val == sum) {
			List<Integer> oneAns = new ArrayList<>(cache);
			oneAns.add(t.val);
			result.add(oneAns);
			return;
		}
		cache.add(t.val);
		helper(t.left, result, cache, sum - t.val);
		helper(t.right, result, cache, sum - t.val);
		cache.remove(cache.size() - 1);
	}
}
