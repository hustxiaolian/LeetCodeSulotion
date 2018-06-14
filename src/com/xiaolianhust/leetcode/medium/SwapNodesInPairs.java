package com.xiaolianhust.leetcode.medium;

/**
 * 
 * @author 25040
 * Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private static class ListNode {
		@SuppressWarnings("unused")
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	/**
	 * ��һ��˼·��
	 * 1. ���������ڵ��������ã�ѭ���ı�ڵ�����ã����ﵽĿ�ġ�
	 * test1��8ms, beats 2.48%(Ц)
	 * test2: 5ms��beats 85.13%(��)
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs(ListNode head) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode i = header, j = head;
        
        while(j != null && j.next != null) {
        	i.next = j.next;
        	i = i.next;
        	j.next = i.next;
        	i.next = j;
        	i = j;
        	j = j.next;
        }
		
		return header.next;
    }

}
