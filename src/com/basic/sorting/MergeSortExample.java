package com.basic.sorting;

public class MergeSortExample {
	public void mergeSort(Object src[],Object[] dest, int low, int high){
		int length = high - low;
		if(length < 3){
			for(int i=high;i>=0;i--){
				for(int j=i;j>=0;j--){
					if((((Comparable) dest[i]).compareTo(dest[j]))<0)
						swap(dest,i,j);
				}
			}
			return;
		}
		
		int mid = (low+high)/2;
		mergeSort(src,dest,low,mid);
		mergeSort(src,dest,mid,high);
		
		int i = low;
		int j= mid;
		int k= low; //k是生成合并数组的下标
		
		while(i<mid && j<high){
			if((((Comparable)src[i]).compareTo(src[j]))<=0){
				dest[k++] = src[i++];
			}else{
				dest[k++] = src[j++];
			}
		}
		while(i<mid && k<high){
			dest[k++] = src[i++];
		}
		while(j<high && k<high){
			dest[k++] = src[j++];
		}
		
	}
	
	static void display(Object[] obj){
		System.out.println("数组为：");
		for(int i=0;i<obj.length;i++){
			System.out.print(obj[i]);
		if(i<obj.length-1)
			System.out.print(", ");
		}
		System.out.println();
	}
	
	static void swap(Object[] obj, int i, int j){
		Object temp;
		temp = obj[i];
		obj[i] = obj[j];
		obj[j] = temp;
	}
	
	public static void main(String[] args){
		Integer in[] = {5,7,15,1,79,9};
		Integer dest[] = in;
		MergeSortExample mse = new MergeSortExample();
		mse.display(in);
		mse.mergeSort(in, dest, 0, in.length-1);
		System.out.println("排序后的数组为：");
		mse.display(dest);
		
	}

}
