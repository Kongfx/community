package com.xinrui.sortarray;

import java.util.Arrays;

public class SortArrays {

	public static void main(String[] args) {
		int[] arr = {81,12,53,47,35,86,79,8};
		System.out.println(Arrays.toString(arr));
//		printArr(arr);
//		selectSort(arr);
//		insertionSort(arr);
//		bubbleSort(arr);
//		bubbleSortMax(arr);
		megerSort(arr);
		System.out.println(Arrays.toString(arr));
	}



	/*
	 *  插入排序
	 * */
	public static void insertionSort(int[] arr) {
		int excCount = 0;
		// 将a[]按升序排列
		for (int i = 1; i < arr.length; i++) {
			// 将 a[i] 插入到 a[i-1]、 a[i-2]、 a[i-3]...之中
			for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--){
				exc(arr, j, j - 1);
				excCount++;
				System.out.println("insertionSort:::length="+arr.length+"i="+i+";j="+j+Arrays.toString(arr));
			}
		}
		System.out.println("total exc =="+excCount);
	}

	/*
	*  选择排序
	* */
	public static void selectSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length && (arr[i] >= arr[j]); j++) {
				exc(arr,i,j);
				System.out.println("selectSort:::length="+arr.length+"i="+i+";j="+j+Arrays.toString(arr));
			}
		}
	}

	/*
	* 冒泡排序: low->high
	* */
	public static void bubbleSort(int[] arr) {
		for (int i = arr.length -1; i > 1; i--) {
			for (int j = arr.length -1; j >=arr.length -i ; j--) {
				if(arr[j-1] >= arr[j]){
					exc(arr,j,j-1);
				}
				System.out.println("bubbleSort:::length="+arr.length+"i="+i+";j="+j+Arrays.toString(arr));
			}
		}
	}

	/*
	 * 冒泡排序: high->low
	 * */
	public static void bubbleSortMax(int[] arr) {
		for(int i =1;i<arr.length-1;i++){
			for(int j=0;j<arr.length -i; j++){
				if(arr[j] >= arr[j+1]){
					exc(arr,j,j+1);
				}
				System.out.println("bubbleSortMax:::length="+arr.length+"i="+i+";j="+j+Arrays.toString(arr));
			}
		}
	}

	/*
	* 归并排序
	* */
	public static void megerSort(int [] arr){
		//1.先创建一个temp数组，排序完成后将temp 复制到原数组
		int[] temp = new int[arr.length];
		//2. 先将数组分为两个子数组（二叉树思想），并递归对子数组进行排序
		sort(arr,0,arr.length-1,temp);
	}

	private static void sort(int[] arr,int left,int right,int []temp){
		if(left<right){
			int mid = (left+right)/2;
			sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
			sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
			merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
		}
	}

	private static void merge(int[] arr,int left,int mid,int right,int[] temp){
		int i = left;//左序列指针
		int j = mid+1;//右序列指针
		int t = 0;//临时数组指针
		while (i<=mid && j<=right){
			if(arr[i]<=arr[j]){
				temp[t++] = arr[i++];
			}else {
				temp[t++] = arr[j++];
			}
		}
		while(i<=mid){//将左边剩余元素填充进temp中
			temp[t++] = arr[i++];
		}
		while(j<=right){//将右序列剩余元素填充进temp中
			temp[t++] = arr[j++];
		}
		t = 0;
		//将temp中的元素全部拷贝到原数组中
		while(left <= right){
			arr[left++] = temp[t++];
		}
		System.out.println("arr[]="+Arrays.toString(arr)+"temp[]="+Arrays.toString(temp));
	}

	public static int[] exc(int[] arr,int a,int b){
		int temp = 0;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}
}
