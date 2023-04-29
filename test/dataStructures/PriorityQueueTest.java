package dataStructures;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains the test of the heap
 * and the test of the priority Queue
 * because the priority queue is instanced
 * from the heap structure
 * */
public class PriorityQueueTest {

    public static PriorityQueue<Integer,String> priorityQueue;

    /**
     * This stage constructs a MAxPriorityQueue of
     * Integer key and String data with twenty
     * slots to save elements
     * */
    public void setupStage1 (){
        priorityQueue = new PriorityQueue<>(20);
    }

    /**
     * We think that for test the maxHeapIfy
     * and build test it's just necessary a
     * test method. Because those functionalities
     * are very related between themselves.
     * So for test those functionalities the heap
     * structure has the method setArray
     * */

    @Test
    public void setArrayMethodUsesCorrectlyMaxHeapIfyAndBuildHeapMethodTest (){
        setupStage1();
        Pair<Integer,String> [] array = new Pair[20];
        char character = 'a';
        for (int i = 0; i<array.length; i++){
            array[i] = new Pair<>(i,character+"");
            character++;
        }
        priorityQueue.setArray(array);
        Pair<Integer,String> [] array2 = priorityQueue.getArray();
        System.out.println(Arrays.toString(array2));
    }
}
