package com.xinrui.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
	public static void main(String[] args) {
		
		System.out.println(102/100);
		
	}
	
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<Integer>();
		int times = 10;
		for(int i = left;left<=right;i++){
			if(i/times >0){
				
				times*=10;
			}
			
			
		}
		return list;
	}
}
