package com.xinrui.sortarray;

import lombok.extern.slf4j.Slf4j;

/**
 * 插入排序
 * @ClassName InsertionSort
 * @Description TODO
 * @Author kong
 * @Date 2019/5/27 16:30
 * @Version 1.0
 */
@Slf4j
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = SortTestHelper.generateRandomArray(10,0,50);
		insertionSortTest(arr);
		log.info("arr={}",arr);
		insertionSortBetterTest(arr);
		log.info("arr={}",arr);
	}

	public static int[] insertionSortTest(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(arr[j-1] > arr[j]){
					SortTestHelper.swap(arr,j,j-1);
				}else{
					//因为 每轮中i 之前的元素都已经是有序的了 所以如果
					//j 已经大于 j-1 则说明 j-1也是大于j-2
					//因此内层循环 j 已经不需要再去比较了
					//可以进行下一个 i 循环
					//由于可以提前结束内层循环  因此对于一个大致有序的数组采用插入排序是效率更高
					break;
				}
			}
		}
		return arr;
	}

	public static int[] insertionSortBetterTest(int[] arr){

		for (int i = 1; i < arr.length; i++) {
			int e = arr[i];//保留当前 i 位置的元素
			int j;
			for (j = i; j > 0; j--) {
				if(arr[j-1] > e){
					arr[j] = arr[j-1];
				}else{
					break;
				}
			}
			arr[j] = e;
		}
		return arr;
	}
}
