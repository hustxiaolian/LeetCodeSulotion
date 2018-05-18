package xiaolian.hard;



public class ReverseKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode h = new ListNode(-1);
		ListNode p = h;
		
		for(int i = 1; i < 6;++i) {
			p.next = new ListNode(i);
			p = p.next;
		}
		
		reverseKGroup(h.next, 2);
	}
	
	private static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }

	}
	
	/**
	 * 第一个思路：
	 * 1. 基本思路跟{@link SwapNodesInParis}是差不多的，只不过每次跨越的节点是k- 1 个，不再是相邻的节点之间。
	 * 2. 但是如果k = 2， 那么就是一种特殊情况，需要特殊处理。
	 * 
	 * 
	 * 第二个思路：
	 * 1. 把原始链表分成两条，一条是所有的节点都需要反转的，第二条是保持原样的链表。
	 * 
	 * 
	 * 第三个思路：
	 * 妈的，原来我把题目意思理解错误了，难怪感觉到很蛋疼的。原来是要把一整块全部反向，也就是我一开始的想法。
	 * 那就是整个链表分块呗。对每个分块都进行反转操作。把链表每连续的k个元素看成一个块。
	 * 当块完整时，反转整个块，并且把它重新和两端节点正确连接。
	 * 
	 * 时间界限：所有节点都访问了一次，O(N);空间界限:O(1)
	 * 
	 * test1:8ms, beats 74.84%
	 * 
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode header = new ListNode(0);
        ListNode i, j;
        
        header.next = head;
        i = header;
        j = i;
        outer:
        while(true) {
        	//判断下一个块是否完整
        	for(int cnt = 0;cnt < k; ++cnt) {
        		if(j.next != null)
        			j = j.next;
        		else 
        			break outer;
        	}
        	//反转块并且正确连接两端
        	i = reverseBlock(i, j);
        	j = i;
        }
        
        return header.next;
    }
    
    /**
     * 当块完整时，反转整个块，并且把它重新和两端节点正确连接。
     * @param prestart 块的前一个节点
     * @param end 块的尾节点
     * @return 新的尾节点引用
     */
    private static ListNode reverseBlock(ListNode prestart, ListNode end) {
    	ListNode start = prestart.next;
    	ListNode afterend = end.next;
    	ListNode x, y, z;
    	
    	x = start;
    	y = x.next;
    	z = y;
    	while(y != afterend) {
    		z = z.next;
    		y.next = x;
    		x = y;
    		y = z;
    	}
    	
    	prestart.next = end;
    	start.next = afterend;
    	return start;
    }
    
    @SuppressWarnings("unused")
	private static void showList(ListNode start) {
    	for(;start != null;start = start.next) {
    		System.out.print(start.val + "->");
    	}
    	System.out.println();
    }

}
