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
	 * ��һ��˼·��
	 * 1. ����˼·��{@link SwapNodesInParis}�ǲ��ģ�ֻ����ÿ�ο�Խ�Ľڵ���k- 1 �������������ڵĽڵ�֮�䡣
	 * 2. �������k = 2�� ��ô����һ�������������Ҫ���⴦��
	 * 
	 * 
	 * �ڶ���˼·��
	 * 1. ��ԭʼ����ֳ�������һ�������еĽڵ㶼��Ҫ��ת�ģ��ڶ����Ǳ���ԭ��������
	 * 
	 * 
	 * ������˼·��
	 * ��ģ�ԭ���Ұ���Ŀ��˼�������ˣ��ѹָо����ܵ��۵ġ�ԭ����Ҫ��һ����ȫ������Ҳ������һ��ʼ���뷨��
	 * �Ǿ�����������ֿ��¡���ÿ���ֿ鶼���з�ת������������ÿ������k��Ԫ�ؿ���һ���顣
	 * ��������ʱ����ת�����飬���Ұ������º����˽ڵ���ȷ���ӡ�
	 * 
	 * ʱ����ޣ����нڵ㶼������һ�Σ�O(N);�ռ����:O(1)
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
        	//�ж���һ�����Ƿ�����
        	for(int cnt = 0;cnt < k; ++cnt) {
        		if(j.next != null)
        			j = j.next;
        		else 
        			break outer;
        	}
        	//��ת�鲢����ȷ��������
        	i = reverseBlock(i, j);
        	j = i;
        }
        
        return header.next;
    }
    
    /**
     * ��������ʱ����ת�����飬���Ұ������º����˽ڵ���ȷ���ӡ�
     * @param prestart ���ǰһ���ڵ�
     * @param end ���β�ڵ�
     * @return �µ�β�ڵ�����
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
