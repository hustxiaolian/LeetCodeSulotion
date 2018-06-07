package xiaolian.medium;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateMatrix(4));
	}
	
	/**
	 * 第一个思路：
	 * 按照路径来走。首先寻找路径规律，然后依次赋值就行。
	 * 
	 * test1:2ms, beats 100%ε=ε=ε=┏(゜ロ゜;)┛
	 * time:30min
	 * @param n
	 * @return
	 */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int end = n * n;
        int cnt = 1;
        int i = 0,j = 0;//表示行列
        int leftCnt = 0, rightCnt = 0, upCnt = 0, downCnt = 0;
        
        while(true) {
        	//终止判断
        	if(cnt > end)
        		break;
        	for(;j < n - downCnt;++j)
    			result[i][j] = cnt++;
    		++rightCnt;
    		++i;//下移一下，避免在角度重复赋值
    		--j;//移动回来，现在是越界的
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
