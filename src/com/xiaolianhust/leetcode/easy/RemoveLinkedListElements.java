package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * �����������������Ͽ�������ô�򵥣��Ҿ��ü�ֱ�ж���
	 * 
	 * test1:5ms, beat 13.66%��=��=��=��(�b��b;)��
	 * ÿ�����ֺܼ򵥵����⣬���ǣ��Ҹо��ҵĴ���ʵ����û�����������
	 * ��ɧ���ǣ��Ҿ���ǰ�Ÿ����Ͳ���Ŷԡ�
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode p = head, pre = header;
        
        while(p != null) {
        	if(p.val == val) 
        		pre.next = p.next;
        	else 
        		pre = p;
        	p = p.next;
        }
        
        return header.next;
    }
}
