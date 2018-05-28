package xiaolian.medium;


/**
 * 
 * @author 25040
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		search(new int[] {12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 0);
	}
	
	/**
	 * 这两天做的题目全是二分搜索。
	 * 这道题的意思就是在一个准排序的数组中使用二分搜索。但是思路还是一样。
	 * 
	 * 第一种思路，首先用二分搜索确定那个pivot。
	 * 
	 * 第二种思路，想出一种办法直接使用二分搜索法来.
	 * 半小时没想出来好的思路，看了discuss，相当巧妙。可怕。
	 * 
	 * Let's say nums looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

Because it's not fully sorted, we can't do normal binary search. But here comes the trick:

    If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
    [12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]

    If target is let's say 7, then we adjust nums to this:
    [-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

And then we can simply do ordinary binary search.

Of course we don't actually adjust the whole array but instead adjust only on the fly only the elements we look at. 
And the adjustment is done by comparing both the target and the actual element against nums[0].

If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid]. Otherwise we use -infinity or +infinity as needed.

	 * 其核心idea，rotate过后的数组首个元素往往就是一个中间的阈值，它将整个数组分成两段。
	 * 在每次进行二分搜索的时候，如果判断mid和target是否在同一边。
	 * 如果他们都小于，表明他们都在后面，都大于表明在前面。此时二分搜索可以正常进行，不影响。
	 * 如果一大一小，分情况。
	 * 再判断一次target的大小，如果小于首部元素，说明target再后面，而mid在前面，这时候为了保证二分搜索的正确性，我们使用-inf来替换当前mid。
	 * 同理，如果大于首部元素，说明target在前面，而mid在后面去了，为了把二分搜索的边界往正确的方向上走，使用inf来替换当前mid.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
        	int mid = (left + right) / 2;
        	double tempMid;
        	if((nums[mid] < nums[0]) == (target < nums[0])) {
        		tempMid = nums[mid];
        	}
        	else if(target < nums[0]) {
        		tempMid = Double.NEGATIVE_INFINITY;
        	}
        	else 
        		tempMid = Double.POSITIVE_INFINITY;
        	
        	if(target < tempMid)
        		right = mid;
        	else if(target > tempMid)
        		left = mid + 1;
        	else 
        		return mid;
        }
        return -1;
    }
	
    public static int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while(lo < hi) {
        	int mid = (lo + hi) / 2;
        	double num = (nums[mid] < nums[0]) == (target < nums[0])?
        			nums[mid] : target < nums[0] ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        	if(num < target)
        		lo = mid + 1;
        	else if(num > target)
        		hi = mid;
        	else 
        		return mid;
        }
    	
    	return -1;
    }

}
