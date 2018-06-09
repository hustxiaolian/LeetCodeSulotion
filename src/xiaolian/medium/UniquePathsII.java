package xiaolian.medium;

public class UniquePathsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePathsWithObstacles(new int[][] {{0,0},{1,1},{0,0}}));
		//
		//System.out.println(uniquePathsWithObstacles(new int[][] {{0,1}}));
	}
	
	/**
	 * 第一种思路：
	 * 还是在第一中思路的基础上来的，建立一个new二维数组来暂存中间结果。
	 * 再看看后期能够编程只用一维数组来完成。
	 * 
	 * 这次的递归公式为：
	 * F(m,n) = F(m + 1,n) + F(m,n+1)
	 * 如果其中m,n为障碍物，则F(m,n) = 0;
	 * 对边边界上的点来说
	 * F(m,n) = F(m,n + 1)底部边界。如果其中m,n为障碍物，则F(m,n) = 0;
	 * 同理，
	 * F(m,n) = F(m+1,n)底部边界。如果其中m,n为障碍物，则F(m,n) = 0;
	 * test1:1ms, beats 100%
	 * @param obstacleGrid
	 * @return
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] temp = new int[m][n];
        temp[m - 1][n - 1] = 1;
        for(int i = m - 2;i >= 0;--i) {
        	if(obstacleGrid[i][n - 1] == 1)
        		temp[i][n - 1] = 0;
        	else
        		temp[i][n - 1] = temp[i + 1][n - 1];
        }
        for(int i = n - 2;i >= 0;--i) {
        	if(obstacleGrid[m - 1][i] == 1)
        		temp[m - 1][i] = 0;
        	else
        		temp[m - 1][i] = temp[m - 1][i + 1];
        }
        for(int i = m - 2;i >= 0; --i) {
        	for(int j = n - 2;j >= 0;--j) {
        		if(obstacleGrid[i][j] == 1)
        			temp[i][j] = 0;
        		else 
        			temp[i][j] = temp[i][j + 1] + temp[i + 1][j];
        	}
        }
        return temp[0][0];
    }

}
