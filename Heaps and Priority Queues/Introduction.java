/*
This program demonstrates how Java's PriorityQueue works with both primitive
types and custom objects.

A PriorityQueue is a heap-based data structure where elements are removed
based on priority instead of insertion order.

---------------------------
PART 1: Integer PriorityQueue
---------------------------
- By default, Java PriorityQueue is a MIN-HEAP (smallest element first).
- Here we use Comparator.reverseOrder() to make it a MAX-HEAP.
- Elements are inserted in O(log n) time because heap restructuring is required.
- peek() returns the top element in O(1) time (no removal).
- remove() deletes the top element in O(log n) time.

So integers will be printed from largest to smallest.

---------------------------
PART 2: Custom Object PriorityQueue
---------------------------
We define a Student class that implements Comparable<Student>.

- compareTo() decides priority.
- this.rank - s2.rank means smaller rank = higher priority.
- So students are removed in ascending order of rank.

PriorityQueue uses compareTo() internally to maintain heap order.

---------------------------
TIME COMPLEXITY SUMMARY
---------------------------
Insertion (add)  : O(log n)
Removal (remove) : O(log n)
Peek (peek)      : O(1)
Building heap    : O(n) for n insertions (amortized)

Overall:
If n elements are inserted and removed,
Total complexity ≈ O(n log n)

---------------------------
KEY IDEA
---------------------------
PriorityQueue is ideal when you repeatedly need the highest/lowest priority
element efficiently. It is implemented using a binary heap internally.
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class Introduction {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());// by default pq priority will be
                                                                                   // ascending

        pq.add(3); // O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // O(1)
            pq.remove(); // O(logn)
        }

        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        pq2.add(new Student("a", 4));
        pq2.add(new Student("b", 10));
        pq2.add(new Student("c", 2));
        pq2.add(new Student("d", 8));
        pq2.add(new Student("e", 6));

        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().name + "->" + pq2.peek().rank);
            pq2.remove();
        }
    }
}
