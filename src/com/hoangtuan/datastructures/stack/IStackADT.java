package com.hoangtuan.datastructures.stack;

public interface IStackADT<T> extends Iterable<T> {

   void push(T element); // O(1)
   T pop(); // O(1)
   T top(); // O(1)
   int size(); // O(1)
   boolean isEmpty(); // O(1)

}
