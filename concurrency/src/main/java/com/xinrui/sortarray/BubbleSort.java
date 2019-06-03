package com.xinrui.sortarray;

import lombok.extern.slf4j.Slf4j;

/**
 * 冒泡排序
 * @ClassName BubbleSort
 * @Description TODO
 * @Author kong
 * @Date 2019/5/24 22:12
 * @Version 1.0
 */
@Slf4j
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = SortTestHelper.generateRandomArray(5,0,100);
		log.info("begin arr={}",arr);
		bubbleSortTest(arr);
		log.info("end arr={}",arr);
	}

	public static int[] bubbleSortTest(int[] arr){
		long time = System.currentTimeMillis();
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length - 1 -i; j++) {
				if(arr[j] > arr[j+1]) {
					SortTestHelper.swap(arr,j,j+1);
				}
			}
		}
		log.info("bubbleSort 耗时 {} ms",time - System.currentTimeMillis());
		return arr;
	}

}
