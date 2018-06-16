package com.xiaolianhust.leetcode.medium;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partition2(arrayToListNodes(new int[] {1,4,3,2,5,2}), 3);
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			ListNode p = next;
			while(p != null) {
				sb.append(p.val + ", ");
			}
			return sb.toString();
		}
	}
	
	public static ListNode arrayToListNodes(int[] arr) {
		ListNode resultHeader = new ListNode(0);
		ListNode p = resultHeader;
		
		for(int i = 0;i < arr.length; ++i) {
			p.next = new ListNode(arr[i]);
			p = p.next;
		}
		
		return resultHeader.next;
	}
	
	/**
	 * ��һ��˼·��
	 * �����ݽṹ���㷨�����Ǳ����ϣ�����ǿ����е���ֵ�ָ��㷨��
	 * ��Ȼ����������������ʵ�֣���������Ҫ��������ʵ�֡�
	 * ע�⵽�����У�����һ���Ǳ�������������ԭʼ�����˳��
	 * 
	 * ����˼·��
	 * 1.��������Ѱ��x��Ȼ���ҵ��ˣ��������ͷ���ڵ��val����,���û�ҵ�����ֱ�ӷ���
	 * 2.�趨����ָ�룬����������i,j��if(j.val < x) ִ�������λ�ý����㷨�����ﲻ�����㷨����������ֱ��swap(++i, j),
	 * 		�������ƻ�Ԫ��֮������˳��
	 * 3.������ɺ���󣬽�x������ȥ��
	 * 
	 * �ڶ���˼·���������Ͻ��ڵ�˼·��
	 * 1. ���������ҵ�x��Ȼ�󲻽�������ͷ����
	 * 2. ��ͷ����x��������i.val > x�ķŵ�x�ڵ���棬���ұ�֤���˳��
	 * 3. ��x ��β���� ������i.val < x�ŵ�xǰ���λ�ã����ұ�֤Ԫ�ص����λ�á�
	 * 
	 * ������˼·���Լ��������������⣬�����������Ҫ��ô���ӡ�
	 * 1. ������ǰ����ֱ������>=x�Ľڵ㣬prej��j��Ҫͬʱ��ǰ�ƶ���
	 * 2. i = prej����<x������ұ߽硣
	 * 3. j������ǰ������if(j < x)�Ͱ�ͨ��ָ��������ŵ�i.next��λ������
	 * 
	 * test1:1ms, beats 100%��=��=��=��(�b��b;)�� 
	 * ����״̬���ã������������90���ӣ���Ҳ�����ˣ���Ȼ���ܰ�ҹ�����Ӷ��䱿�ˡ�
	 * 
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
    public ListNode partition(ListNode head, int x) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode p = head;
        int temp;
        
        while(p != null) {
        	if(p.val == x)
        		break;
        	p = p.next;
        }
        if(p == null)
        	return head;
        temp = p.val;
        p.val = head.val;
        head.val = temp;
        
        ListNode i = head, j = i.next, prej = head;
        while(j != null) {
        	if(j.val < x) {
        		prej.next = j.next;
        		j.next = i.next;
        		i.next = j;
        		i = i.next;
        		
        		j = prej.next;
        	}
        	else {
        		prej = j;
            	j = j.next;
        	}
        }
        //����������
        
        
        
        return header.next;
    }
    
    public static ListNode partition2(ListNode head, int x) {
    	ListNode header = new ListNode(0);
        header.next = head;
        
        ListNode i = header, j = i.next, prej = i;
        while(j != null) {
        	if(j.val >= x)
        		break;
        	prej = j;
        	j = j.next;
        }
        i = prej;
        
        while(j != null) {
        	if(j.val < x) {
        		ListNode nextj = j.next;
        		prej.next = j.next;
        		
        		j.next = i.next;
        		i.next = j;
        		
        		i = i.next;
        		j = nextj;
        	}
        	else {
        		prej = j;
        		j = j.next;
        	}
        }
        
        return header.next;
    }
    
}
