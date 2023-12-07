package day64_Advanced_Heaps_1;

// MinHeap class represents a binary min heap data structure
public class MinHeapImplementation {
    private int[] heap;       // Array to store heap elements
    private int size;         // Current size of the heap
    private int capacity;     // Maximum capacity of the heap

    // Constructor to initialize the MinHeap with a given capacity
    public MinHeapImplementation(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Method to insert a new element into the heap
    // TC - Insert Method (insert): O(log N)
    public void insert(int value) {
        // Check if the heap is full
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }

        // Insert the new element at the end of the heap
        heap[size] = value;

        // Restore the min heap property by fixing the heap
        heapifyUp(size);

        // Increment the size of the heap after the heapify process
        size++;
    }

    // Method to fix the heap property by moving an element up the heap
    private void heapifyUp(int index) {
        int parent = ((index - 1) / 2);
        while (index > 0 && heap[parent] > heap[index]) {
            // Swap the current element with its parent
            swap(index, parent);

            // Move up to the parent index
            index = parent;
        }
    }

    // Method to remove and return the minimum element from the heap
    // TC - Poll Method (poll): O(log N)
    public int poll() {
        // Check if the heap is empty
        if (size == 0) {
            throw new IllegalStateException("Heap is empty. Cannot poll.");
        }

        // The minimum element is at the root of the heap
        int minElement = heap[0];

        // Replace the root with the last element in the heap
        heap[0] = heap[size - 1];
        size--;

        // Restore the min heap property by fixing the heap (heapify down)
        heapifyDown(0);

        // Return the removed minimum element
        return minElement;
    }

    // Method to fix the heap property by moving an element down the heap
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1; // Calculate the index of the left child
        int rightChild = 2 * index + 2; // Calculate the index of the right child
        int smallest = index; // Assume the current index is the smallest

        // Check if the left child exists and is smaller than the current smallest
        if (leftChild < size && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }

        // Check if the right child exists and is smaller than the current smallest
        if (rightChild < size && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        // If the smallest child is different from the current index, swap and continue heapifying down
        if (smallest != index) {
            swap(index, smallest); // Swap the current element with the smallest child
            heapifyDown(smallest); // Recursively heapify down at the smallest child's index
        }
    }

    // Method to return the minimum element without removing it
    // TC - Peek Method (peek): O(1)
    public int peek() {
        // Check if the heap is empty
        if (size == 0) {
            throw new IllegalStateException("Heap is empty. Cannot peek.");
        }

        // The minimum element is at the root of the heap
        return heap[0];
    }

    // Method to swap elements at two given indices in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
