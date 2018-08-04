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
	 * 思路：
	 * 通过队列，使用层序遍历，获取每层最右端的部分。
	 * 
	 * test1:2ms, beats 13.53%
	 * 慢的原因：使用了两个队列，速度上肯定会慢，我也是无奈之举。
	 * 改进的方法。我忘记了，在每一层的开端，queue.size（）反应了当前层数的节点个数。
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
	 * 1. 这里的妙处，也就是我没有想到的地方，就是层序遍历不一定要从左到右，完全可以从右到左，
	 * 这样，下一层开始的起点就是下一层的最右边的节点。
	 * 
	 * 2. 也就是上面说的，每层开始的时候，queue.size（）也就是当前层的节点个数
	 * 
	 * test2: 1ms, beats 75.63%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 看了下前排，还有递归思路。我自己想想，怎么
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
