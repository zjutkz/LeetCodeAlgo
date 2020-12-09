package com.zjutkz.leetcode.android.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/46680658
 * Created by kangzhe on 20/2/3.
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        List<Integer> result = new ArrayList<>();
        MinHeap<Integer> heap = new MinHeap<>(arr.length);
        List<Integer> list = new ArrayList<>();
        for(int value : arr) {
            list.add(value);
        }
        heap = heap.of(list);
        for(int i = 0; i < arr.length; i++) {
            result.add(heap.pop());
        }
        System.out.println(result);
    }

    public static class MinHeap<E extends Comparable<E>> {

        private List<E> array;

        public MinHeap(int capacity) {
            array = new ArrayList<>(capacity);
        }

        public MinHeap<E> of(Iterable<E> src) {
            for(E value : src) {
                add(value);
            }
            return this;
        }

        public void add(E e) {
            array.add(e);
            bubbleUp();
        }

        public void remove(int index) {
            array.remove(index);

            MinHeap<E> newHeap = of(array);
            array = newHeap.array;
        }

        public E pop() {
            E value = array.get(0);

            Collections.swap(array, 0, array.size() - 1);
            array.remove(array.size() - 1);
            bubbleDown();

            return value;
        }

        public int parentIndex(int index) {
            return (index  - 1) / 2;
        }

        public int leftChildIndex(int index) {
            return index * 2 + 1;
        }

        public int rightChildIndex(int index) {
            return index * 2 + 2;
        }

        public E parent(int index) {
            return array.get((index  - 1) / 2);
        }

        public E getLeftChild(int index) {
            return array.get(index / 2 + 1);
        }

        public E getRightChild(int index) {
            return array.get(index / 2 + 2);
        }

        private void bubbleUp() {
            int index = array.size() - 1;
            while (index > 0 && array.get(index).compareTo(array.get(parentIndex(index))) < 0) {
                swap(index, parentIndex(index));
                index = parentIndex(index);
            }
        }

        private void bubbleDown() {
            int index = 0;
            while (leftChildIndex(index) < array.size()) {
                int j = leftChildIndex(index);
                if( j + 1 < array.size() && array.get(j + 1).compareTo(array.get(j)) < 0 ) {
                    j ++;
                }
                if(array.get(index).compareTo(array.get(j)) < 0 ) {
                    break;
                }
                Collections.swap(array, index, j);
                index = j;
            }
        }

        private void swap(int i, int j) {
            Collections.swap(array, i , j);
        }
    }

}
