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
	 * ��һ��˼·��
	 * ע�⵽����Ŀû˵һ���ǰ���һ��˳��ģ���˲���ֱ��һ�׺ϲ���ȥ��
	 * ˼·���ǱȽϼ�����ģ����ǰ�ÿ��Interval���뵽������С���ÿ���ڵ��ж��Ƿ��ں�
	 * Ȼ���������ÿ���ڵ㣬add������С�
	 * 
	 * ̫�鷳�ˣ�����ʱ����޻��Ȳ��������ʽ
	 * ����ѡ���ֱ�ӵĵڶ���˼·��
	 * 
	 * �ڶ���˼·��
	 * 
	 * 
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge(List<Interval> intervals) {
		//��ʼ���������Լ������������
		if(intervals.size() <= 1) return intervals;
		intervals.sort(new IntervalComparator());
        LinkedList<Interval> result = new LinkedList<>();
        print(intervals);
        for (Interval interval : intervals) {
        	
        	//������Ϊ��ʱ�������ǵ�һ�Σ��϶���Ҫ����ġ�
			if(result.isEmpty() || result.getLast().end < interval.start) {
				//�����ǰ�����ͷ����һ�������β�ͻ�����û���ϲ�
				result.add(interval);
			}
			else {
				//�����ں�
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
