package com.basic.datastructure05.leetcode;

public class ReverseString {
	static void Reverse(String s){
		char[] ch01 = new char[s.length()];
		System.out.println(s);
		for(int i=s.length()-1; i>=0; i--){
			char c = s.charAt(i);
			ch01[s.length()-1 -i] = c;
			}
		System.out.println(new String(ch01));
		System.out.println(ch01.toString());   //输出的是： [C@c5c3ac hashcode
		/*for(char c:ch01){
			System.out.print(c+ " ");
		}*/
	}
	
	static void Reverse02(char[] ch){
		int begin = 0;
		int end = ch.length-1;
		while(begin < end){
			char temp = ch[begin];
			ch[begin] = ch[end];
			ch[end] = temp;
			begin ++;
			end --;
		}
		for(char c:ch){
			System.out.print(c + " ");
		}
		
	}
	
	public String reverseWords(String s){
		//把一个字符串中单词反向输出，如"the sky is blue"，输出为："blue is sky the"
		//允许多个空白字符及首尾空白字符的话
		StringBuilder reversed = new StringBuilder(); //存储反转单词后的字符串
		int j = s.length();
		for(int i=s.length()-1; i>=0; i--){
			if(s.charAt(i) == ' '){
				j = i; //j始终指向将要加入单词的结尾处空白符
			}else if(i == 0 || s.charAt(i-1) == ' '){
				if(reversed.length() != 0){
					reversed.append(' ');
				}
				reversed.append(s.substring(i,j)); //取下标i到下标j-1的子串
			}
		}
		return reversed.toString();
	}
	
	public void reverseWords02(char[] s){
		//先把整体字符数组反转，然后再对每一个word进行反转
		reverse(s,0,s.length);
		for(int i=0, j=0; j<=s.length;j++){
			if(j == s.length || s[j] == ' '){
				reverse(s, i, j);
				i = j+1;
			}
		}
	}
	
	
	private void reverse(char[] s, int begin, int end) {
		for(int i =0; i<(begin+end)/2; i++){
			char temp = s[begin+i];
			s[begin+i] = s[end-i-1];
			s[end-i-1] = temp;
		}
	}

	//The input string does not contain leading or trailing spaces and the words are always separated by a single space.
	//Could you do it in-place without allocating extra space?
	
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
		System.out.println();
		char[] ch = {'H','E','L','L','O'};
		ReverseString rs02 = new ReverseString();
		rs02.Reverse02(ch);
		System.out.println();
	
		String s2 = "the sky is blue";
		System.out.println(s2);
		System.out.print(rs.reverseWords(s2));
		
		
	}

}
