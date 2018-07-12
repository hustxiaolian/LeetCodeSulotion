package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.easy.MergeTwoSortedLists.ListNode;

public class ReorderList {
	public static void main(String[] args) {
		
	}
	
	public static String printListNodes(ListNode head) {
		StringBuffer sb = new StringBuffer("[");
		while(head != null) {
			sb.append(head.val).append(", ");
		}
		sb.replace(sb.length() - 1, sb.length(), "]");
		return sb.toString();
	}
	
	/**
	 * ��һ��˼·��
	 * ����֮ǰѧϰ���ģ�˫ָ������Ѱ��ȷ�������е��β��ķ�������ȷ���е��β�㡣
	 * Ȼ��˫ָ�룬��β�㿪ʼ���ڵ���뵽ǰ��
	 * 
	 * test1:2ms,beats 100%��=��=��=��(�b��b;)��
	 * 
	 * @param head
	 */
	public static void reorderList(ListNode head) {
        ListNode h1 = new ListNode(0);
        h1.next = head;
        ListNode mid = head, end = head, premid = h1;
        //1��Ѱ���е��β��
        while(end != null && end.next != null) {
        	end = end.next.next;
        	premid = mid;
        	mid = mid.next;
        }
        if(mid == end || (end == null && mid.next == null)) return;//�����������
        
        //2.����벿��������������
        ListNode h2 = new ListNode(0);
        if(end == null) {
        	h2.next = mid;
        	premid.next = null;
        }
        else {
        	h2.next = mid.next;
        	mid.next = null;
        }
        ListNode pre = h2.next, p = pre.next, next;
        pre.next = null;
        while(p != null) {
        	next = p.next;
        	
        	p.next = pre;
        	
        	pre = p;
        	p = next;
        }
        h2.next = pre;
        
        //����׼���������ں��¾ͺá�
        ListNode p1 = h1.next, p2 = h2.next;
        ListNode p1next, p2next;
        while(p2 != null) {
        	p1next = p1.next;
        	p2next = p2.next;
        	
        	p2.next = p1.next;
        	p1.next = p2;
        	
        	p1 = p1next;
        	p2 = p2next;
        }
    }
}
