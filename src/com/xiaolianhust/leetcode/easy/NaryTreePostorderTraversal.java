package com.xiaolianhust.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * �޷Ǿ������������
	 * ��Ȼ���ݹ�˼·�Ǻܼ򵥵ģ���ô����˼·��������������ĵ�����ôд�ġ�
	 * 
	 * ����˼·���ⲻ���Ƿ���Ĳ���������Ӹ����£���resultĩβ��ʼaddfirst��Ȼ��ÿ���������
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

	private void helper(List<Integer> result, Node t) {
		//��׼���ǿգ���ʱ����
		if(t == null)
			return;
		//һ������
		for(Node node : t.children) {
			helper(result, node);
		}
		result.add(t.val);
	}
	
	public List<Integer> postorder2(Node root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			root = stack.pop();
			result.add(root.val);
			for(Node node : root.children) {
				stack.add(node);
			}
		}
		Collections.reverse(result);
		return result;
	}
}
