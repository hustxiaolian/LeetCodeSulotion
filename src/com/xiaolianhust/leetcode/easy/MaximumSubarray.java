package com.xiaolianhust.leetcode.easy;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[] {-2,1}));
	}
	
	/**
	 * 思路：
	 * 联机算法的思路，这算是数据结构树上第一道让我大开眼界的题目。
	 * 
	 * 现在学习了dp，应该好好使用dp的思路来思考总结下：
	 * 1. 假设基准情形：
	 * f(0..i-1)及其之前的情况已知。现在看来，这个subSum的变量可以知道，真是相当厉害。
	 * 
	 * 2.根据当前情况来考虑。
	 * 2.1判断前面的subSum < 0，如果是说明前面这一串没有加上的必要，拖累后退，直接置0，然后获取nums[i]作为新subSum
	 * 2.2如果2.1不成立，那么说明前面那串还有价值，加上当前值判断是否>result，如果大则赋值，如果不是直接跳到下一轮
	 * 
	 * test1:11ms, beats 10.91%ε=ε=ε=┏(゜ロ゜;)┛我日，这么慢，让我看下前面大佬的优化在哪里。
	 * 好吧，就是我们那个特殊情况的判断要了命，通过调整顺序可以更加简洁。
	 * 
	 * test2:9ms,beats 52.00%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        int result = nums[0];
        int subSum = nums[0];
        
        for(int i = 1;i < n;++i) {
        	if(subSum < 0)
        		subSum = 0;
        	subSum += nums[i];
        	if(subSum > result) 
        		result = subSum;
        }
        
        return result;
    }
    
    /**
     * 相比于上个思路几乎一样，就是调整下结构，可以剪掉if(n==0)的判断
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
    	int n = nums.length;
    	int result = Integer.MIN_VALUE;
    	int subSum = 0;
    	for(int i = 0;i < n;++i) {
    		subSum += nums[i];
    		if(subSum > result)
    			result = subSum;
    		if(subSum < 0)
    			subSum = 0;
    	}
    	return result;
    }

}
