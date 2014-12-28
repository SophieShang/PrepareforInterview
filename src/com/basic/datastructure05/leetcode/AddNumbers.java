package com.basic.datastructure05.leetcode;

import java.util.*;

public class AddNumbers {
	//在数组中找到相加之和为target的两个数，并返回其下标
	//O(n) runtime, O(n) space -- Hash table
	public int[] twoSum(int[] numbers, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++){
			int x = numbers[i];
			if(map.containsKey(target - x)){
				return new int[]{map.get(target-x)+1, i+1}; //下标从0计数，+1
			}
			map.put(x, i);  //数字本身作为key，下标做为value
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	//if input array is sorted
	
	public int[] twoSorted(int[] numbers, int target){
		//use Binary search, O(nlogn) runtime, O(1) space
		for(int i=0; i<numbers.length; i++){
			int j = bsearch(numbers, target-numbers[i], i+1);
			if(j != -1){
				return new int[] {i+1, j+1};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private int bsearch(int[] A, int key, int start) {
		int L = start, R = A.length -1;
		while(L < R){
			int M = (L+R)/2;
			if(A[M] < key){
				L = M+1;
			}else{
				R = M;
			}
		}
		return (L == R && A[L] == key)? L:-1;
	}
	
	//O(n) runtime, O(1) space -- Two pointers
	public int[] twoPointers(int[] numbers, int target){
		int i=0, j=numbers.length-1;
		while(i<j){
			int sum = numbers[i]+numbers[j];
			if(sum < target){
				i++;
			}else if(sum > target){
				j--;
			}else{
				return new int[]{i+1,j+1};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
 