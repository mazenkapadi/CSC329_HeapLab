package org.example;

public class Heap {
    private int[] data;

    private int size;

    public Heap() {
        data = new int[10];
        size = 0;
    }

    public int getParentIndex(int index) {
        //return (index - 1) / 2; Why would this not work? If we only have ints wouldn't it automatically round down?
        return Math.floorDiv(index - 1, 2);
    }

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);
        while ((index > 0) && (data[parentIndex] > data[index])) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }


    public void add(int item) {
        data[size] = item;
        size++;
        heapifyUp(size - 1);
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    //All that I did in class
    //what I was trying to do at work

    public void heapifyDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int smallestChildIndex = leftChildIndex;
        if (rightChildIndex < size-1 && data[rightChildIndex] < data[leftChildIndex]) {
            smallestChildIndex = rightChildIndex;
        }
        while (data[index] > data[smallestChildIndex]) {
            swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }

    public int getMin() {
        int min = data[0];
        return min;
    }

}