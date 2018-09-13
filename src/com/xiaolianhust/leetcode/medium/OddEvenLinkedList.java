package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * 1. ��������header,һ���������������ڵ㣬һ����������ż���ڵ㡣
	 * 2. ����head�������ȰѸýڵ����h1�����У����������ڽڵ����ȷָ���ϵ��ż���ڵ���ͬ
	 * 3. ������ɺ󣬰�������ǰ��ż���ں�������һ��
	 * 
	 * test1: 6ms, ��=��=��=��(�b��b;)��
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode p = head, p1 = h1, p2 = h2;
        
        while(p != null) {
        	//����
        	p1.next = p;
        	p = p.next;
        	p1 = p1.next;
        	//ż��
        	if(p != null) {
        		p2.next = p;
        		p = p.next;
        		p2 = p2.next;
        	}
        }
        p1.next = h2.next;
        p2.next = null;
        return h1.next;
    }
}
