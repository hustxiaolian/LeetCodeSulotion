package com.xiaolianhust.leetcode.medium;

import java.util.HashMap;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	/**
	 * 思路：
	 * two-pass思路
	 * 第一趟完成next的fopy，第二便利用map完成random指针的复制。
	 * test1:2ms, beats 70.36%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 更加改进的方法，可以做到O（1）space ，后续再来拜读。谢谢。
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode header = new RandomListNode(0);
        RandomListNode p1 = head;
        RandomListNode p2 = header;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        //one-pass,出后的一个利用初始化就是null
        while(p1 != null) {
        	p2.next = new RandomListNode(p1.label);
        	map.put(p1, p2.next);
        	p1 = p1.next;
        	p2 = p2.next;
        }
        p1 = head;p2 = header.next;
        while(p1 != null) {
        	p2.random = map.get(p1.random);
        	
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return header.next;
    }
}
