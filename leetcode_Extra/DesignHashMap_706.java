package leetcode_Extra;

import java.util.Arrays;

class DesignHashMap_706 {
    private static final int SIZE = 1000001;
    private int[] keys;
    private int[] values;

    /**
     * Initialize your data structure here.
     */
    public DesignHashMap_706() {
        keys = new int[SIZE];
        values = new int[SIZE];
        // Initialize all values to -1, assuming -1 is not a valid value in this HashMap
        Arrays.fill(values, -1);

        // Initialize all keys to a negative value
        Arrays.fill(keys, Integer.MIN_VALUE);
    }

    /**
     * Put a key-value pair in the HashMap.
     * Time Complexity: O(1)
     */
    public void put(int key, int value) {
        keys[key] = key; // Store the key at its hash location
        values[key] = value; // Store the value at the same location
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
     * Time Complexity: O(1)
     */
    public int get(int key) {
        return values[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key.
     * Time Complexity: O(1)
     */
    public void remove(int key) {
        values[key] = -1; // Remove the mapping by setting the value to -1
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * Time Complexity: O(1)
     */
    public boolean contains(int key) {
        return values[key] != -1;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * Time Complexity: O(1)
     */
    public boolean containss(int key) {
        return keys[key] != Integer.MIN_VALUE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */