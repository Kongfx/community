package com.xinrui.sortarray;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author kong
 * @Date 2019/5/24 21:29
 * @Version 1.0
 */
@Slf4j
public class MergeSort {

	private int[] mergeSort(int[] arr,int n){

		int l=0,r=0;
		int mid = (l+r)/2;
		return arr;
	}

	private static int[] merge(int[] a,int[] b,int n){
		int[] arr = new int[n];
		int k = 0,i = 0,j = 0;
		for (k = 0; k < n; k++) {
			//判断边界
			if(i > a.length-1){
				arr[k] = b[j]; j++;
			}else if(j > b.length-1){
				arr[k] = a[i];i++;
			}else if(a[i] > b[j]){
				arr[k] = b[j];
				j++;
			}else {
				arr[k] = a[i];
				i++;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] a = {1,3,5,7},b={2,4,8,9};
		int[] arr = merge(a, b, a.length + b.length);
		log.info("arr={}",arr);

	}
}
