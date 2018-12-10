package com.xiaolianhust.leetcode.review;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RemoveElement().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
	}
	
	/**
	 * 思路：
	 * 遍历整个数组，当遇到欲删除的元素时，取出当前数组的最后一个元素，覆盖它，并且将数组长度记录变量-1
	 * 
	 * test1:8ms, beats 19.13%
	 * 
	 * 其他的思路，双指针，i遍历整个数组，j只有当nums[i] != val时记录和移动。而且这种方式还可以保证其他元素的相对位置不变。
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
        int tail = nums.length - 1;
        for(int i = 0;i <= tail;) {
        	if(nums[i] == val) {
        		nums[i] = nums[tail--];
        	} else {
        		++i;
        	}
        }
        return tail + 1;
    }
	
	/**
	 * 双指针方案
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement2(int[] nums, int val) {
		int j = 0;
		for(int i = 0; i < nums.length;++i)
			if(nums[i] != val)
				nums[j++] = nums[i];
		return j;
	}
}
