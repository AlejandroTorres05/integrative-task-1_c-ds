package ui;

import dataStructures.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer,String> priorityQueue = new PriorityQueue<>(20);
        Pair<Integer,String>[] array = new Pair[20];
        char character = 'a';
        for (Integer i = 0; i<array.length; i++){
            array[i] = new Pair<>(i,character+"");
            character++;
        }
        priorityQueue.setArray(array);
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        Pair<Integer,String> [] pairs = priorityQueue.heapSort();
        Integer[] numbers = new Integer[pairs.length];
        for (int i = 0; i<numbers.length; i++){
            numbers[i] = pairs[i].getKey();
        }
        System.out.println(Arrays.toString(numbers));
    }
}