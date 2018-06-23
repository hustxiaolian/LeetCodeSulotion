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
	 * 第一种思路：
	 * 这类似的题目，我貌似在数据结构与算法导论的书上提到过。使用后今后出队列来做.
	 * 具体步骤：
	 * 1. 首先把root放入队列.
	 * 2. 取出队列中最前面的节点。判断它是否有左右节点。有的话放入队列中
	 * 3. 外层循环为深度向下迭代，内层为当前深度下所有节点的遍历。
	 * 
	 * test1: 2ms, beats 96.27%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		//初始化变量，并且处理特殊情况
		LinkedList<List<Integer>> result = new LinkedList<>();
		if(root == null) return result;
		LinkedList<TreeNode> queue = new LinkedList<>();
		int cnt = 1;//记录当前深度下，节点的个数
		//将根节点放入队列中
		queue.add(root);
		while(cnt != 0) {
			int nextCnt = 0;//记录下一个深度下节点的个数
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
