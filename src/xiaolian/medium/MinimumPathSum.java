package xiaolian.medium;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minPathSum2(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
	}
	
	/**
	 * ��һ��˼·��
	 * �������������˼·��ֻ��������ھ�������ʵ��Ҳ������˼��.
	 * ���岽���ǣ������Ͻǳ�����һ�μ��㵽�����pathNum����һ��ͬ�ȴ�С�Ķ�ά�������洢
	 * 
	 * F(m,n) = Math.min(F(m - 1,n) + F(m, n - 1)) + grid(m,n);
	 * �߽�����£�����������ơ�
	 * 
	 * 
	 * test1:9ms, beats 84.66%
	 * 
	 * �Ľ������������ƣ�����ͨ��ֻ����һ��һά������ʵ�֡�
	 * �²�һ�㣺�ܶ��ԳƲ���Ҫ����ռ䶼��ֱ�������������ϸĶ������ܾ���������̫�á�
	 * 
	 * @param grid
	 * @return
	 */
    public static int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
        int[][] temp = new int[m][n];
        //��ͷ��ʼ��
        temp[0][0] = grid[0][0];
        //�ȴ���߽����
        for(int i = 1;i < m;++i) {
        	temp[i][0] = temp[i - 1][0] + grid[i][0];
        }
        for(int i = 1;i < n;++i) {
        	temp[0][i] = temp[0][i - 1] + grid[0][i];
        }
        //���������������������
        for(int i = 1;i < m;++i) {
        	for(int j = 1;j < n;++j) {
        		temp[i][j] = Math.min(temp[i - 1][j], temp[i][j - 1]) + grid[i][j];
        	}
        }
    	return temp[m - 1][n - 1];
    }
    
    /**
     * 
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	int p, q;
    	int[] temp;
    	if(m < n) {
    		p = m;
    		q = n;
    		//�߽����
    		temp = new int[p];
    		temp[0] = grid[0][0];
    		for(int i = 1;i < p;++i)
    			temp[i] = temp[i - 1] + grid[i][0];
    		for(int i = 1;i < q;++i) {
    			temp[0] = temp[0] + grid[0][i];
    			for(int j = 1;j < p;++j) {
    				temp[j] = Math.min(temp[j - 1], temp[j]) + grid[j][i];
    			}
    		}
    	}
    	else {
    		p = n;
    		q = m;
    		temp = new int[p];
    		temp[0] = grid[0][0];
    		for(int i = 1;i < p;++i)
    			temp[i] = temp[i - 1] + grid[0][i];  		
    		for(int i = 1;i < q;++i) {
    			temp[0] = temp[0] + grid[i][0];
    			for(int j = 1;j < p;++j) {
    				temp[j] = Math.min(temp[j - 1], temp[j]) + grid[i][j];
    			}
    		}
    	}
		return temp[p - 1];
    }

}
