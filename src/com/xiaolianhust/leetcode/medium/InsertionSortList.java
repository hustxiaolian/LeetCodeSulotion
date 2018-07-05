package com.xiaolianhust.leetcode.medium;

import com.xiaolianhust.leetcode.easy.RemoveDuplicatesfromSortedList.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 第一种思路：
	 * 就是插入排序的链表版本。唯一的麻烦就是每次判断确定就，都必须从头开始遍历，寻找插入位置。
	 * 
	 * test1:8ms, beats 98.91%ε=ε=ε=┏(゜ロ゜;)┛
	 * 猜测中间有部分人慢的原因是：插入排序是每次每次向前交换位置，这样会有很多多余的指针操作。
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
