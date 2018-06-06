package xiaolian.medium;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canJump2(new int[] {0,2}));
	}
	
	/**
	 * 思路：
	 * 从最开始的位置开始，递归的搜索路径，尽量先大跳，不行再小跳，只要找到一条马上返回true
	 * 具体请画图理解，同时利用递归的特性，来完成递归编程
	 * 
	 * bug 1:一开始数字太大，直接跳出去
	 * test1:time excuted out!太慢了。也就是我还得只能的寻找最短路径。
	 * 
	 * @param nums
	 * @return
	 */
    public static boolean canJump1(int[] nums) {
    	int tail = nums.length - 1;
        return seerchPath1(nums, 0, tail);
    }

	private static boolean seerchPath1(int[] nums, int i, int tail) {
		//基准情形，达到末尾了
		if(i == tail)
			return true;
		//遍历找寻所有可能的情形
		int nextStep = Math.min(nums[i], tail - i);
		for(;nextStep > 0; --nextStep) {
			if(seerchPath1(nums, i + nextStep, tail))
				return true;
		}
		return false;
	}
	
	/**
	 * 第二个思路：
	 * 其实我们仔细观察研究数组跳跃这个规律，我可以发现，完全可以把数组分块来处理。
	 * 每个块内，元素大小呈现成递减的趋势。
	 * 比如2 3 1 1 4数组分为2 | 3 1 1 | 4三个部分
	 * 比如2 3 1 1 2 数组分为2 | 3 1 1 |2 | 4四个部分。
	 * 同时跳跃只发生在块首部之间，这样就减少了不必要的递归。因此相比于上个版本，多个向前检查块的过程
	 * 
	 * test1:8ms, beats 91.89%ε=ε=ε=┏(゜ロ゜;)┛
	 * @param nums
	 * @return
	 */
	public static boolean canJump2(int[] nums) {
		return searchPath2(nums, 0, nums.length - 1);
	}

	private static boolean searchPath2(int[] nums, int i, int tail) {
		if(i >= tail)//基准情形
			return true;
		//向前检查下一个块首部,首字母相当于字可以屏蔽掉后面某些字母，求出的j就是小一个块首部
		int j = i;
		while(j <= tail && nums[j] + j <= nums[i] + i) 
			++j;
		//不能通过最后一个元素是否为0来判断，通过首部元素能够越过块的边界达到下一个块来判断
		if(j - 1 < tail && nums[i] + i <= j - 1)
			return false;
		return searchPath2(nums, j, tail);
	}

}
