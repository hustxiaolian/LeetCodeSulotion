package xiaolian.hard;


public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NQueensII().totalNQueens(5));
	}
	
	/**
	 * ��һ��˼·��
	 * ������ǰ���Ǹ�����һģһ��������
	 * 
	 * �Ǹ�����Ҫ�����ַ���������ֻ��Ҫcounting
	 * 
	 * test1: 3ms, beats 91.45%��=��=��=��(�b��b;)��
	 * @param n
	 * @return
	 */
    public int totalNQueens(int n) {
    	int[] columns = new int[n];
        return search(0, n, columns);
    }
    
    private static int search(int curr, int n, int[] columns) {
		if(curr == n) {
			return 1;
		}
		//����ǰ���Ѿ����ڵĻʺ󣬼��㵱ǰ�ݹ����У����ܷ��ûʺ��λ�á�
		int[] forbid = new int[n];
		for(int i = 0;i < curr;++i) {
			int temp = columns[i];
			//�еĴ����ɵݹ�������ơ��еĴ���
			forbid[temp] = 1;
			//б��Ĵ�
			if(temp + (curr - i) < n)
				forbid[temp + (curr - i)] = 1;
			if(temp - (curr - i) >= 0)
				forbid[temp - (curr - i)] = 1;
		}
		//�Ժ�void�ݹ��������˵�Ƚ���Ϥ�����ܹ��������ô��ݵ����ԣ���֤�����ȷ�ԡ�
		//���ǣ�ֵ���أ�����Ҫ�Ƚ�ע���ˣ���Ϊ��ֵ������ֵ������ǰ�ݹ��Ρ�
		//��ˣ����Ƶû�Ժ󶼿��Բ�����ô����û��ζ���һ��sum=0������ֵҲ�������м��������ʹ��sum+=
		int sum = 0;
		//����forbid����Ľ�����ݹ������һ���
		for(int i = 0;i < n;++i) {
			if(forbid[i] == 0) {
				columns[curr] = i;
				sum += search(curr + 1, n, columns);
			}
		}
		return sum;
	}

}
