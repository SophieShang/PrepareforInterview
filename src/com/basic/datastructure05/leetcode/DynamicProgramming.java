package com.basic.datastructure05.leetcode;

public class DynamicProgramming {
	//maximum sum subarray
	public int maxSubArray(int[] A){
		int maxEndingHere = A[0], maxSoFar = A[0];
		for(int i=1; i<A.length; i++){
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
	
	public static void main(String[] args){
		int[] in = {1,-4,1,-5,2,-6};
		DynamicProgramming dp = new DynamicProgramming();
		System.out.println(dp.maxSubArray(in));
		
	}

}
