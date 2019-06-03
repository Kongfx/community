package com.xinrui.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName MaxArea
 * @Description TODO
 * @Author kong
 * @Date 2019/5/28 17:00
 * @Version 1.0
 */
@Slf4j
public class MaxArea_11_N {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,8};
		int area = maxArea(height);
		log.info("maxArea={}",area);
	}

	/**
	 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 * 说明：你不能倾斜容器，且 n 的值至少为 2。
	 * 输入: [1,8,6,2,5,4,8,3,7]
	 * 输出: 49
	 *
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int max = 0,len = 0,absHi = 0,area = 0;
		for (int i = 1; i < height.length ; i++) {
			for (int j = i - 1; j >= 0  ; j--) {
				len = i-j;
				absHi = height[i] <= height[j] ? height[i] : height[j] ;
				area = Math.multiplyExact(len,absHi);
				if(max < area){
					max = area;
				}
			}
		}
		return max;
	}
}
