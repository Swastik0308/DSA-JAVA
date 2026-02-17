/*
========================
MIN HEAP IMPLEMENTATION
========================

This code implements a Min Heap from scratch using an ArrayList.
A heap is a Complete Binary Tree (CBT) that satisfies the heap order property:

Min Heap rule:
parent <= children

Because it is a CBT, we store it in an array instead of using nodes.

--------------------------------
ARRAY INDEX RELATIONSHIPS
--------------------------------
For any index i:
left child  = 2*i + 1
right child = 2*i + 2
parent      = (i-1)/2

This mapping is the foundation of heap operations.

--------------------------------
CORE OPERATIONS
--------------------------------

1. add(data)  → O(log n)
------------------------
Steps:
- Insert element at the end (maintains CBT structure)
- “Bubble up” (up-heapify)
- Swap with parent until heap order is restored

This ensures the smallest element always moves toward the root.

2. peek() → O(1)
----------------
- Returns the minimum element (root)
- No structural changes

3. remove() → O(log n)
----------------------
Steps:
- Save root (answer to return)
- Swap root with last element
- Delete last element
- “Bubble down” (down-heapify)
- Restore heap property

heapify(i) compares node i with its children and pushes it downward
until heap order is satisfied.

4. isEmpty() → O(1)
-------------------
Checks whether heap has elements.

--------------------------------
HEAPIFY CONCEPT
--------------------------------
heapify() is the key repair function:
- Chooses the smallest among parent + children
- Swaps if parent violates heap rule
- Recursively fixes the subtree

This guarantees local violations don’t propagate.

--------------------------------
TIME COMPLEXITY SUMMARY
--------------------------------
add()      : O(log n)
remove()   : O(log n)
peek()     : O(1)
heapify()  : O(log n)
space      : O(n)

Printing all elements by repeated removal → O(n log n)

--------------------------------
IMPORTANT REVISION POINTS
--------------------------------
✔ Heap is NOT a sorted structure
✔ Only parent-child order is guaranteed
✔ Root always holds min element in min heap
✔ CBT structure enables array storage
✔ Up-heapify → after insertion
✔ Down-heapify → after deletion
✔ Heaps are used in Priority Queues & Heap Sort
✔ Build-heap can be done in O(n) (bottom-up heapify)

This implementation models the internal working of Java’s PriorityQueue.
*/

import java.util.ArrayList;

public class Heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last index
            arr.add(data);

            int x = arr.size() - 1; // child idx
            int par = (x - 1) / 2; // parent idx

            while (arr.get(x) < arr.get(par)) { // O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);
            // swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // delete last
            arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }

    }
}
