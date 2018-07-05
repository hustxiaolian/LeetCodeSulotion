package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.easy.RemoveDuplicatesfromSortedList.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ���ǲ������������汾��Ψһ���鷳����ÿ���ж�ȷ���ͣ��������ͷ��ʼ������Ѱ�Ҳ���λ�á�
	 * 
	 * test1:8ms, beats 98.91%��=��=��=��(�b��b;)��
	 * �²��м��в���������ԭ���ǣ�����������ÿ��ÿ����ǰ����λ�ã��������кܶ�����ָ�������
	 * 
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
		if(head == null) return null;
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode p = head.next, pre = head;
        while(p != null) {
        	if(p.val < pre.val) {
        		ListNode inp = header;
            	while(p.val > inp.next.val) 
            		inp = inp.next;
        		pre.next = p.next;//remove
        		p.next = inp.next;//insert
        		inp.next = p;
        		p = pre.next;
        	}
        	else {
        		p = p.next;
            	pre = pre.next;
        	}
        }
        return header.next;
    }

}
