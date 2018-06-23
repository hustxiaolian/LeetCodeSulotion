package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ��һ��˼·��
	 * �����Ƶ���Ŀ����ò�������ݽṹ���㷨���۵������ᵽ����ʹ�ú������������.
	 * ���岽�裺
	 * 1. ���Ȱ�root�������.
	 * 2. ȡ����������ǰ��Ľڵ㡣�ж����Ƿ������ҽڵ㡣�еĻ����������
	 * 3. ���ѭ��Ϊ������µ������ڲ�Ϊ��ǰ��������нڵ�ı�����
	 * 
	 * test1: 2ms, beats 96.27%��=��=��=��(�b��b;)��
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		//��ʼ�����������Ҵ����������
		LinkedList<List<Integer>> result = new LinkedList<>();
		if(root == null) return result;
		LinkedList<TreeNode> queue = new LinkedList<>();
		int cnt = 1;//��¼��ǰ����£��ڵ�ĸ���
		//�����ڵ���������
		queue.add(root);
		while(cnt != 0) {
			int nextCnt = 0;//��¼��һ������½ڵ�ĸ���
			List<Integer> oneAns = new ArrayList<>();
			for(int i = 0;i < cnt;++i) {
				TreeNode t = queue.removeFirst();
				oneAns.add(t.val);
				if(t.left != null) {
					++nextCnt;
					queue.addLast(t.left);
				}
				if(t.right != null) {
					++nextCnt;
					queue.addLast(t.right);
				}
			}
			result.addFirst(oneAns);
			cnt = nextCnt;
		}
        return result;
    }

}
