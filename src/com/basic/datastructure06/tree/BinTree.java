package com.basic.datastructure06.tree;

public interface BinTree {
	public BinTreePosition getRoot();
	public boolean isEmpty();
	public int getSize();
	public int getHeight();
	public Iterator elementsPreorder();
	public Iterator elementsInorder();
	public Iterator elementsPostorder();
	public Iterator elementsLevelInorder();
	

}
