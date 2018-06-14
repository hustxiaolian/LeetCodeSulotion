package com.xiaolianhust.leetcode.medium;

public class RemoveDuplicatefromSortedListII {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 第一种思路：
	 * 检查两个相邻的元素是否相等，相等就准备把他们一块删除。
	 * 
	 * test1:2ms, beats 51.16%
	 * discuss里面好像也没有好的思路。
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null) return null;
    	ListNode header = new ListNode(0);
    	header.next = head;
    	
    	ListNode pre = header;
    	ListNode curr = head;
    	
    	while(curr.next != null) {
    		if(curr.val == curr.next.val) {
    			ListNode temp = curr.next;
    			while(temp != null && temp.val == curr.val)
    				temp = temp.next;
    			pre.next = temp;
    			curr = temp;
    			if(curr == null)
    				break;
    		}
    		else {
    			curr = curr.next;
        		pre = pre.next;
    		}
    	}
    	
    	return header.next;
    }
}
