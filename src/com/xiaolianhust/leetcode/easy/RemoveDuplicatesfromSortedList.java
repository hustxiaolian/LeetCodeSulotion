package com.xiaolianhust.leetcode.easy;

public class RemoveDuplicatesfromSortedList {

	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 第一种思路：
	 * 从之前RemoveDuplicatesFromSortedArray中discuss学习到的思想。
	 * 在数组中使用索引，这里就光明正大的使用引用了。思路上并没有什么区别，实现起来还是比较容易的。
	 * test1:1ms, beat 100% ε=ε=ε=┏(゜ロ゜;)┛
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null) return null;
        ListNode header = new ListNode(0);
        header.next = head;
        
        ListNode curr = head;
        ListNode pre = head;
        while(curr != null) {
        	if(curr.val > pre.val) {
        		pre.next = curr;
        		pre = curr;
        	}
        	curr = curr.next;
        }
        pre.next = null;
        return header.next;
    }

}
