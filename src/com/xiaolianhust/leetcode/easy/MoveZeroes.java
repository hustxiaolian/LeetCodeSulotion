package com.xiaolianhust.leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * 思路：
	 * 普通的思路就是遍历整个数组，如果当前元素为0， 将他移动数组后面，然后整个前移一位。但是这样会很慢。
	 * 时间复杂度。n^n;太慢了。
	 * 
	 * 改进思路：
	 * 使用两个指针，这次改换思路。
	 * 1. 首先遍历数组，寻找第一个0元素，用p1指向他。
	 * 2. 然后创建第二个指针p2，继续遍历数组，寻找非0元素时，将该元素赋值到p1处，然后p1指针向前移动一个。
	 * 3. 知道p2到最后，然后把p1指针以后的所有位置赋值为0；
	 * 
	 * test1:2ms, beats 36.78%ε=ε=ε=┏(゜ロ゜;)┛
	 * 看了discuss，基本思路是一致的，他们省略我的第一部分。速度更快一点点。
	 * 
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {
        int p1, n = nums.length;
        for(p1 = 0;p1 < n;++p1)
        	if(nums[p1] == 0)
        		break;
        if(p1 == n) return;
        int p2;
        for(p2 = p1 + 1;p2 < n;++p2) 
        	if(nums[p2] != 0)
        		nums[p1++] = nums[p2];
        for(;p1 < n;++p1)
        	nums[p1] = 0;
    }
}
