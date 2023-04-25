package dataStructures;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack<String> stringStack;
    private Stack<Integer> intStack;

    /**
     * This stage constructs two empty
     * stack to be modified
     * */
    public void setupStage1(){
        this.stringStack = new Stack<>();
        this.intStack = new Stack<>();

    }

    /**
     * This method constructs two stacks
     * with two elements each one to be
     * modified
     * */
    public void setupStage2(){
        this.stringStack = new Stack<>();
        this.intStack = new Stack<>();

        this.intStack.push(1);
        this.intStack.push(2);

        this.stringStack.push("This is");
        this.stringStack.push("a test");
    }

    /**
     * This method validates if the is empty method
     * is right after a stack is instanced. For that,
     * the method uses an assertion
     * */
    @Test
    public void IsEmptyMethodIsRightAfterTheSystemInstancesANewStackTest (){
        setupStage1();

        assertTrue(this.stringStack.isEmpty());
        assertTrue(this.intStack.isEmpty());
    }

    /**
     * This method uses the setupStage2 because
     * this stage has two Stacks with elements
     * saved. After, validates the is empty method
     * with two assertions
     * */
    @Test
    public void IsEmptyMethodReturnsCorrectAnswerTest (){

        setupStage2();

        assertFalse(this.intStack.isEmpty());
        assertFalse(this.stringStack.isEmpty());
    }

    /**
     * This method uses the setupStage1 and
     * adds two elements for each Stack. To
     * check if the method works correctly,
     * uses several assertion after several
     * modifications
     * */
    @Test
    public void itemPushedIsSavedInTheStackTest (){
        setupStage1();

        this.intStack.push(1);
        this.stringStack.push("Test");

        assertEquals(1, this.intStack.top());
        assertEquals("Test", this.stringStack.top());

        this.intStack.push(2);
        this.stringStack.push("Tested");

        assertNotEquals(1, this.intStack.top());
        assertNotEquals("Test", this.stringStack.top());
    }

    /**
     * This method uses the setupStage2 because
     * this stage has some elements saved.
     * This method makes some changes and validates
     * the top of the structures is the correct top
     * */
    @Test
    public void topMethodReturnsTheLastItemSavedTest (){
        setupStage2();

        assertEquals(2, this.intStack.top());
        assertEquals("a test", this.stringStack.top());

        this.intStack.push(3);
        this.stringStack.push("Tested");

        assertEquals(3, this.intStack.top());
        assertEquals("Tested", this.stringStack.top());
    }

    /**
     * This method uses the setupStage1 because this
     * stage has two empty Stacks. To validate if the
     * top method really throws EmptyStackException
     * Exception, the method uses two assertions
     * */
    @Test
    public void topMethodCanThrowEmptyStackExceptionExceptionTest (){

        setupStage1();

        assertThrows(EmptyStackException.class, ()->{
            this.stringStack.top();
        });
        assertThrows(EmptyStackException.class, ()->{
           this.intStack.top();
        });
    }

    /**
     * This method uses the setupStage2 because
     * this stage has some elements saved. This method
     * just validates the element that was deleted
     * of the structure
     * */
    @Test
    public void popMethodDeletesTheLastElementSavedTest (){
        setupStage2();

        assertEquals(2, this.intStack.pop());
        assertEquals("a test", this.stringStack.pop());

        assertEquals(1, this.intStack.top());
        assertEquals("This is", this.stringStack.top());
    }

    /**
     * This method uses the setupStage1 because this
     * stage has two empty Stacks. To validate if the
     * pop method really throws EmptyStackException
     * Exception, the method uses two assertions
     * */
    @Test
    public void popMethodCanThrowEmptyStackExceptionExceptionTest (){

        setupStage1();

        assertThrows(EmptyStackException.class, ()->{
            this.stringStack.pop();
        });
        assertThrows(EmptyStackException.class, ()->{
           this.intStack.pop();
        });
    }
}
