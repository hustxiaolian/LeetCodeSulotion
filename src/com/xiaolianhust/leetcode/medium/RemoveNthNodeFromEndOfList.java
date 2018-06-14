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
	 * 思路：按照固有规律，一般好的方法起码能减小一个数量级。
	 * 1.粗暴的方法也就是从头遍历到尾，得到整个链表的长度length ,然后再从头移动length - N步执行删除。
	 * 2.我想的改进思路是设定i, (节点计数从1开始不是从0开始)从第N + 1个节点开始遍历，记录i - N节点的引用（也就是欲删除节点的前面那个）
	 * ps:为了保证正确性，和编码的方便性，我在原始节点的头部加了一个header.
	 * 
	 * 
	 * 时间界限：O(N),而且是真的N，只遍历了一遍。
	 * 空间复杂度：O(1)
	 * 
	 * 运行结果：15ms,beat 93.18%
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
