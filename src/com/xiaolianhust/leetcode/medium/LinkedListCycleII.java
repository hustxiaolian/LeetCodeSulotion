package com.xiaolianhust.leetcode.medium;

import java.util.HashSet;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路：
	 * 这道题的思路应该是要借鉴I的，也就是他得找到环形操场的起点。
	 * 第一种思路当然是借鉴hashset，直接判断即可。
	 * 
	 * test1:14ms, beats 2.57%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while(p != null) {
        	if(set.contains(p))
        		return p;
        	set.add(p);
        	p = p.next;
        }
        return null;
    }
	
	/**
	 * 如果是要求只能用常数空间，那么必须使用骚套路。
	 * 看了discuss大神，真是给跪了，厉害。虽然我也想到估计需要用一点计算公式，但是
	 * 没有他思路这么清晰，并且我没自信。学习了，谢谢。
	 * 
	 * 画图，公式说话，否则no bb
	 * 
	 * 1. 假设k为 meet step ,2k - k = nr; 由于p1每次前进2格，而p2每次前进1格，他们之间的差距就是cycle的节点个数
	 * 2. 假设s为链表起点到环形起点的距离，m为环形起点到相遇节点的距离s+m=k, 因此s = k-m(相遇点到下一次起点的距离。)
	 * 
	 * test1:1ms, beats 29.97%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 学习了，谢谢。我还会再回来看看你的。
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle2(ListNode head) {
		ListNode p1 = head, p2 = head;
		boolean hasCycle = false;
		while(p1 != null && p1.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
			if(p1 == p2) {
				hasCycle = true;
				break;
			}
		}
		if(!hasCycle) return null;
		ListNode p3 = head;
		while(p3 != p2) {
			p3 = p3.next;
			p2 = p2.next;
		}
		return p3;
	}
}
