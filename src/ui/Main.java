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
        Pair<Integer,String> [] array2 = priorityQueue.getArray();
        Integer[] num = new Integer[array2.length];
        for (int i = 0; i<num.length; i++){
            num[i] = array2[i].getKey();
        }
        System.out.println(Arrays.toString(num));
    }
}