package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ��������������������������θı�����ָ�뼴�ɡ�
	 * Ψһ�ļ���������prep, p,nextp�������õĳ�ʼ���Լ���while�е�˳��
	 * ���Ա���һЩ����Ҫ���жϡ�
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode prep = header, p = head, nextp;
        
        while(p != null) {
        	nextp = p.next;
        	p.next = prep;
        	prep = p;
        	p = nextp;
        }
    	header.next.next = null;
    	header.next = prep;
        return header.next;
    }
}
