package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 如果这道题真的如表面上看起来这么简单，我觉得简直有毒。
	 * 
	 * test1:5ms, beat 13.66%ε=ε=ε=┏(゜ロ゜;)┛
	 * 每次这种很简单的问题，就是，我感觉我的代码实在是没看来慢在哪里，
	 * 最骚的是，我觉得前排根本就不快才对。
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
