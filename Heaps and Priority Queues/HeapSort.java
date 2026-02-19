/*
 * HEAP SORT (Using Max Heap)
 * Realted Question: https://www.geeksforgeeks.org/problems/heap-sort/1
 *
 * Idea:
 * 1) Convert array into Max Heap (largest element at root).
 * 2) Swap root with last element.
 * 3) Reduce heap size and heapify again.
 * 4) Repeat until array is sorted.
 *
 * Time Complexity:
 * - Build Heap: O(n)
 * - Heapify (each time): O(log n)
 * - Overall Heap Sort: O(n log n)  (Best, Avg, Worst all same)
 *
 * Space Complexity:
 * - O(1) (In-place sorting algorithm)
 *
 * Important Interview Points:
 * - Heap Sort is NOT stable.
 * - It does NOT require extra space like Merge Sort.
 * - Guaranteed O(n log n) unlike QuickSort (which can degrade to O(n²)).
 * - Build heap starts from last non-leaf node: (n/2 - 1).
 * - Left child = 2*i + 1, Right child = 2*i + 2.
 * - Used when constant space is required with guaranteed n log n.
 *
 * Common Mistakes:
 * - Starting heap build loop incorrectly (should start from n/2 - 1).
 * - Forgetting to reduce heap size after swap.
 * - Confusing Min Heap vs Max Heap depending on required order.
 *
 * When to Use:
 * - When memory is constrained.
 * - When worst-case guarantee is important.
 */

public class HeapSort {

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx])
            maxIdx = left;
        if (right < size && arr[right] > arr[maxIdx])
            maxIdx = right;

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }

    }

    public static void heapSort(int arr[]) {
        // build maxHeap for ascending order
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 3 };

        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
