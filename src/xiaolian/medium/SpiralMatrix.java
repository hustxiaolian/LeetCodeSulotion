package xiaolian.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SpiralMatrix().spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
	}
	
	/**
	 * ��һ��˼·��
	 * ���ǰ���֮ǰ��SprialMatrix2��˼·����ȦȦչ����
	 * 
	 * test1:2ms, beat 100% ��=��=��=��(�b��b;)��
	 * 
	 * @param matrix
	 * @return
	 */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int cnt = 0;
        int m = matrix.length;
        if(m == 0) return result;
        int n = matrix[0].length;
        int circleCnt = 0;
        int i = 0,j = 0;
        int direcitionFlag = 0;
        while(cnt < m * n) {
        	switch(direcitionFlag++ % 4) {
        	case 0:
        		//������
            	for(;j < n - circleCnt; ++j,cnt++)
            		result.add(matrix[i][j]);
            	//����λ��
            	--j;++i;
        		break;
        	case 1:
        		for(;i < m - circleCnt;++i,cnt++)
            		result.add(matrix[i][j]);
            	--i;--j;
            	break;
        	case 2:
        		for(;j >= circleCnt;--j,++cnt)
            		result.add(matrix[i][j]);
            	++j;--i;
            	break;
        	case 3:
        		for(;i >= circleCnt + 1;--i,++cnt)
            		result.add(matrix[i][j]);
            	++i;++j;
            	++circleCnt;
            	break;
        	}
        }
        return result;
    }	

}
