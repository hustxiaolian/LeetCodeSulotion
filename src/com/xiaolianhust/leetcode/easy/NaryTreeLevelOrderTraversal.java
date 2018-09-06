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
	 * 思路：使用queue层序遍历
	 * 每一层遍历之间，通过size()函数是可以知道这层有多少个节点。
	 * 
	 * test: 9ms, beats 15.84% ε=ε=ε=┏(゜ロ゜;)┛
	 * 总结：
	 * 这么看来BFS在某种程序上来说，存在一种特定的格式。尤其是使用queue的这种形式。
	 * 树的层序遍历在一定程序不就是一个慢慢扩大，扩散的图的遍历形式吗。真的很有意思。
	 * 
	 * 同时:这个速度慢，绝对和我多开了程序有很大的关联。明明是一样的代码。
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
