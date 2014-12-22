package com.basic.datastructure05;

public class ReverseString {
	static void Reverse(String s){
		char[] ch01 = new char[s.length()];
		System.out.println(s);
		for(int i=s.length()-1; i>=0; i--){
			char c = s.charAt(i);
			ch01[s.length()-1 -i] = c;
			}
		//System.out.println(ch01.toString());
		for(char c:ch01){
			System.out.print(c+ " ");
		}
	}
	
	public static void main(String[] args){
		String s = "Hello World!";
		/*char[] ch01 = new char[s.length()];
		System.out.println(s);
		for(int i=s.length()-1; i>=0; i--){
			char c = s.charAt(i);
			ch01[s.length()-1 -i] = c;
			}
		
		for(char c:ch01){
			System.out.print(c+ " ");
		}*/
		ReverseString rs = new ReverseString();
		rs.Reverse(s);
		
	}

}
