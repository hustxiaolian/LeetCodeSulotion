package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 思路：
	 * 1. 建立两个header,一个用来引导奇数节点，一个用来引导偶数节点。
	 * 2. 遍历head链表，首先把该节点放在h1链表中，建立起相邻节点的正确指针关系。偶数节点相同
	 * 3. 遍历完成后，把奇数在前，偶数在后，链接在一起。
	 * 
	 * test1: 6ms, ε=ε=ε=┏(゜ロ゜;)┛
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode p = head, p1 = h1, p2 = h2;
        
        while(p != null) {
        	//奇数
        	p1.next = p;
        	p = p.next;
        	p1 = p1.next;
        	//偶数
        	if(p != null) {
        		p2.next = p;
        		p = p.next;
        		p2 = p2.next;
        	}
        }
        p1.next = h2.next;
        p2.next = null;
        return h1.next;
    }
}
