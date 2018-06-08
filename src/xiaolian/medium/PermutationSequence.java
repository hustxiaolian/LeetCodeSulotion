package xiaolian.medium;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4, 9));
	}
	
	/**
	 * ��һ��˼·��
	 * ���ȣ��޷�������list���������ǿ϶��ġ����������Ҳ��ûʲô�Ѷȡ�
	 * 
	 * ����˼·���裺
	 * 1.����n - 1�Ľ׳ˣ�Ȼ����--k֮��k / (n - 1)�����ʽ�ĺ��������������׳��µ�result�������
	 * 2.����k % (n-1)!��Ϊ��һ�μ����k��ͬʱk--���������ĺ������������һ���ǵڼ������֡�
	 * 
	 * �鷳�ľ��ǵø�������������͵ڼ��������Ӧ��ϵ�������ˡ�
	 * �����漰��һ����̬�滮��˼�롣
	 * 
	 * test1: 15ms, beats 99.05%��=��=��=��(�b��b;)��
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation(int n, int k) {
		if(n == 1) return "1";
        int tempn = 1;
        int i = 2;
        StringBuffer sb = new StringBuffer();
        int[] nums = new int[n];
        while(i < n) {
        	tempn *= i;
        	++i;
        }
        --k;
        for(--i;i > 0;--i) {
        	int quotient = k / tempn;
        	int remainder = k % tempn;
        	sb.append(pickI(nums, quotient));
        	k = remainder;
        	tempn /= i;
        }
        sb.append(pickI(nums, 0));
        
        return sb.toString();
    }

	private static int pickI(int[] nums, int quotient) {
		int cnt = -1;
		int i = 0;
		for(;i < nums.length;++i) {
			if(nums[i] == 0) {
				if(++cnt == quotient) {
					nums[i] = 1;
					return i + 1;
				}
			}
		}
		return -1;
	}
	
	

}
