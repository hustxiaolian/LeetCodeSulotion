package xiaolian.medium;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] {1,1,2,2,2,2,3,4,4,5}));
	}
	
	/**
	 * 第一种思路：
	 * 首先设定一个计数器，cnt
	 * 一旦扫描到三个或者以上的重复元素时，执行后面元素向前面的覆盖工作。
	 * 日，忘记了，我为什么不用双指针了。
	 * test1:2ms,beats 65.20% ε=ε=ε=┏(゜ロ゜;)┛
	 * 编码的过程中，以及编码完成后感觉不太好骂我总感觉这道题，我这么写特别啰嗦和麻烦。
	 * 
	 * 第二种思路：
	 * 参考了discuss，简直神人也。
	 * 它的核心idea，在于我不将重点放在如何判断重复上，而是换了一个角度，思考，
	 * 新的数组中只允许两个重复，你后面要存进来的数组，必须大于我的倒数第二位，
	 * 假设末端现在3，4，那么再碰到一个4，还是可以存进来，那么为3，4，4。
	 * 之后，后续的4就不能进来了。但是比他大的可以，因为数组时排序的。妙，真是妙！
	 * 
	 * {@link 现在看看和它类似的题目}
	 * @param nums
	 * @return
	 */
    public static int removeDuplicates(int[] nums) {
        int result = nums.length;
        int n = result;
        int i = 1, j = 1;
        int currRepeat = 1;
        while(i < n) {
        	if(nums[i - 1] == nums[i]) {
        		currRepeat++;
        		if(currRepeat > 2) {
        			++i;
        			while(i < n && nums[i] == nums[i - 1]) {
        				currRepeat++;
        				i++;
        			}
        			if(i >= n)
                		break;
        			currRepeat = 1;
        		}
        	}
        	else
        		currRepeat = 1;
        	
        	nums[j] = nums[i];
        	++j;++i;
        }
        return j;
    }
    
    /**
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
	   int i = 0;
	   for (int n : nums)
	      if (i < 2 || n > nums[i - 2])
	         nums[i++] = n;
	   return i;
	}

}
