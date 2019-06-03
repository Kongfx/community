package com.xinrui.leetcode;

public class HasAlternatingBits {
	public static void main(String[] args) {
		String s= Integer.toBinaryString(11);
		System.out.println(hasAlternatingBits(5) );
	}
	 public static boolean hasAlternatingBits(int n) {
		 String s= Integer.toBinaryString(n);
		 if(s.contains("00") || s.contains("11")){
			 return false ;
		 }
		 return true;
	 }
	
}
