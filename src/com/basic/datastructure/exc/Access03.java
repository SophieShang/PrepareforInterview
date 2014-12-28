package com.basic.datastructure.exc;

import com.basic.datastructure.exc.Access02.pri1;

public class Access03 {
	public static void main(String[] args){
		 Access03 a = new Access03();
		 pri1 p1 = a.new pri1(); 
	}
   class pri1{
	    private int x;
	    void setX(int y){
	        x=y;
	    }
	    int getX(){
	        return x;
	        }
		}
}