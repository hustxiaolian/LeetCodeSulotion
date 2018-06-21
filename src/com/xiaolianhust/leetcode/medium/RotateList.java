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
	 * 第一种思路：
	 * 其实挺简单的。
	 * 
	 * 首先求余数，防止往复操作好几次。然后在指定位置断开重新拼接即可。
	 * 
	 * 第二种思路：
	 * 按照它这种循环方式来，然后判断是否循环一圈了，这样既可以知道链表得size，如果k < size
	 * 那么已经完成。如果k > size，我最多置换循环一次。
	 * 
	 * 重新理清楚思路再写;
	 * 1. 尝试将p向前移动k次，如果此时p不会null，说明k比较小，k < n
	 * 2. 如果p位null，说明k > n，计算kk = k % n;
	 * 
	 * test1:17ms, beats 76.32%ε=ε=ε=┏(゜ロ゜;)┛
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
			//说明k比较小
			ListNode prepre = header;
			while(prep.next != null) {
				prepre = prepre.next;
				prep = prep.next;
			}
			helper(header, prep, prepre);
		}
		else {
			//说明k比较大，产生了循环的情况
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
	 * 完成指针引用的重构过程
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
