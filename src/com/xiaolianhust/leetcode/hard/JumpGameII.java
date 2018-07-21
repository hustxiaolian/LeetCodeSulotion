package com.xiaolianhust.leetcode.hard;

public class JumpGameII {
	public static void main(String[] args) {
		System.out.println(jump3(new int[] {1,2,3}));
	}
	
	/**
	 * ��һ�ֺ���˼·��
	 * �Ҿ�����̵���·�������ϴ��������֣�����������ֿ顣ֻ��ͷ�ڵ㡣
	 * �ð������е����⣬����̰�������ַ�����������ֻ��һ�ֿ�ѡ�ķ��������������·��
	 * 
	 * �ڶ��ֺ���˼·��
	 * һ��������Ӧ�õı��µ�BFS(�����������)�ı��֣��������ÿ��Ԫ�ص���һ��ͼ�е�һ���ڵ㡣
	 * ����������ÿ���ڵ㣬���ǿ����������ǰ��һ��Σ�������ýڵ��·������ͬ�����ܵ������Զ�Ľڵ㣬Ҳ����ȷ��
	 * ��һ������нڵ�ķ�Χ��nextStart=currEnd+1, nextEnd = max(nums[currIndex]),
	 * �ɴˣ����ǿ��ԾͿ��Ը��ݹ������������˼�룬һ���ļ��㵽��ýڵ�����Ҫ��������
	 * ����һ��㣬�����ݽ������˼�����ǹ������������˼�룬�����������ڣ���ÿ�����Ĺ����к�ȷ������һ��ķ�Χ��
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
