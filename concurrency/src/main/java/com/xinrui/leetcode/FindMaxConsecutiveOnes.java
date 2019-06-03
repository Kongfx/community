package com.xinrui.leetcode;

public class FindMaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = {1,1,0,1,0,1,1,1,1,1,1,0};
		
		findMaxConsecutiveOnes(nums);
	}
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
        	int s = nums[i];
        	if(s == 1){
        		temp++;
        	}else{
        		if(temp>max) max=temp;
        		temp = 0;
        	}
        }
		if(temp>max) max=temp;
    	return max;
    }

	
	
	
	
	
	
}
