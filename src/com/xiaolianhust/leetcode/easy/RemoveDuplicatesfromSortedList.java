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
	 * ��һ��˼·��
	 * ��֮ǰRemoveDuplicatesFromSortedArray��discussѧϰ����˼�롣
	 * ��������ʹ������������͹��������ʹ�������ˡ�˼·�ϲ�û��ʲô����ʵ���������ǱȽ����׵ġ�
	 * test1:1ms, beat 100% ��=��=��=��(�b��b;)��
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
