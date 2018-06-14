package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author 25040
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 * 
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(6));
	}
	
	static class Node{
		String val;
		Node leftNode;
		Node rightNode;
		int openNum;
		
		public Node(String val, Node leftNode, Node rightNode, int openNum) {
			super();
			this.val = val;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.openNum = openNum;
		}
	}
	
	/**
	 * ��һ��˼·��
	 * ����⣬����ʱû���ر�õ�˼·�������ڼ򵥵�˼·�ǿ��������ſ��ܳ��ֵ�����λ�ã�Ȼ������λ������������䡣
	 * ����ջ�ж�����ȷ�ԡ����ȣ���һ������һ���������ţ���ʣ�µ�n - 1�������ţ���С���ܳ��ֵ�������ֻ���ǵ����ڶ�λ��
	 * 
	 * �ڶ���˼·��
	 * ����һ����������ÿ���ڵ��Ӧ��һ�������Ż��������ţ�ÿ���root��������·�����������string��
	 * ͬʱ���������ÿ��·������ȶ���n��������;ÿ���ڵ�Ŀ��ȣ�·���������ŵĸ��� - �����ŵĸ��������Ǵ��ڵ�����
	 * 
	 * @version 1.0 ����ʱ�䣺4ms, beats 52.71%��
	 * ���������˼·�����Ϻʹ����ƣ���ͬ���ǣ���ò���˷��˴����Ŀռ��ʱ�䣬����new�ڵ㣬���ԲŻ������������
	 * ����ֵ�ÿ϶����ǣ��ҵ�˼·�ǶԵģ�����������ͷ��ϸ���о��´𰸵ķ������ú�ѧϰ�ܽ��¡�
	 * 
	 * @param n
	 * @return
	 */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateTree(n, result);
    	return result;
    }
    
    public static Node generateTree(int n, List<String> result) {
    	Node root = new Node(null, null, null, 0);
    	//�����һ���ڵ�
    	root.leftNode = new Node("(", null, null, root.openNum + 1);
    	builtTree(root.leftNode, n - 1, n, result);
    	return root.leftNode;
    }

    public static void builtTree(Node node, int left, int right, List<String> result) {
    	if(left == 0 && right == 0) {
    		result.add(node.val);
    		return;
    	}
    		
    	if(left > 0) {
    		node.leftNode = new Node(node.val + "(", null, null, node.openNum + 1);
    		builtTree(node.leftNode, left - 1, right, result);
    	}
    	if(node.openNum > 0) {
    		node.rightNode = new Node(node.val + ")", null, null, node.openNum - 1);
    		builtTree(node.rightNode, left, right - 1, result);
    	}
    }
}
