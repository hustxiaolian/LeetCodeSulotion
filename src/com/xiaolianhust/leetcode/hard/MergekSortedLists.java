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
	 * ����һ���Ƚ�����������
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
	 * ˼·������˼·���Ǻ�merge two��࣬�������ʹ�ö��������Ѱ��k�������е��ε���Сֵ.
	 * ���ö�����еĸ��ڵ�Ϊ�����ѵ���Сֵ�����ʣ�����ÿ�ο���ÿ�λ�ȡ��СֵΪO��1����������һ���µ�ֵΪlogK
	 * 
	 * ʱ�����Ϊ��NlogK
	 * 
	 * test1:19ms, beats 67.96%
	 * 
	 * ���������˵�˼·����ʱ������Ͽ����⼸������õ�ʱ�����NlogK����ǰ�ŵĴ𰸼������Ƿ��ν���ġ�
	 * �����ڸ������ϣ������㷨��ʵ�ʻ����������ܿ��ܸ��á�
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHeader = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Cptor());//����ʹ�ñȽ���������������
        ListNode currentNode, p = resultHeader;
        
        //���Ȱ����е�ͷ�ڵ����
        for(ListNode head : lists) {
        	if(head != null)
        		queue.offer(head);
        }
        
        //Ȼ���ö������ÿ�������Сֵ������ýڵ����һ���ڵ㲻Ϊnull, ��ô���뵽��������С�
        //���Ϊnull����ʲôҲ��������ζ�����������Ѿ���������ˣ�
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
