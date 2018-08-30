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
	 * 思路：
	 * 无非就是先序遍历。
	 * 当然，递归思路是很简单的，那么迭代思路，我想想二叉树的迭代怎么写的。
	 * 
	 * 迭代思路：这不就是反向的层序遍历，从高向下，从result末尾开始addfirst，然后每层从右往左
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
		//基准，非空，空时返回
		if(t == null)
			return;
		//一般情形
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
