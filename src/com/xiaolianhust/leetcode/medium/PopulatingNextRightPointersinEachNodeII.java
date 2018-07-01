package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.PopulatingNextRightPointersinEachNode.*;

public class PopulatingNextRightPointersinEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 思路和昨天的题目基本是一模一样的，只是它这次不是完美的二叉树。
	 * 输入条件变得更加多样。
	 * 
	 * 继承昨天迭代的思路：
	 * 学习昨天的迭代的思路，一层一层的递归向下。但是今天的难点在于怎么判断这么多的情况
	 * 分情况讨论：
	 * 变化的条件主要是：当前节点有无左右节点，当前层有无next节点，next节点有无子节点。
	 * 
	 * test1:2ms, 55.41%ε=ε=ε=┏(゜ロ゜;)┛
	 * 还有改进空间。就是我完成可以保存一个上一个连接的child这点，这样避免反复的next遍历，这里遍历存在一定的重复。
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
		TreeLinkNode currLevelStart = root;
		while(currLevelStart != null) {
			TreeLinkNode levelp = currLevelStart;
			TreeLinkNode nextLevelStart = null;
			while(levelp != null) {
				if(nextLevelStart == null && (levelp.left != null || levelp.right != null)) {
					nextLevelStart = levelp.left != null ? levelp.left : levelp.right;
				}
				if(levelp.left != null) {
					if(levelp.right != null)
						levelp.left.next = levelp.right;
					else
						connectWithNext(levelp.left, levelp.next);
				}
				if(levelp.right != null) {
					connectWithNext(levelp.right, levelp.next);
				}
				levelp = levelp.next;
			}
			currLevelStart = nextLevelStart;
		}
    }
	
	/**
	 * 
	 * @param left
	 * @param next
	 */
	private void connectWithNext(TreeLinkNode levelpChild, TreeLinkNode next) {
		levelpChild.next = null;
		while(next != null) {
			if(next.left != null) {
				levelpChild.next = next.left;
				break;
			}
			if(next.right != null) {
				levelpChild.next = next.right;
				break;
			}
			next = next.next;
		}
	}
	
	/**
	 * 用一个lastChild节点来保存上一个连接的child.
	 * 妙，巧用头节点，避免了下一层寻找起始的额外的多余的判断。
	 * 利用currChild节点避免重复遍历，可以跨越多个父节点连接
	 * 
	 * test1:1ms, beats 100.0%ε=ε=ε=┏(゜ロ゜;)┛
	 * 这道题就是把链表中的套路也用过来，化繁为简。学习了。
	 * @param root
	 */
	public void connect2(TreeLinkNode root) {
		TreeLinkNode currLevel = root;
		while(currLevel != null) {
			TreeLinkNode header = new TreeLinkNode(0);
			TreeLinkNode currChild = header;
			while(currLevel != null) {
				if(currLevel.left != null) {
					currChild.next = currLevel.left;
					currChild = currChild.next;
				}
				if(currLevel.right != null) {
					currChild.next = currLevel.right;
					currChild = currChild.next;
				}
				currLevel = currLevel.next;
			}
			currLevel = header.next;
		}
	}

}
