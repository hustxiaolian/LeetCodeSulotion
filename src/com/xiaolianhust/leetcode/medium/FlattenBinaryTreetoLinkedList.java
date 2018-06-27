package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ����ȫ��˼·�ڲݸ�ֽ�ϣ���ͷ����������ȥ��
	 *
	 * test1:17ms, beats 76.34%��=��=��=��(�b��b;)��
	 * 
	 * �ܽ᣺���������������һСʱ��˼·ֻ����15min�����Ǻ������뻨���˷ǳ������ı���͵���ʱ�䡣
	 * ��Ҫԭ���ǣ���ֽ�������̫�򵥣������е�ƫ�����һ�㣬���ǵ������Ժ������ݡ�
	 * ��һ�Σ�����������Ĳ�ͬ�ĵݹ飬������ڲ�ͬ���������ô�Ȳ����Ǽ�����ŵĴ��룬�ȷ�����Ѹ�����������ͱ߽��������
	 * ͨ��֮���ٿ��ǹ�һ���������š�
	 * @param root
	 */
	public void flatten(TreeNode root) {
		if(root == null) return;
		helper(root);
    }
	
	/**
	 * ˼·��
	 * �ݹ��ÿ������Ӧ����ƽ��˼�롣
	 * ��Ҫ��Ҫע�����ֲ�ͬ��״��������£�����ò��ò�ͬ�Ĵ����Դ���ͬ�����
	 * 
	 * ֮ǰ��������һ�����죬�������������һ�������´�����Ը�������������޷�������ȷ����
	 * ��ϸ���������ǿ��Է��ַ�Ϊ�������
	 * 1. ���������ӣ����Ҷ��õݹ���ƽ��֮�󣬽�����ƴ���ϣ�Ȼ�󷵻�β�ڵ㣨Ҳ�������������ص�tail��
	 * 2. ֻ������ӣ���ôֻ������ӵݹ���ƽ��Ȼ����ת�Ƶ��ұߣ�����tail
	 * 3. ֻ���Ҷ��ӣ���ôֱ�Ӷ��Ҷ��ӵݹ���ƽ���У�����Ҫ����������
	 * 4. û�ж��ӣ�Ҷ�ڵ㣬ֱ�ӷ��ء�
	 * 
	 * 
	 * 
	 * 
	 * @param t
	 * @return ��������ƽ���β�ڵ�
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
