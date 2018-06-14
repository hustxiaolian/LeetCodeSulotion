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
	 * ��һ��˼·��
	 * ����������ڵ�Ԫ���Ƿ���ȣ���Ⱦ�׼��������һ��ɾ����
	 * 
	 * test1:2ms, beats 51.16%
	 * discuss�������Ҳû�кõ�˼·��
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
