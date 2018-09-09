package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 这道题算是我已经做过的。算是复习下。
	 * 思路几步：
	 * 1. 利用移速分步法，找到链表的中间点（注意区分链表节点是奇数和偶数的不同情况）
	 * 2. 将后半部分的链表reverse
	 * 3. 然后检查两条链表的一致性。
	 * 
	 * test1: 1ms, beats 98.71% ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 总结：这道题需要处理的细节非常多。但是思路还是相对简单的。下面的技巧是需要记住的。
	 * 1. 灵活不同速率移动选出中点（一个移动2步，一个指针移动1步）
	 * 2. 三指针反转整个单向链表。
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
        ListNode p1 = head, p2 = head;
        while(p2 != null && p2.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        //处理特殊情况
        if(p1 == p2)
        	return true;
        
        //区分单节点数的链表
        if(p2 != null) {
        	p1 = p1.next;
        }
        //链表反转
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
        //比较两个链表
        while(p1 != null && p2 != null) {
        	if(p1.val != p2.val)
        		return false;
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return true;
    }
}
