package com.hoangtuan.datastructures.linkedlist;

public class DefaultDoublyLinkedListTest {
    public static void main(String[] args) {
        // Tạo một danh sách liên kết đôi
        DefaultDoublyLinkedList<Integer> list = new DefaultDoublyLinkedList<>();

        // Thử nghiệm với việc thêm 1,000,000 phần tử
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list.addLast(i);
        }
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000; // Chuyển đổi nanoseconds sang milliseconds
        long durationNs = endTime - startTime; // Nanoseconds
        System.out.printf("Thời gian thêm 1,000,000 phần tử: %d ns (%d ms)%n", durationNs, durationMs);

        // Thử nghiệm với việc lấy phần tử
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list.peekFirst(); // Lấy phần tử đầu tiên
        }
        endTime = System.nanoTime();
        durationMs = (endTime - startTime) / 1_000_000;
        durationNs = endTime - startTime;
        System.out.printf("Thời gian lấy 1,000,000 phần tử đầu tiên: %d ns (%d ms)%n", durationNs, durationMs);

        // Thử nghiệm với việc xóa 500,000 phần tử đầu tiên
        startTime = System.nanoTime();
        for (int i = 0; i < 500000; i++) {
            list.removeFirst(); // Xóa phần tử đầu tiên
        }
        endTime = System.nanoTime();
        durationMs = (endTime - startTime) / 1_000_000;
        durationNs = endTime - startTime;
        System.out.printf("Thời gian xóa 500,000 phần tử đầu tiên: %d ns (%d ms)%n", durationNs, durationMs);

        // Thử nghiệm với việc thêm lại một số phần tử
        for (int i = 0; i < 500000; i++) {
            list.addLast(i + 500000); // Thêm lại các phần tử mới
        }

        // Thử nghiệm với phương thức contains
        startTime = System.nanoTime();
        boolean contains = list.contains(999999);
        endTime = System.nanoTime();
        durationMs = (endTime - startTime) / 1_000_000;
        durationNs = endTime - startTime;
        System.out.printf("Thời gian kiểm tra contains cho 999999: %d ns (%d ms)%n", durationNs, durationMs);
        System.out.println("Danh sách có chứa 999999 không? " + contains); // Kỳ vọng: true

        // Thử nghiệm với phương thức indexOf
        startTime = System.nanoTime();
        int index = list.indexOf(999999);
        endTime = System.nanoTime();
        durationMs = (endTime - startTime) / 1_000_000;
        durationNs = endTime - startTime;
        System.out.printf("Thời gian tìm chỉ số của 999999: %d ns (%d ms)%n", durationNs, durationMs);
        System.out.println("Chỉ số của 999999 là: " + index); // Kỳ vọng: 999999

        // Thử nghiệm với phương thức clear
        startTime = System.nanoTime();
        list.clear();
        endTime = System.nanoTime();
        durationMs = (endTime - startTime) / 1_000_000;
        durationNs = endTime - startTime;
        System.out.printf("Thời gian xóa toàn bộ danh sách: %d ns (%d ms)%n", durationNs, durationMs);
        System.out.println("Danh sách sau khi xóa toàn bộ: " + list); // Kỳ vọng: My list is empty!
    }
}
