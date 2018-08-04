package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.xiaolianhust.leetcode.medium.BinaryTreeInorderTraversal.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}
	
	/**
	 * ˼·��
	 * ͨ�����У�ʹ�ò����������ȡÿ�����Ҷ˵Ĳ��֡�
	 * 
	 * test1:2ms, beats 13.53%
	 * ����ԭ��ʹ�����������У��ٶ��Ͽ϶���������Ҳ������֮�١�
	 * �Ľ��ķ������������ˣ���ÿһ��Ŀ��ˣ�queue.size������Ӧ�˵�ǰ�����Ľڵ������
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        queue.add(root);
        queue2.add(1);
        while(!queue.isEmpty()) {
        	TreeNode curr = queue.removeFirst();
        	int currNum = queue2.removeFirst();
        	if(curr.left != null) {
        		queue.addLast(curr.left);
        		queue2.addLast(currNum + 1);
        	}
        	if(curr.right != null) {
        		queue.addLast(curr.right);
        		queue2.addLast(currNum + 1);
        	}
        	if(queue2.peek() == null || currNum != queue2.peek())
        		result.add(curr.val);
        }
        return result;
    }
	
	/**
	 * 1. ��������Ҳ������û���뵽�ĵط������ǲ��������һ��Ҫ�����ң���ȫ���Դ��ҵ���
	 * ��������һ�㿪ʼ����������һ������ұߵĽڵ㡣
	 * 
	 * 2. Ҳ��������˵�ģ�ÿ�㿪ʼ��ʱ��queue.size����Ҳ���ǵ�ǰ��Ľڵ����
	 * 
	 * test2: 1ms, beats 75.63%��=��=��=��(�b��b;)��
	 * 
	 * ������ǰ�ţ����еݹ�˼·�����Լ����룬��ô
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView2(TreeNode root){
		List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	result.add(queue.peek().val);
        	for(int i = 0;i < size;++i) {
        		TreeNode curr = queue.poll();
        		if(curr.right != null)
        			queue.addLast(curr.right);
        		if(curr.left != null)
        			queue.addLast(curr.left);
        	}
        }
        return result;
	}

}
