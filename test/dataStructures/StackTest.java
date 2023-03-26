package dataStructures;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack<String> stringStack;
    private Stack<Integer> intStack;

    public void setup1 (){
        this.stringStack = new Stack<>();
        this.intStack = new Stack<>();

    }

    public void setup2 (){
        this.stringStack = new Stack<>();
        this.intStack = new Stack<>();

        this.intStack.push(1);
        this.intStack.push(2);

        this.stringStack.push("This is");
        this.stringStack.push("a test");
    }
    @Test
    public void newStackInstancedIsEmptyTest (){
        setup1();

        assertThrows(EmptyStackException.class, ()->{
            this.stringStack.top();
        });
        assertThrows(EmptyStackException.class, ()->{
           this.intStack.top();
        });
    }

    @Test
    public void methodIsEmptyReturnsCorrectAnswerTest (){
        setup1();

        assertTrue(this.intStack.isEmpty());
        assertTrue(this.stringStack.isEmpty());

        setup2();

        assertFalse(this.intStack.isEmpty());
        assertFalse(this.stringStack.isEmpty());

    }

    @Test
    public void itemPushedIsSavedInTheStackTest (){
        setup1();

        this.intStack.push(1);
        this.stringStack.push("Test");

        assertEquals(1, this.intStack.top());
        assertEquals("Test", this.stringStack.top());

        this.intStack.push(2);
        this.stringStack.push("Tested");

        assertNotEquals(1, this.intStack.top());
        assertNotEquals("Test", this.stringStack.top());
    }

    @Test
    public void topMethodReturnsTheLastItemSavedTest (){
        setup2();

        assertEquals(2, this.intStack.top());
        assertEquals("a test", this.stringStack.top());

        this.intStack.push(3);
        this.stringStack.push("Tested");

        assertNotEquals(2, this.intStack.top());
        assertNotEquals("a test", this.stringStack.top());
    }

    @Test
    public void popMethodDeletesTheLastElementSavedTest (){
        setup2();

        assertEquals(2, this.intStack.pop());
        assertEquals("a test", this.stringStack.pop());

        assertEquals(1, this.intStack.top());
        assertEquals("This is", this.stringStack.top());
    }
}
