package xiaolian.hard;


public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NQueensII().totalNQueens(5));
	}
	
	/**
	 * 第一种思路：
	 * 这道题和前面那个就是一模一样。。。
	 * 
	 * 那个还需要生成字符串，这里只需要counting
	 * 
	 * test1: 3ms, beats 91.45%ε=ε=ε=┏(゜ロ゜;)┛
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
		//根据前面已经存在的皇后，计算当前递归行中，不能放置皇后的位置。
		int[] forbid = new int[n];
		for(int i = 0;i < curr;++i) {
			int temp = columns[i];
			//行的错开，由递归层数控制。列的错开。
			forbid[temp] = 1;
			//斜向的错开
			if(temp + (curr - i) < n)
				forbid[temp + (curr - i)] = 1;
			if(temp - (curr - i) >= 0)
				forbid[temp - (curr - i)] = 1;
		}
		//以后，void递归对于我来说比较熟悉，我能够根据引用传递的特性，保证结果正确性。
		//但是，值返回，就需要比较注意了，因为，值得作用值作用域当前递归层次。
		//因此，类似得活，以后都可以参照这么做，没层次都有一个sum=0，返回值也是它，中间操作过程使用sum+=
		int sum = 0;
		//根据forbid数组的结果，递归进入下一层次
		for(int i = 0;i < n;++i) {
			if(forbid[i] == 0) {
				columns[curr] = i;
				sum += search(curr + 1, n, columns);
			}
		}
		return sum;
	}

}
