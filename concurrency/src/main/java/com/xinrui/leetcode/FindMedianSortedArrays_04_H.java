package com.xinrui.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @ClassName FindMedianSortedArrays_04_H
 * @Description TODO
 * @Author kong
 * @Date 2019/5/28 15:53
 * @Version 1.0
 */
@Slf4j
public class FindMedianSortedArrays_04_H {

	public static void main(String[] args) {
		int[] nums1 = {1, 2}, nums2 = {3,4};
		double d = findMedianSortedArrays(nums1, nums2);
		log.info("findMedianSortedArrays={}",d);
	}

	/**
	 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
	 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
	 * 你可以假设 nums1 和 nums2 不会同时为空。
	 * 示例 1:
	 * nums1 = [1, 3] nums2 = [2]
	 * 则中位数是 2.0
	 *
	 * 示例 2:
	 * nums1 = [1, 2] nums2 = [3, 4]
	 * 则中位数是 (2 + 3)/2 = 2.5
	 *
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length,n2=nums2.length,len=n1+n2,i=0,j=0;
		int[] aus = new int[len];
		for (int k = 0;k<aus.length;k++){
			if(i > n1-1){
				aus[k] = nums2[j];
				j++;
			}else if(j > n2-1){
				aus[k] = nums1[i];
				i++;
			}else if(nums1[i] <= nums2[j]){
				aus[k] = nums1[i];
				i++;
			}else{
				aus[k] = nums2[j];
				j++;
			}
		}
		log.info("aus={}", Arrays.toString(aus));
		if(aus.length%2 != 0){
			return  aus[aus.length/2];
		}else{
			return ((double) aus[aus.length/2]+(double) aus[aus.length/2 - 1])/2;
		}
	}
}
