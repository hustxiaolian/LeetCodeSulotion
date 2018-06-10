package xiaolian.medium;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minPathSum2(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
	}
	
	/**
	 * 第一种思路：
	 * 广度优先搜索的思路，只是这次是在矩阵里面实现也是有意思哈.
	 * 具体步骤是：从左上角出发，一次计算到各点的pathNum，用一个同等大小的二维矩阵来存储
	 * 
	 * F(m,n) = Math.min(F(m - 1,n) + F(m, n - 1)) + grid(m,n);
	 * 边界情况下，和昨天很类似。
	 * 
	 * 
	 * test1:9ms, beats 84.66%
	 * 
	 * 改进：和昨天类似，可以通过只保留一个一维数组来实现。
	 * 吐槽一点：很多自称不需要额外空间都是直接在输入数组上改动，我总觉得这样不太好。
	 * 
	 * @param grid
	 * @return
	 */
    public static int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
        int[][] temp = new int[m][n];
        //开头初始化
        temp[0][0] = grid[0][0];
        //先处理边界情况
        for(int i = 1;i < m;++i) {
        	temp[i][0] = temp[i - 1][0] + grid[i][0];
        }
        for(int i = 1;i < n;++i) {
        	temp[0][i] = temp[0][i - 1] + grid[0][i];
        }
        //广度优先搜索，迭代计算
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
    		//边界情况
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
