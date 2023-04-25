package dataStructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue<Integer> numbers;
    public Queue<String> words;

    /**
     * This stage constructs two Queue from
     * two arrays. One is an Integer array and the
     * another is a String array
     * @Post: After a call of this method, there must be
     *              two queues whit nine Integers and five
     *              Strings respectively
     * */
    public void setupStage1 (){
        Integer[] array1 = {0,1,2,3,4,5,6,7,8,9};
        this.numbers = new Queue<>(array1);
        String[] array2 = {"a","e","i","o","u"};
        this.words = new Queue<>(array2);
    }

    /**
     * This stage constructs a Queue with five elements
     * and constructs another Queue without elements
     * @Post: After a call of this method, there must be
     *                  an empty Queue and a Queue whit
     *                  elements inside
     * */
    public void setupStage2 (){
        String[] array = {"a","e","i","o","u"};

        this.numbers = new Queue<>();
        this.words = new Queue<>(array);
    }

    /**
     * This stage constructs two empty Queues.
     * @Post: After a call of this method, there must be
     *                  two empty Queues in the system
     * */
    public void setupStage3 (){
        this.numbers = new Queue<>();
        this.words = new Queue<>();
    }

    /**
     * This method uses the setupStage1 and
     * check if there are elements saved in the
     * two Queues
     * */
    @Test
    public void constructsAQueueFromAnArrayTest (){
        setupStage1();

        assertFalse(this.numbers.isEmpty());
        assertFalse(this.words.isEmpty());
    }

    /**
     * This method uses the setupStage1 and
     * checks if the elements saved are in the
     * correct order
     * */
    @Test
    public void constructedQueueHasTheCorrectElementsTest (){
        setupStage1();

        int numb1 = this.numbers.deQueue();
        int numb2 = this.numbers.deQueue();

        String word1 = this.words.deQueue();
        String word2 = this.words.deQueue();

        assertEquals(0,numb1);
        assertEquals(1,numb2);
        assertEquals("a",word1);
        assertEquals("e",word2);
    }

    /**
     * This method uses the setupStage1 and checks
     * that the Queue isn't saving elements incorrectly.
     * For that, the method uses assertNotEquals whit
     * elements ordered in unexpected order at the
     * structure
     * */
    @Test
    public void constructedQueueHasNotIncorrectElementsTest (){
        setupStage1();

        int numb1 = this.numbers.deQueue();
        int numb2 = this.numbers.deQueue();

        String word1 = this.words.deQueue();
        String word2 = this.words.deQueue();

        assertNotEquals(5,numb1);
        assertNotEquals(4,numb2);
        assertNotEquals("u",word1);
        assertNotEquals("o",word2);
    }

    /**
     * This method uses the setupStage2 and just
     * validates if the actual Queues are empty or not
     * */
    @Test
    public void isEmptyMethodReturnsTheCorrectBooleanTest (){
        setupStage2();

        assertTrue(this.numbers.isEmpty());
        assertFalse(this.words.isEmpty());
    }

    /**
     * This method uses the setupStage3 and has two steps.
     * The first step, is that validates the initial conditions,
     * their must be right. The second step, is that the method
     * make any changes in the structure. And finally, the last
     * assertions must be right
     * */
    @Test
    public void isEmptyMethodReactsCorrectlyAfterAChangeInTheStructureTest(){
        setupStage3();

        assertTrue(this.numbers.isEmpty());
        assertTrue(this.words.isEmpty());

        this.numbers.enQueue(12);
        this.numbers.enQueue(22);

        assertFalse(this.numbers.isEmpty());
        assertTrue(this.words.isEmpty());

    }

    /**
     * This method uses the setupsStage3 and makes changes
     * to validate if the enQueue method works correctly
     * */
    @Test
    public void enQueueMethodPutsANewElementInTheQueueTest (){
        setupStage3();

        this.numbers.enQueue(1);
        this.words.enQueue("hello");

        assertFalse(this.words.isEmpty());
        assertFalse(this.numbers.isEmpty());
    }

    /**
     * This method uses the setupStage1 and makes
     * some changes in the setup to check in the
     * enQueue method is putting the new element at
     * the end of the structure
     * */
    @Test
    public void enQueueMethodPutTheNewElementAtTheEndOfTheStructureTest (){
        setupStage1();

        this.numbers.enQueue(10);
        int number = 0;
        while (!this.numbers.isEmpty()){
            number = this.numbers.deQueue();
        }

        this.words.enQueue("hello");
        String word = "";
        while (!this.words.isEmpty()){
            word = this.words.deQueue();
        }

        assertEquals(10, number);
        assertEquals("hello", word);
    }

    @Test
    public void deQueueMethodequeue
}
