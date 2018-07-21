package com.xiaolianhust.leetcode.hard;

public class JumpGameII {
	public static void main(String[] args) {
		System.out.println(jump3(new int[] {1,2,3}));
	}
	
	/**
	 * 第一种核心思路：
	 * 我觉得最短的套路就是我上次做的那种，将整个数组分块。只跳头节点。
	 * 好吧这套有点问题，不够贪婪。这种方法做出来的只是一种可选的方案。而不是最短路径
	 * 
	 * 第二种核心思路：
	 * 一种在数组应用的别致的BFS(广度优先搜索)的变种，将数组的每个元素当成一个图中的一个节点。
	 * 这样，根据每个节点，我们可以推算出当前这一层次（即到达该节点的路径数相同）所能到达的最远的节点，也就能确定
	 * 下一层次所有节点的范围，nextStart=currEnd+1, nextEnd = max(nums[currIndex]),
	 * 由此，我们可以就可以根据广度优先搜索的思想，一层层的计算到达该节点所需要的跳数。
	 * 这种一层层，慢慢递进计算的思想正是广度优先搜索的思想，而变种则在于，在每层计算的过程中红确定了下一层的范围。
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static int jump(int[] nums) {
		int n = nums.length;
		int[] bfs = new int[n];
		BFS(nums, 1, Math.min(nums[0], n - 1), bfs);
		return bfs[n - 1];
    }

	private static void BFS(int[] nums, int start, int end, int[] bfs) {
		if(start >= nums.length)
			return;
		int nextEnd = 0;
		for(int i = start;i <= end;++i) {
			nextEnd = Math.max(nextEnd, nums[i] + i);
			bfs[i] = bfs[start - 1] + 1;
		}
		BFS(nums, end + 1, Math.min(nextEnd, nums.length - 1), bfs);
	}
	
	public static int jump2(int[] nums) {
		int n = nums.length;
		int[] bfs = new int[n];
		bfs[0] = 0;
		int start = 1, end = Math.min(nums[0], n - 1);
		while(start < n) {
			int i, nextEnd = 0;
			for(i = start;i <= end;++i) {
				nextEnd = Math.max(nextEnd, i + nums[i]);
				bfs[i] = bfs[start - 1] + 1;
			}
			start = end + 1;
			end = Math.min(n - 1, nextEnd);
		}
		return bfs[n - 1];
	}
	
	public static int jump3(int[] nums) {
		int n = nums.length;
		int result = 0;
		int start = 1, end = Math.min(nums[0], n - 1);
		while(start < n) {
			int nextEnd = 0;
			for(int i = start;i <= end;++i) {
				nextEnd = Math.max(nextEnd, i + nums[i]);
			}
			result++;
			start = end + 1;
			end = Math.min(n - 1, nextEnd);
		}
		return result;
	}
}
