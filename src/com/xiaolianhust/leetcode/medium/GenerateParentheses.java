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
	 * 第一个思路：
	 * 这道题，我暂时没有特别好的思路，我现在简单的思路是考虑左括号可能出现的所有位置，然后其余位置用右括号填充。
	 * 再用栈判断其正确性。首先，第一个符号一定是左括号，而剩下的n - 1个左括号，最小可能出现的左括号只能是倒数第二位。
	 * 
	 * 第二个思路：
	 * 生成一个决策树，每个节点对应于一个左括号或者右括号，每天从root到根部的路径就是所求的string。
	 * 同时，这棵树的每条路径的深度都是n，而且沿途每个节点的开度（路径上左括号的个数 - 右括号的个数）都是大于等于零
	 * 
	 * @version 1.0 运行时间：4ms, beats 52.71%。
	 * 解决方案的思路大体上和答案类似，不同的是，我貌似浪费了大量的空间和时间，用于new节点，所以才会比其他人慢。
	 * 但是值得肯定的是，我的思路是对的，进步啊，回头仔细的研究下答案的方案，好好学习总结下。
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
    	//插入第一个节点
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
