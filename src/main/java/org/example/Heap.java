package org.example;

/**
 * A simple min-heap data structure.
 */
public class Heap {
    private int[] data;
    private int size;

    /**
     * Initializes an empty heap with an initial capacity of 10.
     */
    public Heap() {
        data = new int[10];
        size = 0;
    }

    /**
     * Calculates the index of the parent node of a given index.
     *
     * @param index The index of the node for which to find the parent.
     * @return The index of the parent node.
     */
    public int getParentIndex(int index) {
//        return Math.floorDiv(index - 1, 2);
        return (index - 1) / 2;
    }

    /**
     * Calculates the index of the left child node of a given index.
     *
     * @param index The index of the node for which to find the left child.
     * @return The index of the left child node.
     */
    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * Calculates the index of the right child node of a given index.
     *
     * @param index The index of the node for which to find the right child.
     * @return The index of the right child node.
     */
    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    /**
     * Swaps the values of two elements in the heap.
     *
     * @param index1 The index of the first element.
     * @param index2 The index of the second element.
     */
    public void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * Restores the heap property by moving an element up the heap.
     *
     * @param index The index of the element to heapify up.
     */
    public void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);
        while (index > 0 && data[parentIndex] > data[index]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    /**
     * Adds an item to the heap and ensures that the heap property is maintained.
     *
     * @param item The item to add to the heap.
     */
    public void add(int item) {
        data[size] = item;
        size++;
        heapifyUp(size - 1);
    }

    /**
     * Prints the elements in the heap.
     */
    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    /**
     * Restores the heap property by moving an element down the heap.
     *
     * @param index The index of the element to heapify down.
     */
    public void heapifyDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int smallestChildIndex = leftChildIndex;
        if (rightChildIndex < size - 1 && data[rightChildIndex] < data[leftChildIndex]) {
            smallestChildIndex = rightChildIndex;
        }
        while (index < size && data[index] > data[smallestChildIndex]) {
            swap(index, smallestChildIndex);
            index = smallestChildIndex;
        }
    }

    /**
     * Gets the minimum value (root) of the heap.
     *
     * @return The minimum value in the heap.
     */
    public int getMin() {
        int min = data[0];
        return min;
    }
}
