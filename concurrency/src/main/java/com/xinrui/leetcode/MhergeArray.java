package com.xinrui.leetcode;

import java.util.Arrays;

/**
 * @ClassName MhergeArray
 * @Description TODO
 * @Author kong
 * @Date 2019/2/15 16:33
 * @Version 1.0
 */
public class MhergeArray{
	public static void main(String[] args) {
		int[] a = {1,2,8,9,10};
		int[] b = {6,7,15};
		int[] result = mergr(a,b);
		System.out.println(Arrays.toString(result));
	}

	private static int[] mergr(int[] a, int[] b) {
		int[] temp = new int[a.length+b.length];
		int i = 0,j=0,k=0;
		while(i<a.length && j<b.length)
			if(a[i] <= b[j]) {
				temp[k++] = a[i++];
			}else{
				temp[k++] = b[j++];
			}
		while(i < a.length)
			temp[k++] = a[i++];
		while(j < b.length)
			temp[k++] = b[j++];
		return temp;
	}
}
