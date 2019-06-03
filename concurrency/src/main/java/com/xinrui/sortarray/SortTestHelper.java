package com.xinrui.sortarray;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组排序工具
 * @ClassName SortTestHelper
 * @Description TODO
 * @Author kong
 * @Date 2019/5/24 10:14
 * @Version 1.0
 */
public class SortTestHelper {


	/**
	 * 生成一个 指定长度的整形数组 取值范围 [L,R]
	 * @param n 数组长度
	 * @param rangeL 取值左边界（包括本身）
	 * @param rangerR 取值有边界（包括本身）
	 * @return 生成整形数组 arr
	 */
	public static int[] generateRandomArray(int n,int rangeL,int rangerR){
		int[] arr = new int[n];
		Random rand = new Random();
		for (int i = 0; i < n ; i++) {
			arr[i] = rand.nextInt(rangerR - rangeL + 1) + rangeL;
		}
		return arr;
	}

	/**
	 * 交换 数组 元素 位置
	 * @param arr 原数组
	 * @param i 索引1
	 * @param j 索引2
	 * @return
	 */
	public static int[] swap(int[] arr,int i,int j){
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
		return arr;
	}

	/**
	 * 复制数组
	 * @param arr
	 * @return
	 */
	public static int[] copyArr(int[] arr){
		int[] copy = Arrays.copyOf(arr,arr.length);
		return copy;
	}

	public static void main(String[] args) {
		int[] arr = generateRandomArray(10,100,120);
		System.out.println(Arrays.toString(arr));
		swap(arr,2,5);
		System.out.println(Arrays.toString(arr));
		int[] copy = copyArr(arr);
		System.out.println(Arrays.toString(copy));
	}
}
