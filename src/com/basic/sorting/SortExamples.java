package com.basic.sorting;

public class SortExamples{
	public void InsertArray(Integer[] in){
		int temp=0, num=0,upnum=0;
		for(int i=0;i<in.length;i++){ //i 是为了标示在i之前的已经是排好序的
			for(int j=i-1;j>=0;j--){
				num++;  //循环次数
				if(in[j+1]<in[j]){
					temp = in[j+1];
					in[j+1] = in[j];
					in[j] = temp;
					upnum++;   //交换次数
					
				}else{
					break;
				}
			}
		}
		for(int i=0;i<in.length;i++){
			System.out.print(in[i]);
			if(i<in.length-1)
				System.out.print(",");
		}
		System.out.println();
		System.out.println("循环次数"+num);
		System.out.println("交换次数"+upnum);
	}
	
	public void SelectArray(Integer[] in){
		int temp=0, num=0, upnum=0;
		for (int i=0;i<in.length;i++){
			for(int j=i;j<in.length-1;j++){
				num++;
				if(in[j+1]<in[i]){
					temp = in[j+1];
					in[j+1] = in[i];
					in[i] = temp;
					upnum++;   //交换次数
				}
			}
		}
		for(int i=0;i<in.length;i++){
			System.out.print(in[i]);
			if(i<in.length-1)
				System.out.print(",");
		}
		System.out.println();
		System.out.println("循环次数"+num);
		System.out.println("交换次数"+upnum);
	}
	
	public void BubbleSort(Integer[] in){
		int temp,num=0,upnum=0;
		for(int i=in.length-1;i>=0;i--){
			for(int j=i;j>=0;j--){
				num++;
				if(in[j]>in[i]){
					temp = in[i];
					in[i] = in[j];
					in[j] = temp;
					//如果不允许用temp变量的话，可以这样操作
					//in[i]= in[i]+in[j];
					//in[j]= in[i]-in[j];
					//in[i]= in[i]-in[j];
					upnum++;
				}
			}
		}
		for(int i=0;i<in.length;i++){
			System.out.print(in[i]);
			if(i<in.length-1)
				System.out.print(",");
		}
		System.out.println();
		System.out.println("循环次数"+num);
		System.out.println("交换次数"+upnum);
	}
	
	public void PrintMulti(){
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j + "*" + i + "=" + i*j + "\t");
			}
			System.out.println();
		}
	}
	
	public void PrintNumAssemble(int num){
		for(int i=0;i<num+1;i++)
			for(int j=0;j<num/2+1;j++)
				for(int k=0;k<num/3+1;k++){
					if(i*1+j*2+k*3 == num){
						System.out.println("小马"+i+",\t 中马"+j+",\t 大马"+k);
					}
				}
	}
	
	public static void main(String args[]){
		SortExamples se = new SortExamples();
		se.PrintMulti();
		se.PrintNumAssemble(100);
		Integer in[] = {8,89,5,84,3,45,12,33,77,97,456,878,654,213,897};
		//se.BubbleSort(in);
		Integer in1[] = {4,3,58,7,77,32,96};
		Integer in2[] = {19,78,25,48,2,8,79};
		//se.InsertArray(in);
		se.SelectArray(in1);
		se.BubbleSort(in);
	}
}
