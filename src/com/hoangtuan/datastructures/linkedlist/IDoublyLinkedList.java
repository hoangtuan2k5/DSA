package com.hoangtuan.datastructures.linkedlist;

public interface IDoublyLinkedList<T> extends Iterable<T> {
	
    //O(n)
    void clear();

    //constant
    int size();

    //constant
    boolean isEmpty();

    //O(n)
    public Node<T> getNode(int index);

    //O(n)
    void insert(T element, int index);

    //O(1)
    void addFirst(T element);

    //O(1)
    void addLast(T element);

    //O(1)
    T peekFirst();

    //O(1)
    T peekLast();

    //O(1)
    T removeFirst();

    //O(1)
    T removeLast();

    //O(1)
    T remove(Node<T> node);

    //O(n)
    boolean remove(Object object);

    //O(n)
    T removeAt(int index);

    //O(n)
    int indexOf(Object object);

    //O(n)
    boolean contains(Object object);

}
