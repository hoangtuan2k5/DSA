package com.hoangtuan.datastructures.stack;
import com.hoangtuan.datastructures.array.DynamicArray;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayBasedStack<T> implements IStackADT<T> {

	int index = -1;	
	private final DynamicArray<T> array;

	public ArrayBasedStack(int initSize) {
		array = new DynamicArray<>(initSize);
	}

	@Override
	public void push(T element) {
		index++;
		array.add(element);
	}
	
	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
        }
		return array.removeAtWithoutMoving(index--);
	}

	@Override
	public T top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return array.get(index);
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return array.iterator();
	}

}
