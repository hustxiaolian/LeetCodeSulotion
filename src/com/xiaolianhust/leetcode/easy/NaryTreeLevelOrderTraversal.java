package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��ʹ��queue�������
	 * ÿһ�����֮�䣬ͨ��size()�����ǿ���֪������ж��ٸ��ڵ㡣
	 * 
	 * test: 9ms, beats 15.84% ��=��=��=��(�b��b;)��
	 * �ܽ᣺
	 * ��ô����BFS��ĳ�ֳ�������˵������һ���ض��ĸ�ʽ��������ʹ��queue��������ʽ��
	 * ���Ĳ��������һ�����򲻾���һ������������ɢ��ͼ�ı�����ʽ����ĺ�����˼��
	 * 
	 * ͬʱ:����ٶ��������Ժ��Ҷ࿪�˳����кܴ�Ĺ�����������һ���Ĵ��롣
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	int n = queue.size();
        	List<Integer> oneAns = new ArrayList<>(n);
        	for(int i = 0;i < n;++i) {
        		Node curr = queue.poll();
        		oneAns.add(curr.val);
        		for(Node node : curr.children)
        			queue.offer(node);
        	}
        	result.add(oneAns);
        }
        return result;
    }
}
