package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.easy.MergeTwoSortedLists.ListNode;
import com.xiaolianhust.leetcode.medium.UniqueBinarySearchTreesII.TreeNode;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ˼·��
	 * �������Ѿ�����õģ����Ҹ����������ʣ�Ϊ�˵õ�ƽ����������ÿ�������ĸ������ǵ�ǰ��������м�
	 * 
	 * test1:3ms, beats 25.91%��=��=��=��(�b��b;)��
	 * �Ҿ�����һms���Ͳ�����ô�ࡣ������
	 * 
	 * �ĳ���final�����������ܡ�
	 * test2:2ms, beats 99.51%��=��=��=��(�b��b;)��
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
	 * �ݹ�Ĺ�����
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
	 * ��ʱ����ȥ�������NP�쳣,�������ӣ��ᵼ���ұߴ�㡣
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
