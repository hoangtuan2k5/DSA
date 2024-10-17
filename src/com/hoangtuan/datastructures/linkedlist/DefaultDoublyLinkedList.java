package com.hoangtuan.datastructures.linkedlist;

import java.util.Iterator;

public class DefaultDoublyLinkedList<T> implements IDoublyLinkedList<T> {

    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.getNext();
            currentNode.setData(null);
            currentNode.setNext(null);
            currentNode.setPrev(null);
            currentNode = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Index out of bounds");
        if (index == 0) return head;
        if (index == size - 1) return tail;

        int currentIndex;
        Node<T> currentNode;
        if (index < size / 2) {
            currentIndex = 0;
            currentNode = head;
            while (currentIndex != index) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
        } else {
            currentIndex = size - 1;
            currentNode = tail;
            while (currentIndex != index) {
                currentNode = currentNode.getPrev();
                currentIndex--;
            }
        }
        return currentNode;
    }

    @Override
    public void insert(T element, int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Index out of bounds");
        if (index == 0) addFirst(element);
        else if (index == size - 1) addLast(element);
        else {
            Node<T> nodeToInsert = getNode(index);
            Node<T> newNode = new Node<>(element, nodeToInsert.getPrev(), nodeToInsert);
            nodeToInsert.getPrev().setNext(newNode);
            nodeToInsert.setPrev(newNode);
        }
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            Node<T> newNode = new Node<>(element, null, head);
            head.setPrev(newNode);
            head = head.getPrev();
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        }
        else {
            Node<T> newNode = new Node<>(element, tail, null);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.getData();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return tail.getData();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        else head.setPrev(null);

        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("List is empty!");
        T data = tail.getData();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head = null;
        else tail.setNext(null);

        return data;
    }

    @Override
    public T remove(Node<T> node) {
        if (isEmpty()) throw new RuntimeException("List is empty");
        if (node.getPrev() == null) return removeFirst();
        if (node.getNext() == null) return removeLast();

        T data = node.getData();
        node.setData(null);
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node.setNext(null);
        node.setPrev(null);
        node = null;

        size--;
        if (isEmpty()) head = tail = null;

        return data;
    }

    @Override
    public boolean remove(Object object) {
        if (isEmpty()) throw new RuntimeException("List is empty");
        Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                remove(currentNode);
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public T removeAt(int index) {
        if (isEmpty()) throw new RuntimeException("List is empty");
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Index is out of range");

        int currentIndex;
        Node<T> currentNode;

        if (index < size / 2) {
            currentNode = head;
            currentIndex = 0;
            while (currentIndex != index) {
                currentIndex = currentIndex + 1;
                currentNode = currentNode.getNext();
            }
        } else {
            currentNode = tail;
            currentIndex = size - 1;
            while (currentIndex != index) {
                currentIndex = currentIndex - 1;
                currentNode = currentNode.getPrev();
            }
        }

        return remove(currentNode);
    }

    @Override
    public int indexOf(Object object) {
        if (isEmpty()) throw new RuntimeException("List is empty");

        int index = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(object)) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.getData();
                currentNode = currentNode.getNext();
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "My list is empty!";
        else {
            Node<T> currentNode = head;
            StringBuilder sb = new StringBuilder();
            while (currentNode != null) {
                sb.append("(").append(currentNode.getData()).append(")");
                if (currentNode.getNext() != null) sb.append(" <--> ");
                currentNode = currentNode.getNext();
            }
            return sb.toString();
        }
    }

}
