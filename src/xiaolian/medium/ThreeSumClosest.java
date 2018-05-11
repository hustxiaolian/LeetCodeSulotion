package xiaolian.medium;

import java.util.Arrays;

/**
 * 
 * 
 * 
 * @author 25040
 *
 *
 *Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
	}
	
	/**
	 * 首先，这道题说明中写了，肯定有答案，因此，可以省略一些特殊的输入情况。
	 * 其实，这题目和ThreeSum那道题非常类似。完全可以用那道题的思路来做。让我再想想有没有其他的骚操作。
	 * 思路和前面完全类似，再复习整理下把：
	 * the idea is:排序后，设置三个指针，第一个i从左到右遍历，第二个j = i+1, 第三个k = n-1.后面两个向中间移动。
	 * 判断这三个指针指向的数字相加的和 - target 是否比上次result更小。
	 * 
	 * bug 1 result初始化为Integer.max_value，使得如果target如果为负数，直接溢出了
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[2];
		int tail = nums.length - 1;
		int i,j,k,numi,sum;
		
		Arrays.sort(nums);
		outer:
		for(i = 0;i < tail - 1;) {
			numi = nums[i];
			j = i + 1;
			k = tail;
			while(j < k) {
				sum = numi + nums[j] + nums[k];
				if(sum < target) {
					++j;
					if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;
				}
				else if(sum > target) {
					--k;
					if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;
				}
				else if(sum == target) {
					result = sum;
					break outer;//相等的话，直接退出整个循环。因为它们已经完全相等了。
				}
			}
			while(nums[i] == nums[++i] && i < tail - 1);//跳过重复单元。
		}
		
        return result;
    }

}
