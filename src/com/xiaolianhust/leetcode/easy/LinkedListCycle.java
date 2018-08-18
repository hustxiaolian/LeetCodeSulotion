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
	 * ˼·��
	 * ������˼·�������������ˣ�����discuss���ӣ���
	 * ������ָ�룬һ��һ��ǰ��������һ��һ��ǰ��һ���������������ɻ�����ô�ض���ٳ�������������ȥ��
	 * ����һ�죬������ָ���������ײ��һ��
	 * 
	 * test1: 0ms, beats 100%��=��=��=��(�b��b;)��
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
