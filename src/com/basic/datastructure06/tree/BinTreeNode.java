package com.basic.datastructure06.tree;

import com.basic.datastructure03.List;

public class BinTreeNode implements BinTreePosition {
	protected Object element;
	protected BinTreePosition parent;
	protected BinTreePosition lchild;
	protected BinTreePosition rchild;
	protected int size;
	protected int height;
	protected int depth;

	@Override
	public Object getElem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object setElem(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasParent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BinTreePosition getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(BinTreePosition p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasLChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BinTreePosition getLChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLChild(BinTreePosition c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BinTreePosition getRChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRChild(BinTreePosition c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateHeight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateDepth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BinTreePosition getPrev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinTreePosition getSucc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinTreePosition secede() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinTreePosition attachL(BinTreePosition c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinTreePosition attachR(BinTreePosition c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator elementsPreorder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator elementsInorder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator elementsPostorder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator elementsLevelorder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected static void preorder(List list, BinTreePosition v){
		if(v == null)
			return;
		list.insert(0,v);
		preorder(list, v.getLChild());
		preorder(list, v.getRChild());
	}
	
	protected static void inorder(List list, BinTreePosition v){
		if(v == null)
			return;
		inorder(list, v.getLChild());
		list.insert(0,v);
		inorder(list, v.getRChild());
	}
	
	protected static void postorder(List list, BinTreePosition v){
		if( v == null)
			return;
		postorder(list, v.getLChild());
		postorder(list, v.getRChild());
		list.insert(0, v);
	}

}
