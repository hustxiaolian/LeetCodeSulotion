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
	 * ������������Ŀȫ�Ƕ���������
	 * ��������˼������һ��׼�����������ʹ�ö�������������˼·����һ����
	 * 
	 * ��һ��˼·�������ö�������ȷ���Ǹ�pivot��
	 * 
	 * �ڶ���˼·�����һ�ְ취ֱ��ʹ�ö�����������.
	 * ��Сʱû������õ�˼·������discuss���൱������¡�
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

	 * �����idea��rotate����������׸�Ԫ����������һ���м����ֵ��������������ֳ����Ρ�
	 * ��ÿ�ν��ж���������ʱ������ж�mid��target�Ƿ���ͬһ�ߡ�
	 * ������Ƕ�С�ڣ��������Ƕ��ں��棬�����ڱ�����ǰ�档��ʱ�������������������У���Ӱ�졣
	 * ���һ��һС���������
	 * ���ж�һ��target�Ĵ�С�����С���ײ�Ԫ�أ�˵��target�ٺ��棬��mid��ǰ�棬��ʱ��Ϊ�˱�֤������������ȷ�ԣ�����ʹ��-inf���滻��ǰmid��
	 * ͬ����������ײ�Ԫ�أ�˵��target��ǰ�棬��mid�ں���ȥ�ˣ�Ϊ�˰Ѷ��������ı߽�����ȷ�ķ������ߣ�ʹ��inf���滻��ǰmid.
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
