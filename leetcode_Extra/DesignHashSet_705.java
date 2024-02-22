package leetcode_Extra;

/*
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:
void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)

Constraints:
0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.
 */
class DesignHashSet_705 {
    private boolean[] set;

    /**
     * Initialize your data structure here.
     */
    public DesignHashSet_705() {
        // Initialize the boolean array with a size of 1000001 (as per the problem constraint)
        set = new boolean[1000001];
    }

    /**
     * Add a key to the HashSet.
     * Time Complexity: O(1)
     */
    public void add(int key) {
        set[key] = true;
    }

    /**
     * Remove a key from the HashSet.
     * Time Complexity: O(1)
     */
    public void remove(int key) {
        set[key] = false;
    }

    /**
     * Returns true if this set contains the specified element.
     * Time Complexity: O(1)
     */
    public boolean contains(int key) {
        return set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */