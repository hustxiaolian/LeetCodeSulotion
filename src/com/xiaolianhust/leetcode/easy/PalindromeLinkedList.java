package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ������������Ѿ������ġ����Ǹ�ϰ�¡�
	 * ˼·������
	 * 1. �������ٷֲ������ҵ�������м�㣨ע����������ڵ���������ż���Ĳ�ͬ�����
	 * 2. ����벿�ֵ�����reverse
	 * 3. Ȼ�������������һ���ԡ�
	 * 
	 * test1: 1ms, beats 98.71% ��=��=��=��(�b��b;)��
	 * 
	 * �ܽ᣺�������Ҫ�����ϸ�ڷǳ��ࡣ����˼·������Լ򵥵ġ�����ļ�������Ҫ��ס�ġ�
	 * 1. ��ͬ�����ƶ�ѡ���е㣨һ���ƶ�2����һ��ָ���ƶ�1����
	 * 2. ��ָ�뷴ת������������
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p2 != null && p2.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        //�����������
        if(p1 == p2)
        	return true;
        
        //���ֵ��ڵ���������
        if(p2 != null) {
        	p1 = p1.next;
        }
        //����ת
        ListNode header = new ListNode(0);
        header.next = p1;
        ListNode p3 = header, p4 = p3.next, p5;
        while(p4 != null) {
        	p5 = p4.next;
        	p4.next = p3;
        	p3 = p4;
        	p4 = p5;
        }
        p1.next = null;
        p1 = head;p2 = p3;
        //�Ƚ���������
        while(p1 != null && p2 != null) {
        	if(p1.val != p2.val)
        		return false;
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return true;
    }
}
