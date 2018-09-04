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
	 * ˼·��
	 * two-pass˼·
	 * ��һ�����next��fopy���ڶ�������map���randomָ��ĸ��ơ�
	 * test1:2ms, beats 70.36%��=��=��=��(�b��b;)��
	 * 
	 * ���ӸĽ��ķ�������������O��1��space �����������ݶ���лл��
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode header = new RandomListNode(0);
        RandomListNode p1 = head;
        RandomListNode p2 = header;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        //one-pass,�����һ�����ó�ʼ������null
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
