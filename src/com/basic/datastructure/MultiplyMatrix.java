package com.basic.datastructure;

public class MultiplyMatrix {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int i,j,k;
		int[][] a = new int[2][3];
		int b[][] = {{1,5,2,8},{5,9,10,-3},{2,7,-5,-18}};
		int [][] c = new int[2][4];
		for(i=0; i<2;i++){
			for(j=0;j<3;j++){
				a[i][j] = (i+1)*(j+1);
			}
		}
		for (i=0;i<2;i++)
			for(j=0;j<4;j++){
				c[i][j]=0;
				for (k=0;k<3;k++)
					c[i][j] = a[i][k]*b[k][j];
			}
		System.out.print("Matrix C:\n");
		for(i=0;i<2;i++){
			for(j=0;j<4;j++){
				System.out.print(c[i][j]);
			}
			System.out.print("\n");
		}
	}

}
