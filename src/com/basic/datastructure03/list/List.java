package com.basic.datastructure03.list;

import com.basic.datastructure06.tree.BinTreePosition;

public interface List {
	public void add(Object o);
	public Object get(int i);
	public void remove(int i);
	public int size();
	public boolean isEmpty();
	public void insert(int index, Object o);
}
