package xiaolian.medium;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateMatrix(4));
	}
	
	/**
	 * ��һ��˼·��
	 * ����·�����ߡ�����Ѱ��·�����ɣ�Ȼ�����θ�ֵ���С�
	 * 
	 * test1:2ms, beats 100%��=��=��=��(�b��b;)��
	 * time:30min
	 * @param n
	 * @return
	 */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int end = n * n;
        int cnt = 1;
        int i = 0,j = 0;//��ʾ����
        int leftCnt = 0, rightCnt = 0, upCnt = 0, downCnt = 0;
        
        while(true) {
        	//��ֹ�ж�
        	if(cnt > end)
        		break;
        	for(;j < n - downCnt;++j)
    			result[i][j] = cnt++;
    		++rightCnt;
    		++i;//����һ�£������ڽǶ��ظ���ֵ
    		--j;//�ƶ�������������Խ���
    		for(;i < n - leftCnt;++i)
    			result[i][j] = cnt++;
    		++downCnt;
    		--j;
    		--i;
    		for(;j >= upCnt;--j)
    			result[i][j] = cnt++;
    		++leftCnt;
    		--i;
    		++j;
    		for(;i >= rightCnt;--i)
    			result[i][j] = cnt++;
    		++upCnt;
    		++j;
    		++i;
        }
        
        return result;
    }
}
