package com.basic.datastructure05.leetcode;

public class Rect extends Shape{
	private double length;
	private double width;
	
	public Rect(double length, double width){
		this.length = length;
		this.width = width;
	}
	
	public void setLength(double leng){
		this.length = leng;
	}
	
	public double getLength(){
		return length;
	}
	
	public void setWidth(double wid){
		this.width = wid;
	}
	
	public double getWidth(){
		return width;
	}

	@Override
	public double getAcreage() {
		return length * width;
	}

	@Override
	public double getPerimeter() {
		return 2*(length+width);
	}
	
	public static void main(String[] args){
		Shape re = new Rect(9,5);   //父类指针指向子类对象，向下转型，多态的体现
		System.out.println("矩形的面积是：" + re.getAcreage());
		System.out.println("矩形的周长是：" + re.getPerimeter());
		
	}

}
