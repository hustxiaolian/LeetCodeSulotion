package com.xiaolianhust.leetcode.medium;

public class RemoveNthNodeFromEndOfList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		

	}
	
	/**
	 * ˼·�����չ��й��ɣ�һ��õķ��������ܼ�Сһ����������
	 * 1.�ֱ��ķ���Ҳ���Ǵ�ͷ������β���õ���������ĳ���length ,Ȼ���ٴ�ͷ�ƶ�length - N��ִ��ɾ����
	 * 2.����ĸĽ�˼·���趨i, (�ڵ������1��ʼ���Ǵ�0��ʼ)�ӵ�N + 1���ڵ㿪ʼ��������¼i - N�ڵ�����ã�Ҳ������ɾ���ڵ��ǰ���Ǹ���
	 * ps:Ϊ�˱�֤��ȷ�ԣ��ͱ���ķ����ԣ�����ԭʼ�ڵ��ͷ������һ��header.
	 * 
	 * 
	 * ʱ����ޣ�O(N),���������N��ֻ������һ�顣
	 * �ռ临�Ӷȣ�O(1)
	 * 
	 * ���н����15ms,beat 93.18%
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode header = new ListNode(0);
        header.next = head;
        
        ListNode i = header, j = header;
        for(int cnt = 0; cnt < n; ++cnt)
        	i = i.next;
        
        while(i.next != null) {
        	i = i.next;
        	j = j.next;
        }
        
        j.next = j.next.next;
		
		return header.next;
    }
	
}
