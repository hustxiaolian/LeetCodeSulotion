package com.xiaolianhust.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import com.xiaolianhust.leetcode.medium.MergeIntervals.Interval;

public class InsertInterval {
	
	public static void main(String[] args) {
		System.out.println();
	}
	/**
	 * ��һ��˼·��
	 * ������ϸ���⣬���ǿ��Կ�������������intervals�Ѿ�Ԥ�����ˡ�
	 * һ�ֺ�ֱ�ӵķ������Ǵ����ң��������뵽�ʵ���λ�ã�Ȼ��Ժ���ִ�кϲ�������
	 * 
	 * test1:9ms, beats 47.36%��=��=��=��(�b��b;)��
	 * ����discuss��˼·����Ҷ���࣬��һms�������ˣ��ҾͲ�ǿ���ˡ�
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0, n = intervals.size();
        List<Interval> result = new ArrayList<>();
        Interval curr;
        //�ж��������ĺ���λ��
        while(i < n && (curr = intervals.get(i)).start < newInterval.start) {
        	++i;
        	result.add(curr);
        }
        //���в����������������ں�
        Interval last;
        if(!result.isEmpty() && (last = result.get(result.size() - 1)).end >= newInterval.start) {
            last.end = Math.max(last.end, newInterval.end);
        }
        else 
        	result.add(newInterval);
        //�����п��ܵ��ں�
        last = result.get(result.size() - 1);
        while(i < n && last.end >= intervals.get(i).start)
        	last.end = Math.max(last.end, intervals.get(i++).end);
        while(i < n) 
        	result.add(intervals.get(i++));
        return result;
    }
}
