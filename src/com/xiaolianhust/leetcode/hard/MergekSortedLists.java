package com.xiaolianhust.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;



/**
 * 
 * @author 25040
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }

	}
	/**
	 * 构造一个比较器，来搞事
	 * @author 25040
	 *
	 */
	public static class Cptor implements Comparator<ListNode>{
		@Override
		public int compare(ListNode arg0, ListNode arg1) {
			return Integer.compare(arg0.val, arg1.val);
		}
	}
	
	/**
	 * 思路：基本思路还是和merge two差不多，不过这次使用二项队列来寻找k个链表中当次的最小值.
	 * 利用二项队列的根节点为整个堆的最小值的性质，我们每次可以每次获取最小值为O（1），而插入一个新的值为logK
	 * 
	 * 时间界限为：NlogK
	 * 
	 * test1:19ms, beats 67.96%
	 * 
	 * 看了其他人的思路：从时间界限上看，这几乎是最好的时间界限NlogK，但前排的答案几乎都是分治解决的。
	 * 可能在该问题上，分治算法的实际机器运行性能可能更好。
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHeader = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Cptor());//这里使用比较器来构造二项队列
        ListNode currentNode, p = resultHeader;
        
        //首先把所有的头节点放入
        for(ListNode head : lists) {
        	if(head != null)
        		queue.offer(head);
        }
        
        //然后让二项队列每次输出最小值，如果该节点的下一个节点不为null, 那么插入到二项队列中。
        //如果为null，则什么也不做（意味着这条链表已经遍历完毕了）
        while(!queue.isEmpty()) {
        	currentNode = queue.poll();
        	p.next = currentNode;
        	if(currentNode.next != null) {
        		queue.offer(currentNode.next);
        	}
        	p = p.next;
        }
        
        return resultHeader.next;
    }
	
	
}
