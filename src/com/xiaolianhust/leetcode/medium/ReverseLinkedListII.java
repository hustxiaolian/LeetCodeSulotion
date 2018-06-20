package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.medium.RemoveDuplicatefromSortedListII.ListNode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	/**
	 * 第一种思路：
	 * 这道题，没有什么特别有技巧的东西，就是主要是注意边界的处理。
	 * 
	 * test1:4ms, beats 97.93%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m == n) return head;
        ListNode resultHeader = new ListNode(0);
        resultHeader.next = head;
        ListNode preStart = resultHeader;
        for(int i = 0;i < m - 1;++i)
        	preStart = preStart.next;
        ListNode start = preStart.next;
        ListNode end = start;
        for(int i = m;i < n;++i)
        	end = end.next;
        ListNode afterEnd = end.next;
        
        ListNode prep = start, p = prep.next, nextp = p.next;
        while(p != afterEnd) {
        	p.next = prep;
        	prep = p;
        	p = nextp;
        	if(nextp == null)
        		break;
        	nextp = nextp.next;
        }
        
        start.next = afterEnd;
        preStart.next = end;
        
        return resultHeader.next;
    }
	
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if(m == n) return head;
        ListNode resultHeader = new ListNode(0);
        resultHeader.next = head;
        ListNode preStart = resultHeader;
        for(int i = 0;i < m - 1;++i)
        	preStart = preStart.next;
        ListNode start = preStart.next;
        ListNode prep = start, p = prep.next, nextp = p.next;
        for(int i = m;i < n;++i) {
        	p.next = prep;
        	prep = p;
        	p = nextp;
        	if(nextp == null)
        		break;
        	nextp = nextp.next;
        }
        
        preStart.next = prep;
        start.next = p;
        
        return resultHeader.next;
	}
}
