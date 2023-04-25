package dataStructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    public static PriorityQueue<Integer,String> priorityQueue;

    /**
     * This stage constructs a MAxPriorityQueue of
     * Integer key and String data with size
     * twenty 
     * */
    public void setupStage1 (){
        priorityQueue = new PriorityQueue<>(20);
    }

}
