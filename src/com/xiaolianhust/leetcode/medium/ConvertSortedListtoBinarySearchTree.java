package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.easy.MergeTwoSortedLists.ListNode;
import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路：
	 * 由于是已经排序好的，并且根据树的性质，为了得到平衡树，我们每个子树的根，都是当前子链表的中间
	 * 
	 * test1:3ms, beats 25.91%ε=ε=ε=┏(゜ロ゜;)┛
	 * 我就慢了一ms，就差了这么多。晕死。
	 * 
	 * 改成了final，增加了性能。
	 * test2:2ms, beats 99.51%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		TreeNode root = null;
		root = helper(root, head, null);
        return root;
    }
	
	/**
	 * 递归的构建树
	 * @param t
	 * @param head
	 * @param tail
	 * @return
	 */
	private final TreeNode helper(TreeNode t, ListNode head, ListNode tail) {
		if(head == tail) {
			return null;
		}
		ListNode mid = searchMid(head, tail);
		t = new TreeNode(mid.val);
		
		t.left = helper(t.left, head, mid);
		t.right = helper(t.right, mid.next, tail);
		
		return t;
	}

	/**
	 * 暂时看上去不会出现NP异常,这种样子，会导致右边大点。
	 * @param head
	 * @param tail
	 * @return
	 */
	private final ListNode searchMid(ListNode head, ListNode tail) {
		ListNode mid = head;
		ListNode doubleMid = head;
		while(doubleMid.next != tail && doubleMid.next.next != tail) {
			doubleMid = doubleMid.next.next;
			mid = mid.next;
		}
		return mid;
	}
	
	
}
