package com.xiaolianhust.leetcode.medium;

import java.util.HashSet;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ˼·��
	 * ������˼·Ӧ����Ҫ���I�ģ�Ҳ���������ҵ����βٳ�����㡣
	 * ��һ��˼·��Ȼ�ǽ��hashset��ֱ���жϼ��ɡ�
	 * 
	 * test1:14ms, beats 2.57%��=��=��=��(�b��b;)��
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while(p != null) {
        	if(set.contains(p))
        		return p;
        	set.add(p);
        	p = p.next;
        }
        return null;
    }
	
	/**
	 * �����Ҫ��ֻ���ó����ռ䣬��ô����ʹ��ɧ��·��
	 * ����discuss�������Ǹ����ˣ���������Ȼ��Ҳ�뵽������Ҫ��һ����㹫ʽ������
	 * û����˼·��ô������������û���š�ѧϰ�ˣ�лл��
	 * 
	 * ��ͼ����ʽ˵��������no bb
	 * 
	 * 1. ����kΪ meet step ,2k - k = nr; ����p1ÿ��ǰ��2�񣬶�p2ÿ��ǰ��1������֮��Ĳ�����cycle�Ľڵ����
	 * 2. ����sΪ������㵽�������ľ��룬mΪ������㵽�����ڵ�ľ���s+m=k, ���s = k-m(�����㵽��һ�����ľ��롣)
	 * 
	 * test1:1ms, beats 29.97%��=��=��=��(�b��b;)��
	 * 
	 * ѧϰ�ˣ�лл���һ����ٻ���������ġ�
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle2(ListNode head) {
		ListNode p1 = head, p2 = head;
		boolean hasCycle = false;
		while(p1 != null && p1.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
			if(p1 == p2) {
				hasCycle = true;
				break;
			}
		}
		if(!hasCycle) return null;
		ListNode p3 = head;
		while(p3 != p2) {
			p3 = p3.next;
			p2 = p2.next;
		}
		return p3;
	}
}
