package com.basic.datastructure05;

public class SelectK {
	public static int nativeSelectK(int[] m, int[] n, int k){
		int i = 0, j = 0;
		while(i<m.length && j <n.length){
			k--;
			if(m[i] < n[j]){
				if(k<=0)
					return m[i];
				i++;
			}else{
				if(k<=0)
					return n[j];
				j++;
			}
		}
		
		while(i<m.length){
			k--;
			if(k<=0){
				return m[i];
			}
			i++;
		}
		
		while(j<n.length){
			k--;
			if(k<=0){
				return n[j];
			}
			j++;
		}
		
		return -1;
	}
	
	public static void main(String[]args){
		int [] m = {1,2,3};
		int [] n = {2,3,4};
		System.out.println(nativeSelectK(m,n,1));
		System.out.println(nativeSelectK(m,n,2));
		System.out.println(nativeSelectK(m,n,3));
		System.out.println(nativeSelectK(m,n,4));
	}

}
