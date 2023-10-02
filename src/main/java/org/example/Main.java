package org.example;

/**
 * The main class for demonstrating the Heap data structure.
 */
public class Main {
    public static void main(String[] args) {
        // Create a new instance of the Heap class
        Heap h = new Heap();

        // Add elements to the heap
        h.add(20);
        h.add(40);
        h.add(30);
        h.add(50);

        // Display the contents of the heap
        h.show();

        // Get and print the minimum value in the heap
        System.out.println("Minimum value in the heap: " + h.getMin());
    }
}
