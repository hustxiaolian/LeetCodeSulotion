package com.xiaolianhust.leetcode.medium;

public class MaxArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 思路：就是那种一眼谁都能想到的方法。暴力循环检测。
	 * 
	 * 结果：time out!果然这种货色。
	 * 我本来想借鉴参考最长子序列和那种线性算法，找到最大值和遍历扫过得每个小块直接得关系，依次来完成线性算法。
	 * 但是，我总觉得从左到右依次扫描过去，也就是在线联机算法，应该是存在得。我再想想。
	 * 想了半小时，没有半点思路和头绪，看了官方solution。真是一个字，妙！两个字：优雅
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea1(int[] height) {
        int n = height.length;
        int result = 0;
		for(int i = 0;i < n;++i) {
			for(int j = i;j < n;++j) {
				if(Math.min(height[i], height[j]) * (j - i) > result) {
					result = Math.min(height[i], height[j]) * (j - i);
				}
			}
		}
		
		return result;
    }
	
	/**
	 * 其核心思想就是：
	 * 面积 = x * min_y，那么我们先让x最大，然后，我们逐渐向中间移动。
	 * 画图理解，如果我从数组两端开始，我们判断两个指针对应的大小。我们把其中值较小的指针向中间移动。
	 * 为了我们要这么做，因为如果我们移动长的那边，由于短边限制，那么仅仅只是减小了x，而min_y还是没增大，这就没必要判断了。
	 * 而这种算法省略了正是这部分没意义的运算。所以才能达到线性。
	 * 
	 * 结果：8ms,打败95%。
	 * 比起其他结果更快的原因，使用局部变量减少不必要的内存调用。
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
		int n = height.length;
		int result = 0;
		int sline, eline;//高速缓冲原理。
		
		for(int s = 0, e = n - 1;s < e;) {
			sline = height[s];
			eline = height[e];
			if(sline > eline) {
				result = Math.max(result, eline * (e - s));
				--e;
			}
			else {
				result = Math.max(result, sline * (e - s));
				++s;
			}
		}
		
		return result;
	}

}
