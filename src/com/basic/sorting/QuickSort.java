package com.basic.sorting;

public class QuickSort {
	public static void quickSort(String[] str, int begin, int end){
		if(begin >= end){
			return;
		}
		int pivot = begin;
		int low = begin;
		int high = end;
		
		String key = str[begin];
		
 		while(low < high){//先从后往前找到比key小的字符串，然后再从前往后找到比key大的字符串
			while(low < high){
				if(str[high].compareTo(key) < 0){
					str[low] = str[high];
					break;
				}
				high--;
			}
			
			while(low < high){
				if(str[low].compareTo(key) > 0){
					str[high] = str[low];
					break;
				}
				low++;
			}
		}
 		pivot = low;
 		str[pivot] = key;
 		//2, 5, 3, 1, 6, 4
 		//1, 5, 3, 1, 6, 4 //high = 3, low = 0, key = 2
 		//1, 2, 3, 5, 6, 4 //high = 3, low = 1
 		//1,2,3,4,6,4 // hight =5, low = 3., key =5
 		//1,2,3,4,6,6 // high = 5, low = 4, key = 5
 		//1,2,3,4,5,6// high=4, low=4, key=5
		
		quickSort(str, begin, pivot - 1);
		quickSort(str, pivot + 1, end);
	}

	static void display(String[]array){
		for(String str:array){
			System.out.print(str+ " ");
		}
		System.out.println();
	}
	
	public static void main(String[]args){
		String[] strArray = new String[]{"45", "21", "399", "96","43", "5","37"};
		display(strArray);
		quickSort(strArray, 0, strArray.length-1);
		display(strArray);
	}
}
