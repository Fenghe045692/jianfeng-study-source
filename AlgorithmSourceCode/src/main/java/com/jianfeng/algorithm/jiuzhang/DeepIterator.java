package com.jianfeng.algorithm.jiuzhang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DeepIterator<T> implements Iterator<T>{
	private final Stack<Iterator<?>> iterator_stack = new Stack<Iterator<?>>();
	private T one_item_bucket = null;
	
	public DeepIterator(Collection<?> collection){
		this.iterator_stack.push(collection.iterator());
	}

	@SuppressWarnings("unchecked")
	public boolean hasNext(){
		if(one_item_bucket != null)
			return true;
		while(!this.iterator_stack.isEmpty()){
			Iterator<?> tmp_iterator = this.iterator_stack.peek();
			if(tmp_iterator.hasNext()){
				Object tmp_item = tmp_iterator.next();
				if(tmp_item instanceof Integer){
					this.one_item_bucket = (T)tmp_item;
					return true;
				}else if(tmp_item instanceof Collection<?>){
					this.iterator_stack.push(((Collection<?>)tmp_item).iterator());
					continue;
				}else{
					throw new RuntimeException("UnSupported Element!");
				}
			}else{
				this.iterator_stack.pop();
			}
		}
		return false;
	}
	
	public T next(){
		if(hasNext()){
			T tmp = this.one_item_bucket;
			this.one_item_bucket = null;
			return tmp;
		}else{
			throw new NoSuchElementException();
		}
	}
	
	public void remove(){
		throw new UnsupportedOperationException("not supported operation");
	}
	
	public static void main(String[] args){
		List list1 = new ArrayList();
		list1.add(1);
		list1.add(new ArrayList());
		list1.add(3);
		list1.add(4);
		List list2 = new ArrayList();
		list2.add(5);
		list2.add(list1);
		list2.add(5);
		DeepIterator<Integer> deepIterator = new DeepIterator<Integer>(list2);
		while(deepIterator.hasNext()){
			int tmp = deepIterator.next();
			System.out.print(tmp + " ");
		}
	}
}
