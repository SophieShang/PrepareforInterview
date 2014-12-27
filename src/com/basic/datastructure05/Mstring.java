package com.basic.datastructure05;

public class Mstring {
	public int PM(String T, String P){
		int i;          //模式串相对于主串的起始位置
		int j;          //模式串当前字符的地址
		for(i=0; i<=T.length()-P.length(); i++){
			for(j=0; j<P.length(); j++){  //若字符匹配则不断向后匹配模式串
				if(T.charAt(i+j) != P.charAt(j))  
					break;  //一旦有字符不匹配则该次对模式串的遍历
			}
			if(j >= P.length()){  //此时找到匹配的字符串跳出for i
				break;
			}
		}
		
		System.out.print("匹配的下标为：");
		System.out.println(i);
		return i;
	}
	
	public static void main(String[] args){
		String T = "Sophie is a good girl!";
		String P = "phie";
		Mstring ms = new Mstring();
		ms.PM(T, P);
		
	}

}
