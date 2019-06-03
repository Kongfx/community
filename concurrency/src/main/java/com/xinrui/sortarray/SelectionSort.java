package com.xinrui.sortarray;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SelectSour
 * @Description 选择排序
 * @Author kong
 * @Date 2019/5/24 10:30
 * @Version 1.0
 */
@Slf4j
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = SortTestHelper.generateRandomArray(10,0,500);
		arr = selectonSortTest(arr);
		log.info("arr={}",arr);
	}

	public static int[] selectonSortTest(int[] arr){
		long time = System.currentTimeMillis();
		for(int i=0;i<arr.length;i++){
			// 寻找[i,n) 区间内的最小值 minindex 即 j
			for (int j = i+1; j <arr.length ; j++) {
				if(arr[i]>arr[j]){
					SortTestHelper.swap(arr,i,j);
				}
			}
		}
		time = System.currentTimeMillis() - time;
		log.info("selectonSort 耗时 {} ms",time);
		return arr;
	}

}
