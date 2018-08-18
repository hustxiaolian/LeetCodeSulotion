package com.xiaolianhust.leetcode.easy;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	/**
	 * 思路：
	 * 这道题的思路，我老早就想好了（看了discuss，逃）。
	 * 用两个指针，一个一次前进两个，一个一次前进一个，这样如果链表成环，那么必定像操场那样，绕来绕去。
	 * 终有一天，这两个指针会相遇，撞到一起。
	 * 
	 * test1: 0ms, beats 100%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		ListNode p1 = head, p2 = head;
		while(p1 != null && p1.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
			if(p1 == p2)
				return true;
		}
		return false;
    }
}
