package com.xiaolianhust.leetcode.hard;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = {1,3};
		int[] n = {2};
		
		System.out.println(findMedianSortedArrays(m, n));
	}
	/**
	 * 思路：必然是二分搜索的变种。关键就是如何在两个数组中实现二分搜索。
	 * 20分钟内没想出解决方案，看答案。
	 * 
	 * 我去，原来对中值的理解可以是这样的。何谓中值？
	 * Dividing a set into two equal length subsets, that one subset is always greater than the other.
	 * 
	 * 那么将它用数学来表达就是：
	 * 1. 中值左半边的集合大小 = 中值右半边集合的大小
	 * 2. 左半边的最大值 <= 右半边的最小值
	 * medium = [max(left) + min(right)] /2;
	 * 
	 * 由此：我们假设第一个数组有m个元素，第二个数组有n个元素，A[i-1],A[i],B[j-1],B[j]
	 * i + j = m - i + n - j => if n >= m, j = (m + n + 1) /2 - 1;
	 * B[j - 1] <= A[i] and A[i - 1] <= B[j];
	 * 
	 * 由此思路就是在第一个数组中搜索i符合上面的条件即可。
	 * 
	 * test:65ms ,beats 95.82%。ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 这道题思路相当奇特，并且需要注意的细节也比较多，值得反复多次学习。
	 *  
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m, n;
		int[] A, B;
		
		if(nums1.length > nums2.length) {
			A = nums2;
			B = nums1;
		}
		else {
			A = nums1;
			B = nums2;
		}
		m = A.length;
		n = B.length;
		
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;//这里+1的原因在在于i,j都是指的右半边集合。
		while(iMin <= iMax) {
			int i = (iMax + iMin) / 2;
			int j = halfLen - i;
			//使用二分法搜索
			if(i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1;
			}
			else if(i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1;
			}
			else {
				int maxLeft = 0;
				if(i == 0)	
					maxLeft = B[j - 1];
				else if(j == 0)
					maxLeft = A[i - 1];
				else 
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				if((m + n) % 2 == 1) return maxLeft;
				
				int minRight = 0;
				if(i == m)
					minRight = B[j];
				else if(j == n)
					minRight = A[i];
				else
					minRight = Math.min(A[i], B[j]);
				
				return (maxLeft + minRight) / 2.0;
			}
		}
		
        return 0.0;
    }
}
