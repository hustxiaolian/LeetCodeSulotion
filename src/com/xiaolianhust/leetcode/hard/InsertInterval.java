package com.xiaolianhust.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import com.xiaolianhust.leetcode.medium.MergeIntervals.Interval;

public class InsertInterval {
	
	public static void main(String[] args) {
		System.out.println();
	}
	/**
	 * 第一种思路：
	 * 首先仔细看题，我们可以看到，它假设了intervals已经预排序了。
	 * 一种很直接的方法就是从左到右，将它插入到适当的位置，然后对后面执行合并操作。
	 * 
	 * test1:9ms, beats 47.36%ε=ε=ε=┏(゜ロ゜;)┛
	 * 看了discuss的思路，大家都差不多，这一ms，就算了，我就不强求了。
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0, n = intervals.size();
        List<Interval> result = new ArrayList<>();
        Interval curr;
        //判断区间插入的合适位置
        while(i < n && (curr = intervals.get(i)).start < newInterval.start) {
        	++i;
        	result.add(curr);
        }
        //进行插入区间和新区间的融合
        Interval last;
        if(!result.isEmpty() && (last = result.get(result.size() - 1)).end >= newInterval.start) {
            last.end = Math.max(last.end, newInterval.end);
        }
        else 
        	result.add(newInterval);
        //向后进行可能的融合
        last = result.get(result.size() - 1);
        while(i < n && last.end >= intervals.get(i).start)
        	last.end = Math.max(last.end, intervals.get(i++).end);
        while(i < n) 
        	result.add(intervals.get(i++));
        return result;
    }
}
