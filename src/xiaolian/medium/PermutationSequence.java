package xiaolian.medium;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4, 9));
	}
	
	/**
	 * 第一个思路：
	 * 首先，无法把整个list出来，这是肯定的。否则这道题也就没什么难度。
	 * 
	 * 具体思路步骤：
	 * 1.计算n - 1的阶乘，然后让--k之后，k / (n - 1)这个公式的含义就是它当这个阶乘下第result大的数字
	 * 2.计算k % (n-1)!作为下一次计算的k，同时k--，这余数的含义就是它在下一次是第几个数字。
	 * 
	 * 麻烦的就是得搞清楚数组索引和第几大这个对应关系，别搞错了。
	 * 这里涉及到一个动态规划得思想。
	 * 
	 * test1: 15ms, beats 99.05%ε=ε=ε=┏(゜ロ゜;)┛
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
