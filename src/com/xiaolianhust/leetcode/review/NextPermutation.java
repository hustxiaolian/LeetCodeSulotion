package com.xiaolianhust.leetcode.review;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,1};
		new NextPermutation().nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * 思路：
	 * 1. 如果个位数字 > 十位数字，那么直接交换两者即可。
	 * 2. 其他情况下，一律按照以下规则
	 * 	a. 从个位到高位，对于两个相邻的数字，左边的数字得大于右边位置的数字。如果遇到不满足上述条件的两个数字时，向左的遍历停下
	 *     设这两个数字在数字的位置为i,j. i=j+1.
	 *  b. 然后j向右遍历，直到nums[j] < nums[i] 或者j == n停下。
	 *  c. 新建两个变量p = i + 1, q = n -1,两者从两端向中间遍历，交换各自位置上的元素。
	 *  d. 最后，交换 位置i和位置((i+1)+tail)-(j-1)=tail+i-j+2的元素即可。
	 *  
	 *  ps:需要考虑的特殊请款那个很多。
	 *  
	 *  test1:18ms, beats 9.75% ε=ε=ε=┏(゜ロ゜;)┛
	 *  
	 *  这里我二逼了，完全可以先交换元素，在直接倒置，就没那么多笔试了。。
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
        int tail = nums.length - 1;
        if(tail == 0)
        	return;
        else if(tail == 1 && nums[tail] >= nums[tail - 1]) {
        	exchange(nums, tail, tail - 1);
        	return;
        }
        
        int i = tail - 1,j;
        while(i >= 0 && nums[i] >= nums[i + 1])
        	--i;
        //特殊情况处理。
        j = i + 1;
        if(i != -1) {
            while(j <= tail && nums[j] > nums[i])//不能等于
            	++j;
        }
        int p = i + 1, q = tail;
        while(p < q) {
        	exchange(nums, p, q);
        	++p;--q;
        }
        if(i != -1)
        	exchange(nums, i, tail + i - j + 2);
    }
	
	/**
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 */
	public void exchange(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/**
	 * 其实，这个版本就是我上面上面那个思路的改进版，思路调换了下顺序，马上效果就不一样了，而且简化特殊情况的判断。妙
	 * @param nums
	 */
	public void nextPermutation2(int[] nums) {
		int i = nums.length - 2;
		while(i >= 0 && nums[i] >= nums[i + 1])
			--i;
		if(i >= 0) {
			int j = nums.length - 1;
			while(nums[j] <= nums[i])
				--j;
			exchange(nums, i, j);
		}
		int p = i + 1, q = nums.length - 1;
		while(p < q) {
			exchange(nums, p, q);
			++p;--q;
		}
	}
}
