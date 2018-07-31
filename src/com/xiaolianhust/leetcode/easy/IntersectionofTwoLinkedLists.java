package com.xiaolianhust.leetcode.easy;

import com.xiaolianhust.leetcode.easy.LinkedListCycle.ListNode;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * ����⣬��һ��ʼ�������������ˣ�����ʵҲ���Լ���ɵ���ˡ�
	 * ����Ϊ�������ܻ����X���������ص���������ϸһ�����ǲ����ܵģ���Ϊ����ֻ��һ��next
	 * ��ô������ĳ���ڵ��Ϸֳ���������
	 * 
	 * ����˼·��
	 * ��Ȼ���������⣬Ҳ������������ص�����ô�������һ���ڵ㣬�������ͬ�ġ�
	 * 
	 * 1. ��������ָ��pa,pb��ͬʱ���ߣ�ֱ������һ��ָ�뵽�˽�β��
	 * 2. Ȼ���������ָ��pc�������pa����β�ͣ���pc = headB, ����pc = headA
	 * 3. Ȼ��pc ���Ǹ�δ�ﵽ��β��ָ��һ�𶯣�ֱ��ײ��β�ͣ�����pc��Ҳ����Ϊ��Ĩƽ���������ǲ��֡�
	 * 		ʹ�������ܹ�����ͬһ�����㡣
	 * 4. ��ƽ���ָ�룬һ����ǰ�ƶ���ֱ�������ڴ��ַ��ȫ��ͬ
	 * 
	 * ԭ��
	 * ����len_a = la, len_b = la, ����len_a > len_c,�����Ǵ����غϡ�
	 * 
	 * ����һ������β�ͣ�����һ��λ�þ���
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
		
        //2��3
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
