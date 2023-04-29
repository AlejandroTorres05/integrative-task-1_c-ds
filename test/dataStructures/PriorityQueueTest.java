package dataStructures;

import Exceptions.*;
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

    public void setupStage2 (){
        Pair<Integer,String> [] array = new Pair[20];
        char character = 'a';
        for (int i = 0; i<array.length; i++){
            array[i] = new Pair<>(i, character + "");
            character++;
        }
        priorityQueue = new PriorityQueue<>(array);
    }

    /**
     * We think that for test the maxHeapIfy
     * and build test it's just necessary a
     * test method. Because those functionalities
     * are very related between themselves.
     * So for test those functionalities the heap
     * structure has the method setArray
     * */

    /**
     * This method uses the setArray method from
     * PriorityQueue class to construct
     * a priority Queue and finally validates
     * if the array follows the correct order
     * */
    @Test
    public void setArrayMethodUsesCorrectlyMaxHeapIfyAndBuildHeapMethodTest (){
        setupStage1();
        Pair<Integer,String> [] array = new Pair[20];
        char character = 'a';
        for (int i = 0; i<array.length; i++){
            array[i] = new Pair<>(i, character + "");
            character++;
        }
        priorityQueue.setArray(array);
        Pair<Integer,String> [] array2 = priorityQueue.getArray();
        Integer[] num = new Integer[array2.length];
        for (int i = 0; i<num.length; i++){
            num[i] = array2[i].getKey();
        }
        Integer[] expected = {19, 18, 14, 17, 10, 12, 13, 16, 8, 9, 1, 11, 5, 2, 6, 15, 7, 3, 0, 4};

        for (int i = 0; i < expected.length; i++){
            assertEquals(expected[i], num[i]);
        }
    }

    /**
     * This method test if the sort
     * method can organize correctly
     * the heap. For that this method uses
     * the setup stage two and evaluates the
     * order using a predefined array
     * with the right order
     * */
    @Test
    public void sortMethodOrganizeCorrectlyTheElementsSavedInTheHeapTest (){
        setupStage2();
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        Pair<Integer,String> [] pairs = priorityQueue.heapSort();
        Integer[] numbers = new Integer[pairs.length];
        for (int i = 0; i<numbers.length; i++){
            numbers[i] = pairs[i].getKey();
        }
        for (int i = 0; i<numbers.length; i++){
            assertEquals(expected[i], numbers[i]);
        }
    }

    /**
     * This method evaluates if the PriorityQueue
     * can extract the maximum value and keep
     * the structure of the priorityQueue
     * */
    @Test
    public void extractMaximumIsWorkingExtractTheMaxPriorityElementTest (){
        setupStage2();
        Integer int1 = priorityQueue.extractMaximum().getKey();
        Integer int2 = priorityQueue.extractMaximum().getKey();
        Integer int3 = priorityQueue.extractMaximum().getKey();

        assertEquals(19, int1);
        assertEquals(18, int2);
        assertEquals(17, int3);
    }

    /**
     * This method validates if the
     * PriorityQueue can throw EmptyQueueException
     * Exception when the priorityQueue
     * is empty and doesn't have elements
     * */
    @Test
    public void extractMaximumMethodCanThrowEmptyQueueExceptionExceptionTest (){
        setupStage1();

        assertThrows(EmptyQueueException.class, ()->{
            priorityQueue.extractMaximum();
        });
    }

    /**
     * This method inserts a new element with
     * a key mayor than the otter keys in the
     * instanced priorityQueue and validates
     * if the new element was added using the
     * extract max method
     * */
    @Test
    public void insertMethodCanSaveANewElementInThePriorityQueueTest (){
        setupStage2();
        priorityQueue.extractMaximum();
        priorityQueue.insert(new Pair<>(20, "y"));

        Integer element = priorityQueue.extractMaximum().getKey();
        assertEquals(20, element);
    }

    /**
     * This method validates that the
     * insertMethod can save a new element
     * in the front  of the priorityQueue.
     * For that, this method uses an
     * assertNotEquals assertion comparing
     * the las element that was at the front
     * of the priorityQueue
     * */
    @Test
    public void insertMethodCanSaveANewElementInTheFrontOfThePriorityQueueTest (){
        setupStage2();
        priorityQueue.extractMaximum();
        priorityQueue.insert(new Pair<>(20, "y"));

        Integer element = priorityQueue.extractMaximum().getKey();
        assertNotEquals(19, element);
    }

    /**
     * This method validates if the
     * PriorityQueue class can throw
     * QueueIsATCapacityException exception
     * when the priority queue is at
     * capacity and the user tries to
     * add a new element
     * */
    @Test
    public void insertMethodCanThrowQueueIsAtCapacityExceptionExceptionTest (){
        setupStage2();
        assertThrows(QueueIsAtCapacityException.class, ()->{
            priorityQueue.insert(new Pair<>(20, "y"));
        });
    }

    /**
     * This method evaluates if the
     * increaseKey method can increase
     * the key of an element. For that,
     * this method uses an assertEquals
     * assertion that evaluates the new
     * key of an element that must be
     * in a specific position
     * */
    @Test
    public void increaseKeyMethodCanIncreaseTheKeyOfAnEnteredIndexTest (){
        setupStage2();
        priorityQueue.increaseKey(0,25);
        assertEquals(25,priorityQueue.extractMaximum().getKey());
    }

    /**
     * This method evaluates if the increaseKey
     * method can organize correctly the heap
     * when a user changes the key of penultimate
     * element. For that uses an assertNotEquals
     * assertion that compare the first element key
     * with the new element key
     * */
    @Test
    public void increaseKeyMethodCanReorganizeCorrectlyAnElementInTheHeapStructureTest (){
        setupStage2();
        priorityQueue.increaseKey(19, 22);
        assertNotEquals(19, priorityQueue.maximum().getKey());
    }

    /**
     * This method evaluates if the priorityQueue
     * can throw the IllegalArgumentException
     * exception when a user tries to change the
     * key for a minor key
     * */
    @Test
    public void increaseMethodCanThrowsIllegalArgumentExceptionWheTheNewKeyIsMinorThanTheActualKeyTest (){
        setupStage2();
        assertThrows(IllegalArgumentException.class, ()->{
            priorityQueue.increaseKey(15, 0);
        });
    }
}
