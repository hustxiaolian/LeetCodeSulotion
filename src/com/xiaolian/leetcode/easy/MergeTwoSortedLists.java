package com.xiaolian.leetcode.easy;

/**
 * 
 * @author 25040
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路：其实就是归并排序中的merge例程。
	 * 运行结果：16ms，  beat 71.32%
	 * 
	 * 看了前排的答案，比我运行更快的原因是因为它们不是重新生成了一个链表，而是在原来链表节点对象的基础上，改变了引用。
	 * 思路都一样。我个人觉得我这样比较合适：没有改变原本对象。
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode p = result;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else {
				p.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			p = p.next;
		}
		
		while(l1 != null) {
			p.next = new ListNode(l1.val);
			l1 = l1.next;
			p = p.next;
		}
		
		while(l2 != null) {
			p.next = new ListNode(l2.val);
			l2 = l2.next;
			p = p.next;
		}
		
		return result.next;
	}

}
