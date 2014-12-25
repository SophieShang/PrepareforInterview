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
	
	public int findK(int[] m, int mbegin, int mend, int[] n, int nbegin, int nend, int k){
		int mmid = (mbegin+mend)/2;
		int l1 = mmid - mbegin + 1;
		int nmid = (nbegin+nend)/2;
		int l2 = nmid - nbegin + 1;
		while(mbegin < mend && nbegin < nend){
			if(m[mmid] < n[nmid]){
				if(l1+l2 > k){
					return findK(m, mbegin, mend, n, nbegin, nmid, k);
				}else{
					return findK(m, mmid, mend, n, nbegin, nend, k-l1);
				}
			}
			if(m[mmid] >= n[nmid]){
				if(l1+l2 > k){
					return findK(m, mbegin, mmid, n, nbegin, nmid, k);
				}else{
					return findK(m, mbegin, mend, n, nmid, nend, k-l2);
				}
			}
		}
		return -1;
	}
	
	public static void main(String[]args){
		int [] m = {0,1,2,3};
		int [] n = {2,3,4};
		/*System.out.println(nativeSelectK(m,n,1));
		System.out.println(nativeSelectK(m,n,2));
		System.out.println(nativeSelectK(m,n,3));
		System.out.println(nativeSelectK(m,n,4));
*/		
		SelectK sk = new SelectK();
		System.out.println(sk.findK(m, 0, 3, n, 0, 2, 3));
		
	}

}
