package com.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *给定若干个间隔，融合区间重复的间隔
 *Given[1,3],[2,6],[8,10],[15,18],
  return[1,6],[8,10],[15,18]. 
 */
public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if(intervals.isEmpty() || intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>() { //先排序：start小的放前面
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}			
		});
		for(int i = 1;i < intervals.size();i ++) {
			int preStart = intervals.get(i - 1).start;
			int preEnd = intervals.get(i - 1).end;
			int curStart = intervals.get(i).start;
			int curEnd = intervals.get(i).end;
			if(preEnd >= curStart) { //区间有重复
				intervals.set(i, new Interval(preStart, Math.max(preEnd, curEnd)));
				intervals.set(i - 1, null);
			}
		}
		while(intervals.remove(null));
		return intervals;
    }
	
	public static void main(String[] args) {
		Interval interval = new Interval(2, 3);
		Interval interval2 = new Interval(4, 5);
		Interval interval3 = new Interval(6, 7);
		Interval interval4 = new Interval(8, 9);
		Interval interval5 = new Interval(1, 10);
		//Interval newInterval = new Interval(2, 3);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		
		ArrayList<Interval> res = new MergeIntervals().merge(intervals);
		for(int i = 0;i < res.size();i ++) {
			System.out.print("[" + res.get(i).start + ", " + res.get(i).end + "] ");
		}
	}
}
