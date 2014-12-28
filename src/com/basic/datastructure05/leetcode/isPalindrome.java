package com.basic.datastructure05.leetcode;

public class isPalindrome {
	public boolean inPali(String s){
		int i=0, j=s.length()-1;
		while(i<j){
			while(i<j && !Character.isLetterOrDigit(s.charAt(i))){i++;}//即如果不是字符或数字就直接跳过，不作对比
			while(i<j && !Character.isLetterOrDigit(s.charAt(j))){j--;}
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			i++; j--;
		}
		return true;
	}
	
	public static void main(String[] args){
		String s1 = "saab";
		String s2 = "saas";
		isPalindrome is = new isPalindrome();
		System.out.println(is.inPali(s1));
		System.out.println(is.inPali(s2));
	}
}
