package com.xiaolianhust.leetcode.medium;


public class RotateList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��һ��˼·��
	 * ��ʵͦ�򵥵ġ�
	 * 
	 * ��������������ֹ���������ü��Ρ�Ȼ����ָ��λ�öϿ�����ƴ�Ӽ��ɡ�
	 * 
	 * �ڶ���˼·��
	 * ����������ѭ����ʽ����Ȼ���ж��Ƿ�ѭ��һȦ�ˣ������ȿ���֪�������size�����k < size
	 * ��ô�Ѿ���ɡ����k > size��������û�ѭ��һ�Ρ�
	 * 
	 * ���������˼·��д;
	 * 1. ���Խ�p��ǰ�ƶ�k�Σ������ʱp����null��˵��k�Ƚ�С��k < n
	 * 2. ���pλnull��˵��k > n������kk = k % n;
	 * 
	 * test1:17ms, beats 76.32%��=��=��=��(�b��b;)��
	 * 
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(k == 0 || head == null) return head;
		ListNode header = new ListNode(0);
		header.next = head;
		ListNode prep = header;
		int i = 0;
		while(prep.next != null && i < k) {
			prep = prep.next;
			++i;
		}
		if(prep.next != null) {
			//˵��k�Ƚ�С
			ListNode prepre = header;
			while(prep.next != null) {
				prepre = prepre.next;
				prep = prep.next;
			}
			helper(header, prep, prepre);
		}
		else {
			//˵��k�Ƚϴ󣬲�����ѭ�������
			int kk = k % i;
			if(kk == 0)
				return head;
			ListNode tail = prep;
			prep = header;
			for(int ii = 0;ii < i - kk; ++ii) 
				prep = prep.next;
			helper(header, tail, prep);
		}
		
		return header.next;
    }
	
	/**
	 * ���ָ�����õ��ع�����
	 * @param header
	 * @param tail
	 * @param prep
	 */
	private void helper(ListNode header, ListNode tail, ListNode prep) {
		tail.next = header.next;
		header.next = prep.next;
		prep.next = null;
	}

}
