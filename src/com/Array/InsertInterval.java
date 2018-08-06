package com.Array;
import java.util.ArrayList;
/*
 *��ĳ������ϲ���һ���������������������
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
			if(newInterval.end < intervals.get(i).start) { //�յ�����С�������ٺϲ��ˣ�ֱ������ѭ��
				break;
			}
			if(newInterval.start > intervals.get(i).end) { //�����յ��ǰ��һ�����䲻�úϲ���ֱ�Ӽ�������
				res.add(intervals.get(i));
			}
			else {  //�ϲ�
				newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
				newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			}
		}
		res.add(newInterval);
		for(;i < intervals.size();i ++) { //���ʣ��ļ��
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
