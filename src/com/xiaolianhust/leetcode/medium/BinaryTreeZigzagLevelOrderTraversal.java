package com.xiaolianhust.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 也就是在完成层序遍历的基础上，奇数层先判断右子树，在判断添加左子树.
	 * 偶数层反之。增添一个标记，然后使用switch语句，根据flag的奇偶性来选择左右。
	 * 
	 * test1:2ms, beat 88.54%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> nextOrder = new LinkedList<>();
        int cnt, flag;
        
        cnt = 1;
        flag = 0;
        queue.add(root);
        while(cnt != 0) {
        	List<Integer> oneAns = new ArrayList<>();
        	for(int i = 0;i < cnt; ++i) {
        		TreeNode curr = queue.removeFirst();
        		switch(flag++ % 2) {
        		case 0:
        			if(curr.left != null) nextOrder.addFirst(curr.left);
        			if(curr.right != null) nextOrder.addFirst(curr.right);
        			break;
        		case 1 :
        			if(curr.right != null) nextOrder.addFirst(curr.right);
        			if(curr.left != null) nextOrder.addFirst(curr.left);
        			break;
        		
        		}
        		oneAns.add(curr.val);
        	}
        	queue.addAll(nextOrder);
        	nextOrder.clear();
        	result.add(oneAns);
        	cnt = queue.size();
        }
        return result;
    }

}
