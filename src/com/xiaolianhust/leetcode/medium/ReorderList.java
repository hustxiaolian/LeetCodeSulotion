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
	 * 第一种思路：
	 * 利用之前学习到的，双指针链表寻找确定链表中点和尾点的方法，先确定中点和尾点。
	 * 然后双指针，从尾点开始将节点插入到前面
	 * 
	 * test1:2ms,beats 100%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param head
	 */
	public static void reorderList(ListNode head) {
        ListNode h1 = new ListNode(0);
        h1.next = head;
        ListNode mid = head, end = head, premid = h1;
        //1，寻找中点和尾点
        while(end != null && end.next != null) {
        	end = end.next.next;
        	premid = mid;
        	mid = mid.next;
        }
        if(mid == end || (end == null && mid.next == null)) return;//处理特殊情况
        
        //2.将后半部分拿来出来反向。
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
        
        //两个准备的链表融合下就好。
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
