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
	 * 第一种思路：
	 * 在数据结构和算法分析那本书上，这就是快排中的三值分割算法。
	 * 当然书上那是在数组上实现，而现在是要在链表中实现。
	 * 注意到题意中，还有一条是保留两个分区中原始的相对顺序。
	 * 
	 * 具体思路：
	 * 1.在链表中寻找x。然后找到了，则把它和头部节点的val交换,如果没找到，就直接返回
	 * 2.设定两个指针，让他遍历。i,j，if(j.val < x) 执行链表的位置交换算法。这里不能像算法导论那样，直接swap(++i, j),
	 * 		那样会破坏元素之间的相对顺序。
	 * 3.遍历完成后，最后，将x交换回去。
	 * 
	 * 第二种思路：改造下老教授的思路。
	 * 1. 在链表上找到x，然后不交换它和头部。
	 * 2. 从头部到x，将所有i.val > x的放到x节点后面，并且保证相对顺序。
	 * 3. 从x 到尾部， 将所有i.val < x放到x前面的位置，并且保证元素的相对位置。
	 * 
	 * 第三种思路：自己重新审视下题意，好像这道题需要这么复杂。
	 * 1. 首先往前遍历直到遇到>=x的节点，prej和j都要同时向前移动，
	 * 2. i = prej设立<x区域的右边界。
	 * 3. j继续向前遍历，if(j < x)就把通过指针操作，放到i.next的位置来。
	 * 
	 * test1:1ms, beats 100%ε=ε=ε=┏(゜ロ゜;)┛ 
	 * 今天状态不好，这道题折腾了90分钟，我也是醉了，果然不能熬夜，脑子都变笨了。
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
        //交换回来。
        
        
        
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
