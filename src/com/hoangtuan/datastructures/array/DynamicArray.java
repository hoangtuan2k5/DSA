package com.hoangtuan.datastructures.array;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private T[] array;
    private int capacity = 0;
    private int size = 0;


    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity must be greater than 0");
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T element) {
        array[index] = element;
    }

    public void clear() {
        for (int i = 0; i < size(); i++) {
            array[i] = null;
        }
        this.size = 0;
    }

    public void add(T element) {
        if (size >= capacity - 1) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;

            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size++] = element;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T[] newArray = (T[]) new Object[size - 1];

        for (int oldArrayIndex = 0, newArrayIndex = 0; oldArrayIndex < size; oldArrayIndex++, newArrayIndex++) {
            if (oldArrayIndex == index) newArrayIndex--;
            else newArray[newArrayIndex] = array[oldArrayIndex];
        }
        array = newArray;
        capacity = --size;
    }

    public T removeAtWithoutMoving(int removeIndex) {
        if (removeIndex >= size || removeIndex < 0) throw new IndexOutOfBoundsException();
        T item = array[removeIndex];
        array[removeIndex] = null;
        capacity = --size;
        return item;
    }

    public void remove(Object object) {
        int removeIndex = indexOf(object);
        removeAt(removeIndex);
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null) {
                if (array[i] == null) return i;
            } else {
                if (object.equals(array[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(array[i]);
                sb.append(", ");
            }
            sb.append(array[size - 1]);
            sb.append("]");
            return sb.toString();
        }
    }

}
