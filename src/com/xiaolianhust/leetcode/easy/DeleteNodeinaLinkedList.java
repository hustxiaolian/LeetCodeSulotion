package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class DeleteNodeinaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ˼·��
	 * ����һ�����ָ�ֵ����ǰ�ڵ㣬Ȼ��ɾ����һ���ڵ�
	 * @param node
	 */
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
