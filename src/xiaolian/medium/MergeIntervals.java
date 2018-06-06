package xiaolian.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author 25040
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		merge(Arrays.asList(new Interval[] {
				new Interval(1, 3),
				new Interval(2, 6),
				new Interval(8, 10),
				new Interval(15, 18)
		}));
	}
	
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	private static class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval arg0, Interval arg1) {
			return Integer.compare(arg0.start, arg1.start);
		}
	}
	
	/**
	 * 第一个思路：
	 * 注意到：题目没说一定是按照一个顺序的，因此不能直接一套合并过去。
	 * 思路还是比较简单清奇的，就是把每个Interval插入到这个树中。对每个节点判断是否融合
	 * 然后遍历树的每个节点，add到结果中。
	 * 
	 * 太麻烦了，而且时间界限还比不上这个方式
	 * 还是选择简单直接的第二种思路。
	 * 
	 * 第二个思路：
	 * 
	 * 
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge(List<Interval> intervals) {
		//初始化变量，以及处理特殊情况
		if(intervals.size() <= 1) return intervals;
		intervals.sort(new IntervalComparator());
        LinkedList<Interval> result = new LinkedList<>();
        print(intervals);
        for (Interval interval : intervals) {
        	
        	//当队列为空时，表明是第一次，肯定是要插入的。
			if(result.isEmpty() || result.getLast().end < interval.start) {
				//如果当前区间的头比上一个区间的尾巴还大，那没法合并
				result.add(interval);
			}
			else {
				//可以融合
				Interval mergrNode = result.getLast();
				mergrNode.end = Math.max(mergrNode.end, interval.end);
			}
		}
        return result;
    }
	
	private static void print(List<Interval> i) {
		System.out.print("{");
		for (Interval interval : i) {
			System.out.printf("[%d, %d]", interval.start, interval.end);
		}
		System.out.println("}");
	}
}
