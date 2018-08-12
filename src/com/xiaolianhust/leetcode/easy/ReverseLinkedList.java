package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 很正常的链表操作。从左到右依次改变它的指针即可。
	 * 唯一的技巧来自于prep, p,nextp三个引用的初始化以及在while中的顺序。
	 * 可以避免一些不必要的判断。
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
