package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    static class student implements Comparable<student> {
        String name;
        int rank;

        student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(student s2) {
            return this.rank - s2.rank;
        }
        // public int compareTo(student s2) {
        // return this.name.compareTo(s2.name);
        // }
    }

    public static void main(String[] args) {
        // in java heap is implemented using priority queue
        // Priority Queue is in java collection FrameWork
        // add(log n)
        // remove(log n)
        // peek(1)

        // if pq is int hten in 1,2,3,4,5. 1 will get higes priority means if peek you
        // get 1.

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(3);
        // pq.add(23);
        // pq.add(35);
        // pq.add(2);
        // while (!pq.isEmpty()) {
        // System.out.println(pq.remove());
        // }
        PriorityQueue<student> pq = new PriorityQueue<>();
        pq.add(new student("A", 6));
        pq.add(new student("B", 5));
        pq.add(new student("C", 8));
        pq.add(new student("D", 2));
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }

        // in arrays when representing heaps
        // par is i
        // left child is 2*i + 1
        // right child is 2*i + 2

        // if chiled is i
        // parent is (i-1)/2

    }
}
