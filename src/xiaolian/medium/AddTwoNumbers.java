package xiaolian.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 * @author 25040
 *
 */
public class AddTwoNumbers {
	private static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x; 
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * ���־��ǿ�������࣬���ţ�����ʵ��Ч���Ǻܵ��µġ���Ϊ���ڲ�ѭ���д��ڴ�������Ҫ���жϡ�
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode p1 = null;//
		ListNode p2 = null;
		
		int addOneFlag = 0;
		while(l1 != null || l2 != null || addOneFlag == 1) {
			int val1 = l1 != null? l1.val : 0;
			int val2 = l2 != null? l2.val : 0;
			int sum = val1 + val2 + addOneFlag;
			p2 = new ListNode(sum % 10);
			addOneFlag = sum / 10;
			//��ʼ
			if(p1 != null) p1.next = p2;
			p1 = p2;
			p2 = p2.next;
			if(result == null) result = p1;
			l1 = l1 != null? l1.next : null;
			l2 = l2 != null? l2.next : null;
		}
		return result;
	}
	
	
	/**
	 * ˼·��
	 * ��������ֱ��ĩβ�����Ҳ���Ǻ���鲢����ϲ����Ǹ����衣
	 * ˼·��
	 * 1. ���ǵ������Ȳ��ȣ���ô
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //��ʼ������
		int addOneFlag = 0;
		ListNode p1 = null;//
		ListNode p2 = null;
		ListNode result = null;
		
		while(l1 != null && l2 != null) {
			int temp = l1.val + l2.val + addOneFlag;
			
			p2 = new ListNode(temp % 10);
			p2.next = null;
			addOneFlag = temp / 10;
			
			if(p1 != null) {
				p1.next = p2;
			}
			p1 = p2;
			p2 = p2.next;
			
			if(result == null)
				result = p1;
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null) {
			int temp = l1.val + addOneFlag;
			
			p2 = new ListNode(temp % 10);
			addOneFlag = temp / 10;
			
			p1.next = p2;
			p1 = p2;
			p2 = p2.next;
			
			l1 = l1.next;
		}
		
		while(l2 != null) {
			int temp = l2.val + addOneFlag;
			
			p2 = new ListNode(temp % 10);
			addOneFlag = temp / 10;
			
			p1.next = p2;
			p1 = p2;
			p2 = p2.next;
			
			l2 = l2.next;
		}
		
		if(addOneFlag == 1) {
			p2 = new ListNode(1);
			
			p1.next = p2;
		}
		
		return result;
    }

}
