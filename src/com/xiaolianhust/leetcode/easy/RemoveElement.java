package com.xiaolianhust.leetcode.easy;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路：从头到尾遍历整个数组，遇到target，将它交互到尾部，或者说用尾部的元素覆盖他，并且用一个变量记录n - 1.
	 * 再判断这个替换原始是否是val，否则再用n - 2替换，直到不等于val为止。
	 * 相比于不等于的那种方式，如果val的值不超过数组元素的一半。那么它拥有更小的内存读写次数。（个人认为）
	 * 而且这里再深挖细节，意义不大。
	 * 
	 * test1:9ms, beat 99.06%(ε=ε=ε=┏(゜ロ゜;)┛)
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n <= 0) return 0;
        int i;
        for(i = 0; i < n;) {
        	if(nums[i] == val) 
        		nums[i] = nums[--n];
        	else 
        		++i;
        }
        
        return n;
    }
	
	public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        if(n <= 0) return 0;
        int i, j;
        for(i = 0, j = 0; i < n;++i) {
        	if(nums[i] != val) 
        		nums[j++] = nums[i];
        }
        
        return n;
    }
}
