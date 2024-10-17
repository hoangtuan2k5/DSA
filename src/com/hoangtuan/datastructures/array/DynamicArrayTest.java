package com.hoangtuan.datastructures.array;

public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        // Đo thời gian thêm phần tử
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            dynamicArray.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Thời gian thêm 100000 phần tử: " + duration + " ns (" + (duration / 1_000_000) + " ms)");

        // Đo thời gian lấy phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            dynamicArray.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Thời gian lấy 100000 phần tử: " + duration + " ns (" + (duration / 1_000_000) + " ms)");

        // Đo thời gian xóa phần tử
        startTime = System.nanoTime();
        for (int i = 99999; i >= 0; i--) {
            dynamicArray.removeAt(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Thời gian xóa 100000 phần tử: " + duration + " ns (" + (duration / 1_000_000) + " ms)");

        // Thử nghiệm với phương thức set
        dynamicArray.add(123); // Thêm phần tử để có thể sử dụng set
        startTime = System.nanoTime();
        dynamicArray.set(0, 999);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Thời gian set một phần tử: " + duration + " ns (" + (duration / 1_000_000) + " ms)");

        // Hiển thị array sau khi set
        System.out.println("Mảng sau khi set: " + dynamicArray.toString());

        // Thử nghiệm với phương thức contains
        startTime = System.nanoTime();
        boolean contains = dynamicArray.contains(999);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Thời gian kiểm tra contains: " + duration + " ns (" + (duration / 1_000_000) + " ms)");
        System.out.println("Mảng có chứa 999 không? " + contains);
    }
}
