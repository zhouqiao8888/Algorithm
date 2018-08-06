package com.pinduoduo;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			long n = s.nextLong();
			List<String> list = new ArrayList<String>();
			long count = 0;
			while(count < n) { 
				long loopCount = count / 4;
				for(long i = 0;i <= loopCount && count < n;++ i) {
					list.add("Alice");
					count ++;
				}
				for(long i = 0;i <= loopCount && count < n;++ i) {
					list.add("Bob");
					count ++;
				}
				for(long i = 0;i <= loopCount && count < n;++ i) {
					list.add("Cathy");
					count ++;
				}
				for(long i = 0;i <= loopCount && count < n;++ i) {
					list.add("Dave");
					count ++;
				}
			}
			//System.out.println(list);
			System.out.println(list.get(list.size() - 1));
		}
	}
}
