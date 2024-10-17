package com.hoangtuan.datastructures.stack;

public class StackTest {
    public static void main(String[] args) {
        int numberOfOperations = 100000;

        // Array based stack
        IStackADT<Integer> arrayBasedStack = new ArrayBasedStack<>(10);

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            arrayBasedStack.push(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            arrayBasedStack.pop();
        }
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        long durationInMs = durationInNs / 1_000_000;
        System.out.println("Array based stack took: " + durationInNs + " ns (" + durationInMs + " ms)\n");


        // Linked list based stack
        IStackADT<Integer> linkedListBasedStack = new LinkedListBasedStack<>();

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedStack.push(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedStack.pop();
        }
        endTime = System.nanoTime();
        durationInNs = endTime - startTime;
        durationInMs = durationInNs / 1_000_000;
        System.out.println("Linked list based stack took: " + durationInNs + " ns (" + durationInMs + " ms)\n");
    }
}
