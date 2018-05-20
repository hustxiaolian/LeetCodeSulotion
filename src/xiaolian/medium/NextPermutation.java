package xiaolian.medium;

/**
 * 
 * @author 25040
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextPermutation(new int[] {5,4,7,5,3,2});
	}
	
	/**
	 * 思路：
	 * 1. 算是一个动态判断的过程，从尾部开始判断是否下一个数字是否比当前的大，大就继续向前判断，直到找到一个
	 * 不符合条件的数字停止，交换它和后缀中一个数字（该数字只比他稍大。），然后从后面的数字进行重排序。
	 * 
	 * test1:22ms, beats 21.87%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * test2:20ms, beats 63.89%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * 
	 * 尼玛，两次结果代码一点变化都没有，思路都一样，差距有点大。
	 * 另外，看了答案，思路跟我基本一致。
	 * 
	 * 二分法的改进思路适用于，这个数字非常大的时候，否则其优化效果不明显，甚至节省时间还不及函数调用产生的费用
	 * 
	 * test3:19ms ,beats 90.71%(ε=ε=ε=┏(゜ロ゜;)┛)我日哦，这尼玛玄学变化。
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		int n = nums.length;
        if(n <= 1) return;
        
        int i, j, temp1, temp2;
        for(i = n - 1; i > 0; --i) {
        	if(nums[i - 1] < nums[i])
        		break;
        }
        if(i <= 0) {
        	//没法找到更大的数字了，让他回到最小。
        	reserveSort(0, n -1, nums);
            return;
        }
        j = i;
        temp1 = nums[i - 1];
        //后期可以改进为二分搜索。因为后面是有序的。
        while(j < n && temp1 < nums[j])
        	j++;
        temp2 = nums[j - 1];
        
        nums[i - 1] = temp2;
        nums[j - 1] = temp1;
        
        //交换它们的顺序
        reserveSort(i, n - 1, nums);
    }
	
	/**
	 * 重排序输入范围内的数字。
	 * @param i
	 * @param j
	 * @param nums 
	 */
	private static final void reserveSort(int i, int j, int[] nums) {
		int temp;
		for(;i < j; ++i, --j) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
	}
	
	@SuppressWarnings("unused")
	private final static int binarySearch(int start, int end, int val, int[] nums) {
		if(start == end) {
			return start;
		}
		if(nums[end] > val)
			return end;
		
		while(start + 1 != end) {
			int mid = (start + end) / 2;
			if(val > nums[mid])
				start = mid;
			else
				end = mid;
				
		}
		
		if(nums[end] <= val)
			return start;
		else 
			return end;
	}
}
