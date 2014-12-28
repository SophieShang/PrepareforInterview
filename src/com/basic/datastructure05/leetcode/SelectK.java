package com.basic.datastructure05.leetcode;

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
        if(mbegin > mend && nbegin > nend){
            throw new IllegalStateException("Invalid State");
        }

        if (mbegin > mend){
            return n[k-1+nbegin];
        }

        if (nbegin > nend){
            return m[k-1+mbegin];
        }

        int mmid = (mbegin+mend)/2;
		int l1 = mmid - mbegin + 1;
		int nmid = (nbegin+nend)/2;
		int l2 = nmid - nbegin + 1;

        // mid divide each array into two parts, A or B,
        // then, we have 4 parts, mA, mB, nA, nB
        //

        if (m[mmid] < n[nmid]) {
            if (l1 + l2 > k) { // l1+l2>=k+1, n[nmid] must not be the kth, exclude it
                // no nB
                return findK(m, mbegin, mend, n, nbegin, nmid-1, k);
            } else { // l1+l2<=k
                // no mA, m[mmid] must not be the kth(if it is, then we have n[nmid]<=m[mmid]), which is not satisfiable
                // exclude the first l1 element in [mbegin, ..., mmid]
                return findK(m, mmid+1, mend, n, nbegin, nend, k - l1);
            }
        }
        //if(m[mmid] >= n[nmid]){
        else {
            if (l1 + l2 > k) {
                // no mB
                return findK(m, mbegin, mmid-1, n, nbegin, nend, k);
            } else {//l1+l2<=k
                // no nA
                return findK(m, mbegin, mend, n, nmid+1, nend, k - l2);
            }
        }

        //return -1;
	}
	
	public static void main(String[]args){
		int [] m = {0,1,2,4,6};
		int [] n = {1,3,5};
		/*System.out.println(nativeSelectK(m,n,1));
		System.out.println(nativeSelectK(m,n,2));
		System.out.println(nativeSelectK(m,n,3));
		System.out.println(nativeSelectK(m,n,4));
*/		
		SelectK sk = new SelectK();
		System.out.println(sk.findK(m, 0, m.length-1, n, 0, n.length-1, 5));
		
	}

}
