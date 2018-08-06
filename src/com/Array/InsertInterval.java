package com.Array;
import java.util.ArrayList;
/*
 *将某个间隔合并到一个间隔数组里，间隔定义如下
 *Given[1,2],[3,5],[6,7],[8,10],[12,16], 
 *insert and merge[4,9]in as[1,2],[3,10],[12,16].  
 */
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if(intervals.isEmpty() && newInterval == null)
			return res;
		int i = 0;
		for(;i < intervals.size();i ++) {
			if(newInterval.end < intervals.get(i).start) { //终点比起点小，不用再合并了，直接跳出循环
				break;
			}
			if(newInterval.start > intervals.get(i).end) { //起点比终点大，前面一个区间不用合并，直接加入数组
				res.add(intervals.get(i));
			}
			else {  //合并
				newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
				newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			}
		}
		res.add(newInterval);
		for(;i < intervals.size();i ++) { //添加剩余的间隔
			res.add(intervals.get(i));
		}
		return res;
    }
	
	public static void main(String[] args) {
		Interval interval = new Interval(1, 5);
		Interval interval2 = new Interval(3, 5);
		Interval interval3 = new Interval(6, 7);
		Interval interval4 = new Interval(8, 10);
		Interval interval5 = new Interval(12, 16);
		Interval newInterval = new Interval(2, 3);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
//		intervals.add(interval);
//		intervals.add(interval2);
//		intervals.add(interval3);
//		intervals.add(interval4);
//		intervals.add(interval5);
//		
		ArrayList<Interval> res = new InsertInterval().insert(intervals, newInterval);
		for(int i = 0;i < res.size();i ++) {
			System.out.print("[" + res.get(i).start + ", " + res.get(i).end + "] ");
		}
	}
}
