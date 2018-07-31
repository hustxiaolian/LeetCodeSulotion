package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 这道题，我一开始的题意理解错我了，哎其实也是自己的傻逼了。
	 * 我以为这道题可能会出现X型这样的重叠，但是仔细一想这是不可能的，因为链表只有一个next
	 * 怎么可能在某个节点上分出两个方向。
	 * 
	 * 核心思路：
	 * 既然理解清楚题意，也就是如果它们重叠，那么起码最后一个节点，是完成相同的。
	 * 
	 * 1. 定义两个指针pa,pb，同时向走，直到其中一个指针到了结尾。
	 * 2. 然后定义第三个指针pc，如果是pa到了尾巴，则pc = headB, 否则pc = headA
	 * 3. 然后pc 和那个未达到结尾的指针一起动，直到撞到尾巴，这样pc，也就是为了抹平长链表长的那部分。
	 * 		使得它们能够拉到同一出发点。
	 * 4. 拉平后的指针，一起向前移动，直到她两内存地址完全相同
	 * 
	 * 原理：
	 * 假设len_a = la, len_b = la, 假设len_a > len_c,且它们存在重合。
	 * 
	 * 其中一个到达尾巴，而另一的位置具体
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        //1
        while(pa != null && pb != null) {
        	pa = pa.next;
        	pb = pb.next;
        }
		
        //2和3
        ListNode pc, pd;
        if(pa == null) {
        	pc = headB;
        	while(pb != null) {
        		pc = pc.next;
        		pb = pb.next;
        	}
        	pd = headA;
        }
        else {
        	pc = headA;
        	while(pa != null) {
        		pc = pc.next;
        		pa = pa.next;
        	}
        	pd = headB;
        }
        //4
        while(pc != null) {
        	if(pc == pd)
        		return pc;
        	pc = pc.next;
        	pd = pd.next;
        }
        
		return null;
    }
}
